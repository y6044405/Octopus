package thread.gede.com.concurrent.DelayQueue.produce;

import java.util.concurrent.DelayQueue;

import thread.gede.com.concurrent.DelayQueue.DelayItem;

public class Test {

    public static void main(String[] args) {
        DelayQueue<DelayItem<String>> queue = new DelayQueue<DelayItem<String>>();
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }

}
