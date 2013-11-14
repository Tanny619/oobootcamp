package com.thoughtworks;

import java.util.ArrayList;

public class BagRobot {
    private ArrayList<Locker> lockers;
    private LockerStrategy strategy;

    BagRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public BagRobot(ArrayList<Locker> lockers, LockerStrategy strategy) {
        this.lockers = lockers;
        this.strategy = strategy;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        Locker result = strategy.getBestLocker(lockers);
        return result.store(bag);
    }

    public Bag pick(Ticket ticket) {
        for (Locker locker : lockers) {
            Bag bag = locker.pick(ticket);
            if (bag != null){
                return bag;
            }
        }
        return null;
    }

}
