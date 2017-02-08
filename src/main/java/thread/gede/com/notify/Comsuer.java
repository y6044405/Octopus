package thread.gede.com.notify;

public class Comsuer implements Runnable {

    private String name;

    private Box box = null;

    public Comsuer(String name, Box box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Bread bread = box.pop();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者 ：" + name + "消费了 面包" + bread.getId());
        }
    }

}
