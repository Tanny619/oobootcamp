package com.thoughtworks;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

public class SmartRobot extends BagRobot{

    private final SmartRobotStrategy smartRobotStrategy = new SmartRobotStrategy(this);
    private List<Locker> lockers;

    public SmartRobot(ArrayList<Locker> lockers) {
        super(lockers);
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        return smartRobotStrategy.store(bag);
    }

    private Locker getBestLocker() {
        Ordering<Locker> ordering = new Ordering<Locker>() {
            @Override
            public int compare(Locker locker, Locker locker2) {
                return (int) (locker.getAvailableRatio() - locker2.getAvailableRatio());
            }
        };
        return ordering.max(lockers);
    }
}
