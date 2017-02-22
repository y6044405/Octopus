package thread.gede.com.concurrent.blockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeTest {

    public static void main(String[] args) {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        Producer producer = new Producer("producer", deque);
        Consumer consumer = new Consumer("consumer", deque);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }

}
