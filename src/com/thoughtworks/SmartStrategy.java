package com.thoughtworks;

import com.google.common.collect.Ordering;

import java.util.List;

public class SmartStrategy implements LockerStrategy {
    public Locker getBestLocker(List<Locker> lockers) {
        Ordering<Locker> ordering = new Ordering<Locker>() {
            @Override
            public int compare(Locker locker, Locker locker2) {
                return locker.availableCount - locker2.availableCount;
            }
        };

        return ordering.max(lockers);
    }
}
