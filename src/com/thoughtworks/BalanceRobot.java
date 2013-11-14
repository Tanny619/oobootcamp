package com.thoughtworks;

import java.util.ArrayList;

public class BalanceRobot extends BagRobot {

    private ArrayList<Locker> lockers;

    public BalanceRobot(ArrayList<Locker> lockers) {
        super(lockers);
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        Locker bestLocker = new BalanceStrategy().getLocker(lockers);
        return bestLocker.store(bag);
    }
}
