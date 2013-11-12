import com.google.common.collect.Lists;
import com.thoughtworks.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SmartRobotTest {
    @Test
    public void should_store_bag_in_most_empty_locker() throws LockerFullException {
        Bag bag = new Bag();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);

        SmartRobot smartRobot = new SmartRobot(Lists.newArrayList(locker1, locker2));
        Ticket ticket = smartRobot.store(bag);
        assertThat(locker2.pick(ticket),is(bag));
    }

//    @Test
//    public void should_should_store_bag_when_full(){
//        Bag bag = new Bag();
//        Locker locker = new Locker(1);
//        SmartRobot smartRobot = new SmartRobot(Lists.newArrayList(locker));
//
//        assertThat (smartRobot.store(bag),is());
//
//
//    }
}
