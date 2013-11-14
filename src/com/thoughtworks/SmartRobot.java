package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class SmartRobot extends BagRobot{

    private List<Locker> lockers;

    public SmartRobot(ArrayList<Locker> lockers) {
        super(lockers);
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        Locker bestLocker = new SmartStrategy().getBestLocker(lockers);
        return bestLocker.store(bag);
    }

}
