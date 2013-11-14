import com.thoughtworks.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class LockerTest {

    @Test
    public void should_store_one_bag() throws LockerFullException {
        Locker locker = new Locker(1);
        Ticket ticket = locker.store(new Bag());

        assertThat(ticket, notNullValue());
    }

    @Test(expected = LockerFullException.class)
    public void should_throw_error_when_locker_full() throws LockerFullException {
        Locker locker = new Locker(0);
        locker.store(new Bag());
    }

    @Test
    public void should_pick_one_bag() throws LockerFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);

        assertThat(locker.pick(ticket), is(bag));
    }

    @Test
    public void should_unable_to_reuse_ticket() throws LockerFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);
        locker.pick(ticket);

        assertThat(locker.pick(ticket), nullValue());
    }

    @Test
    public void should_not_able_to_pick_with_invalid_ticket() throws LockerFullException {
        Locker locker = new Locker(1);
        assertThat(locker.pick(new Ticket(locker)), nullValue());
    }

    @Test
    public void should_pick_among_multiple_bags() throws LockerFullException {
        Locker locker = new Locker(3);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);
        locker.store(new Bag());

        assertThat(locker.pick(ticket), is(bag));
    }
}
