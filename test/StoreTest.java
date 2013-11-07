import com.thoughtworks.Bag;
import com.thoughtworks.Locker;
import com.thoughtworks.LockerFullException;
import com.thoughtworks.Ticket;
import org.junit.Test;

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

}
