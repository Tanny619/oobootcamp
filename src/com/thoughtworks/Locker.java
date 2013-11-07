package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> map = new HashMap<Ticket, Bag>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket Store(Bag bag) throws LockerFullException {
        if(map.size() < capacity){
            Ticket ticket = new Ticket();
            map.put(ticket, bag);
            return ticket;
        }
        throw new LockerFullException();
    }

    public Bag pick(Ticket ticket) {
        return map.get(ticket);
    }
}
