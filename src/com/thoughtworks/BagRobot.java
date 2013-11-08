package com.thoughtworks;

import java.util.ArrayList;

public class BagRobot {
    private ArrayList<Locker> lockers;

    public BagRobot(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        for (Locker locker : lockers) {
            if(locker.available()){
                return locker.Store(bag);
            }
        }
        throw new LockerFullException();
    }
}
