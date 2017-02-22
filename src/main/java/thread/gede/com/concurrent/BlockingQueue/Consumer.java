package thread.gede.com.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private String name;

    private BlockingQueue<UserRequest> queue = null;

    public Consumer() {

    }

    public Consumer(String name, BlockingQueue<UserRequest> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                UserRequest take = queue.take();
                System.out.println("后台伺服器" + this.name + "处理了第" + take.getId() + "个用户请求");
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
