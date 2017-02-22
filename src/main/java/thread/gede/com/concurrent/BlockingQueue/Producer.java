package thread.gede.com.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private String name;

    private BlockingQueue<UserRequest> queue = null;

    public Producer(String name, BlockingQueue<UserRequest> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                UserRequest userRequest = new UserRequest(i + 1);
                queue.put(userRequest);
                System.out.println("用户伺服器" + name + "接受了第" + userRequest.getId() + "个用户请求");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
