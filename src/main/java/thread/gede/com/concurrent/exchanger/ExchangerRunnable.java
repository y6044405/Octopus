package thread.gede.com.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

    private Exchanger<String> exchanger = null;

    private Object object = null;

    public ExchangerRunnable(Exchanger<String> exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange((String) this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
