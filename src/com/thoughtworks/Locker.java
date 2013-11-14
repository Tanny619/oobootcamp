package com.thoughtworks;

import com.google.common.collect.Maps;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> map = Maps.newHashMap();
    public int availableCount;

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCount = capacity;
    }

    public Ticket store(Bag bag) throws LockerFullException {
        if(available()){
            Ticket ticket = new Ticket(this);
            map.put(ticket, bag);
            availableCount--;
            return ticket;
        }
        throw new LockerFullException();
    }

    public boolean available() {
        return map.size() < capacity;
    }

    public Bag pick(Ticket ticket) {
        if (map.isEmpty())
            return null;

        Bag bag = map.get(ticket);
        map.remove(ticket);
        availableCount++;
        return bag;
    }

    public double getAvailableRatio() {
        return availableCount/capacity;
    }
}
