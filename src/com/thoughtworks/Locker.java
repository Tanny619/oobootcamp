package com.thoughtworks;

import com.google.common.collect.Maps;

import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> map = Maps.newHashMap();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket Store(Bag bag) throws LockerFullException {
        if(available()){
            Ticket ticket = new Ticket();
            map.put(ticket, bag);
            return ticket;
        }
        throw new LockerFullException();
    }

    public boolean available() {
        return map.size() < capacity;
    }

    public Bag pick(Ticket ticket) {
        Bag bag = map.get(ticket);
        map.remove(ticket);
        return bag;
    }
}
