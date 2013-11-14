package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public interface LockerStrategy {
    Locker getBestLocker(List<Locker> lockers);
}
