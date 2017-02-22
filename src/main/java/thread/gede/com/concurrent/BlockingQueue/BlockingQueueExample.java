package thread.gede.com.concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<UserRequest> queue = new ArrayBlockingQueue<>(1024);
        Producer producer = new Producer("国产007", queue);
        Consumer consumer = new Consumer("绞肉机T2", queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }

}
