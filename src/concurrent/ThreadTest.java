package concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tangkun
 * @date 2019-03-17
 */
public class ThreadTest {

    @Test
    public void testJoin() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" called");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" called");
            }
        });



        t1.start();
        t1.join(10);

        t2.start();
        t2.join(10);

        System.out.println(Thread.currentThread()+" die");
    }


    @Test
    public void testInterrupt(){

        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    SleepUtils.second(10);
                }
            }
        });

        Thread busyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                   // System.out.println(Thread.currentThread() + "is running");
                }
            }
        });


        sleepThread.setDaemon(true);
        sleepThread.start();

        busyThread.setDaemon(true);
        busyThread.start();
        SleepUtils.second(1);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread interrupted " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted " + busyThread.isInterrupted());

        SleepUtils.second(3);
        System.out.println(Thread.currentThread() + "is dea");
    }

    private static final int[] array = new int[80000];




    static {

        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(i + 1);
        }

    }
    private static int sort(int[] array) {

        for (int i = 0; i < array.length-1; i++){
            for(int j = 0 ;j < array.length - i - 1; j++){
                if(array[j] < array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array[0];

    }
    @Test
    public void testStop(){
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println(sort(array));
                } catch (Error err) {
                    err.printStackTrace();
                }
                System.out.println("in thread t");

            }

        };

            t.start();
            SleepUtils.second(1);
            System.out.println("go to stop thread t");
            t.stop();

            System.out.println("finish main");



    }
}
