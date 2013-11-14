package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class NormalStrategy implements LockerStrategy {
    @Override
    public Locker getBestLocker(List<Locker> lockers) {
        Locker result = new Locker(0);
        for (Locker locker : lockers) {
            if(locker.available()){
                result = locker;
                break;
            }
        }
        return result;
    }
}
