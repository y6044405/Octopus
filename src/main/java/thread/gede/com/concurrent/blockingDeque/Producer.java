package thread.gede.com.concurrent.blockingDeque;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {

    private String name;

    private BlockingDeque<String> deque = null;

    public Producer(String name, BlockingDeque<String> deque) {
        this.name = name;
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            deque.add("p" + i);
        }
        for (int i = 0; i < 10; i++) {
            try {
                String take = deque.take();
                System.out.println("p takes" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
