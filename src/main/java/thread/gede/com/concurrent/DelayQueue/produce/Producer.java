package thread.gede.com.concurrent.DelayQueue.produce;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

import thread.gede.com.concurrent.DelayQueue.DelayItem;

public class Producer implements Runnable {

    private DelayQueue<DelayItem<String>> queue = null;

    public Producer(DelayQueue<DelayItem<String>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        DelayItem<String> a = new DelayItem<String>("aaa", TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));
        queue.put(a);
        System.out.println("produce a item,vlaue is aaa");
    }

}
