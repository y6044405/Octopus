package thread.gede.com.concurrent.blockingDeque;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {

    private String name;

    private BlockingDeque<String> deque = null;

    public Consumer(String name, BlockingDeque<String> deque) {
        this.deque = deque;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            deque.add("c" + i);
        }
        for (int i = 0; i < 10; i++) {
            try {
                String take = deque.take();
                System.out.println("c takes" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
