package com.thoughtworks;

import com.google.common.collect.Ordering;

import java.util.ArrayList;

public class BalanceRobot extends BagRobot {

    private ArrayList<Locker> lockers;

    public BalanceRobot(ArrayList<Locker> lockers) {
        super(lockers);
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        Ordering<Locker> ordering = new Ordering<Locker>() {
            @Override
            public int compare(Locker locker, Locker locker2) {
                return (int)(locker.getAvailableRatio() - locker2.getAvailableRatio());
            }
        };
        return ordering.max(lockers).store(bag);
    }

}
