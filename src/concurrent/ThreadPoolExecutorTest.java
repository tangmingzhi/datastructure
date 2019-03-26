package concurrent;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangkun
 * @date 2019-03-12
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 100, 20, TimeUnit.HOURS, new ArrayBlockingQueue(100));
        int b = 0;
        final AtomicInteger integer = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(integer.incrementAndGet());
                }
            });
        }
        executor.shutdown();
        System.out.println("shutdown in called");
        while (!executor.isTerminated()){}


    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {

       final SynchronousQueue<Integer> sq = new SynchronousQueue();
       Thread putThread = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("put1 thread start");
               try {
                   sq.put(1);
               }catch (InterruptedException ex){

               }
               System.out.println("put1 thread end");
           }
       });
        Thread putThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put2 thread start");
                try {
                    sq.put(2);
                }catch (InterruptedException ex){

                }
                System.out.println("put2 thread end");
            }
        });

//        Thread takeThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("take thread start");
//                try{
//                    System.out.println("take form putThread:"+ sq.take());
//                }catch (InterruptedException ex){
//
//                }
//                System.out.println("take thread end");
//            }
//        });

        putThread.start();
        putThread2.start();
        Thread.sleep(100000);
//        takeThread.start();
    }

    @Test
    public void testPriorityBlockingQueue() throws InterruptedException {

        PriorityBlockingQueue pbq = new PriorityBlockingQueue();
        System.out.println("queue poll");
        System.out.println("poll element"+pbq.poll());
    }

    @Test
    public void testShutDown(){



    }

    /**
     * 测试线程中断后调用阻塞方法
     * 线程被中断，调用
     */
    @Test
    public void testInterrupt() throws InterruptedException {

        final Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello world");
            }
        });
        thread.start();
        thread.interrupt();
        TimeUnit.SECONDS.sleep(100);
    }


}
