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
        int max_locker = 0;
        int max_index = 0;
        for (int i = 0; i < lockers.size(); i++) {
            if(lockers.get(i).availableCount > max_locker ) {
                max_locker = lockers.get(i).availableCount;
                max_index = i;
            }
        }
        return lockers.get(max_index).Store(bag);
    }



}
