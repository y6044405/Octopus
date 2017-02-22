package thread.gede.com.concurrent.DelayQueue.produce;

import java.util.concurrent.DelayQueue;

import thread.gede.com.concurrent.DelayQueue.DelayItem;

public class Consumer implements Runnable {

    private DelayQueue<DelayItem<String>> queue = null;

    public Consumer(DelayQueue<DelayItem<String>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            DelayItem<String> take = queue.take();
            System.out.println("consume a item,value is " + take.getItem());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
