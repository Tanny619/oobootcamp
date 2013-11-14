import com.google.common.collect.Lists;
import com.thoughtworks.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BalanceRobotTest {
    @Test
    public void should_store_bag() throws LockerFullException {
        Bag bag = new Bag();
        Bag bag1 = new Bag();

        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(5);

        BagRobot balanceRobot = new BagRobot(Lists.newArrayList(locker1, locker2), new BalanceStrategy());
        balanceRobot.store(bag);
        Ticket ticket = balanceRobot.store(bag1);
        assertThat(locker2.pick(ticket), is(bag1));
    }


}
