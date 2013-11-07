import com.thoughtworks.*;
import org.junit.Test;
import com.google.common.collect.Collections2;

import java.util.ArrayList;

import static junit.framework.Assert.*;

public class StoreTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_store_bag() throws Exception, LockerFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.Store(bag);
        assertNotNull(ticket);
    }

    @Test(expected = LockerFullException.class)
    public void should_not_store_when_full() throws LockerFullException {
        Locker locker = new Locker(1);
        locker.Store(new Bag());
        locker.Store(new Bag());
    }

    @Test
    public void should_pick_bag() throws LockerFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.Store(bag);
        assertNotNull(ticket);
        assertEquals(bag, locker.pick(ticket));
    }

    @Test
    public void should_pick_among_multiple_bags() throws LockerFullException {
        Locker locker = new Locker(3);
        Bag bag = new Bag();
        Ticket ticket = locker.Store(bag);
        locker.Store(new Bag());
        assertEquals(bag, locker.pick(ticket));
    }

    @Test
    public void should_robot_store_bag() throws LockerFullException {
        Bag bag = new Bag();
        Locker locker = new Locker(5);
        BagRobot robot = new BagRobot(locker);
        Ticket ticket = robot.store(bag);
        assertSame(bag, locker.pick(ticket));
    }



    @Test
    public void should_robot_store_bags() throws LockerFullException {
        Bag bag = new Bag();
        Bag bag1 = new Bag();
        Locker locker1 = new Locker(5);
        BagRobot bagRobot = new BagRobot(locker1);
        Ticket ticket1 = bagRobot.store(bag1);
        Ticket ticket = bagRobot.store(bag);

        assertSame(bag,locker1.pick(ticket));
    }

    @Test
    public void should_robot_store_in_different_lockers() throws LockerFullException {
        Bag bag = new Bag();
        Bag bag1 = new Bag();
        Locker locker = new Locker(1);
        Locker locker1 = new Locker(1);
        ArrayList<Locker> lockers = new ArrayList<Locker>() { };
        lockers.add(locker);
        lockers.add(locker1);
        BagRobot bagRobot = new BagRobot(lockers);
        Ticket ticket = bagRobot.store(bag);
        Ticket ticket1 = bagRobot.store(bag1);

        assertSame(bag,locker.pick(ticket));
        assertSame(bag1,locker1.pick(ticket1));



    }



}
