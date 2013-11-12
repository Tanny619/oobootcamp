package com.thoughtworks;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

public class SmartRobot extends BagRobot{

    private List<Locker> lockers;

    public SmartRobot(ArrayList<Locker> lockers) {
        super(lockers);
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        Ordering<Locker> ordering = new Ordering<Locker>() {
            @Override
            public int compare(Locker locker, Locker locker2) {
                return locker.availableCount - locker2.availableCount;
            }
        };
        return ordering.max(lockers).store(bag);
    }
}
