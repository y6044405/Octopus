package thread.gede.com.notify;

public class Producer implements Runnable {

    private String name;

    private Box box = null;

    public Producer(String name, Box box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bread bread = new Bread(i);
            box.push(bread);
            System.out.println("生产者 ： " + name + "生产了面包" + bread.getId());
        }
    }

}
