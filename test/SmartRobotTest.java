import com.google.common.collect.Lists;
import com.thoughtworks.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SmartRobotTest {
    @Test
    public void should_store_bag_in_most_empty_locker() throws LockerFullException {
        Bag bag = new Bag();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(5);

        BagRobot smartRobot = new BagRobot(Lists.newArrayList(locker1, locker2), new SmartStrategy());
        Ticket ticket = smartRobot.store(bag);
        assertThat(locker2.pick(ticket),is(bag));
    }

    @Test
    public void should_should_store_bag_when_full() throws LockerFullException {
        Boolean throwException = false;
        Bag bag = new Bag();
        Locker locker = new Locker(0);
        BagRobot smartRobot = new BagRobot(Lists.newArrayList(locker), new SmartStrategy());
        try {
            smartRobot.store(bag);
        } catch (LockerFullException e) {
            throwException = true;
        }
        assertTrue(throwException);
    }




}
