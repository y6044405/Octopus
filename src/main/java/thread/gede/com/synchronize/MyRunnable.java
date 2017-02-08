package thread.gede.com.synchronize;

public class MyRunnable implements Runnable {

    private Foo foo = null;

    public MyRunnable(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.fix(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName() + " :当前foo对象的x值= " + foo.getX());
        }
    }

    private int fix(int y) {
        return foo.fix(y);
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        MyRunnable r = new MyRunnable(foo);
        Thread ta = new Thread(r, "Thread-A");
        Thread tb = new Thread(r, "Thread-B");
        ta.start();
        tb.start();
    }

}
