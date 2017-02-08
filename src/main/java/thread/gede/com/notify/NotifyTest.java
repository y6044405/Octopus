package thread.gede.com.notify;

public class NotifyTest {

    public static void main(String[] args) {

        Box box = new Box();
        Producer p1 = new Producer("厨师", box);
        Comsuer c1 = new Comsuer("吃货", box);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }

}
