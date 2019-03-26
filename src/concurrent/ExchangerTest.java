package concurrent;

import org.junit.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author tangkun
 * @date 2019-03-15
 */
public class ExchangerTest {

    @Test
    public void testExchange() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                String msg =     exchanger.exchange("I'm is thread1");
                System.out.println("t1 arrive msg:"+msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg =   exchanger.exchange("I'm is thread2");
                    System.out.println("t2 arrive msg:"+msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg =   exchanger.exchange("I'm is thread3");
                    System.out.println("t3 arrive msg:"+msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg =   exchanger.exchange("I'm is thread4");
                    System.out.println("t4 arrive msg:"+msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        TimeUnit.SECONDS.sleep(3);
    }
}
