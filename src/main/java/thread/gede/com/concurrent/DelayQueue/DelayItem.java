package thread.gede.com.concurrent.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DelayItem<T> implements Delayed {

    /** Base of nanosecond timings, to avoid wrapping */
    private static final long NANO_ORIGN = System.nanoTime();

    /**
     * Returns nanosecond time offset by origin
     * @author:  wyf 
     * @return
     */
    final static long now() {
        long now = System.nanoTime() - NANO_ORIGN;
        System.out.println("DelayItem's now(): " + now);
        return now;
    }

    /** Sequence number to break scheduling ties, and in turn to guarantee FIFO order among tied entries.*/
    private static final AtomicLong sequencer = new AtomicLong(0);

    /** Sequence number to break ties FIFO */
    private long sequenceNumber;

    /** The time the task is enabled to execute in nanoTime units */
    private long time;

    private T item;

    public DelayItem(T submit, long timeout) {
        this.time = timeout + now();
        this.item = submit;
        this.sequenceNumber = sequencer.getAndIncrement();
        System.out.println("DelayItem instance's time: " + this.time);
    }

    public T getItem() {
        return this.item;
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) // compare zero ONLY if same object
            return 0;
        if (other instanceof DelayItem) {
            DelayItem x = (DelayItem) other;
            long diff = time - x.time;
            if (diff < 0)
                return -1;
            else if (diff > 0)
                return 1;
            else if (sequenceNumber < x.sequenceNumber)
                return -1;
            else
                return 1;
        }
        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = time - now();
        System.out.println("DelayItem instance's delay is :" + delay);
        return unit.convert(delay, TimeUnit.NANOSECONDS);
    }

}
