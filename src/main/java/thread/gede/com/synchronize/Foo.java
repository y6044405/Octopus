package thread.gede.com.synchronize;

public class Foo {

    private int x = 100;

    public int getX() {
        return x;
    }

    public synchronized int fix(int y) {
        System.out.println(Thread.currentThread().getName());
        x = x - y;
        System.out.println(x);
        return x;
    }

}
