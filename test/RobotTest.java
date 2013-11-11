import com.google.common.collect.Lists;
import com.thoughtworks.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RobotTest {

    @Test
    public void should_robot_store_one_bag() throws LockerFullException {
        Bag bag = new Bag();
        Locker locker = new Locker(5);
        BagRobot robot = new BagRobot(Lists.newArrayList(locker));

        Ticket ticket = robot.store(bag);

        assertThat(locker.pick(ticket), is(bag));
    }


    @Test
    public void should_robot_store_bags_to_one_locker() throws LockerFullException {
        Bag bag = new Bag();
        Locker locker = new Locker(5);
        BagRobot bagRobot = new BagRobot(Lists.newArrayList(locker));

        Ticket ticket = bagRobot.store(bag);
        bagRobot.store(new Bag());

        assertThat(locker.pick(ticket), is(bag));
    }

    @Test(expected = LockerFullException.class)
    public void should_throw_exception_when_all_lockers_full() throws LockerFullException {
//        Bag bag = new Bag();
//        Locker locker = new Locker(0);
//        BagRobot bagRobot = new BagRobot(Lists.newArrayList(locker));
//
//        bagRobot.store(bag);

        Bag bag = new Bag();
        Bag bag1 = new Bag();
        Locker locker = new Locker(1);
        BagRobot bagRobot = new BagRobot(Lists.newArrayList(locker));
        bagRobot.store(bag);
        bagRobot.store(bag1);


    }

    @Test
    public void should_robot_store_multiple_bags_in_different_lockers() throws LockerFullException {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        Bag bag3 = new Bag();
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(1);

        BagRobot bagRobot = new BagRobot(Lists.newArrayList(locker1, locker2));

        Ticket ticket1 = bagRobot.store(bag1);
        Ticket ticket2 = bagRobot.store(bag2);
        Ticket ticket3 = bagRobot.store(bag3);

        assertThat(locker1.pick(ticket1), is(bag1));
        assertThat(locker1.pick(ticket2), is(bag2));
        assertThat(locker2.pick(ticket3), is(bag3));
    }

}
