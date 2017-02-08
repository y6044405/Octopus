package thread.gede.com.SymmetricEncryption;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            EncryptService service = new EncryptService();
            try {
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户输入密码...");
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码，正在加密...");
                String encode = service.encode("12345678");
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码，加密完成");
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码加密为：" + encode);
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码，正在解密...");
                String decode = service.decode(encode);
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码，解密完成");
                System.out.println(Thread.currentThread().getName() + "第" + i + "个用户的密码解密为：" + decode);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ThreadTest test = new ThreadTest();
            Thread t = new Thread(test, "Thread-" + i);
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
    }

}
