package thread.gede.com.concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        Runnable barrier1Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 1 executed ");
            }
        };

        Runnable barrier2Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 2 executed ");
            }
        };

        //barrierAction栅栏行动，将会在最后等待栅栏的线程到达后执行
        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnble1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable barrierRunnble2 = new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnble1).start();
        new Thread(barrierRunnble2).start();
    }

}
