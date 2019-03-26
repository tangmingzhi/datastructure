package concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangkun
 * @date 2019-03-07
 */
public class BoundedBuffer {

    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[10];

    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException{

        lock.lock();

        try {
            while (count == items.length) {
                notFull.await();
                System.out.println("put 被唤醒");
            }

            items[putptr] = x;


            ++count;
            System.out.println("put count:"+count);
            if (++putptr == items.length) {
                putptr = 0;
                notEmpty.signal();
            }


        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException{

        lock.lock();

        try{
            while (count == 0){
                notEmpty.await();
                System.out.println("take 被唤醒");
            }

            Object x = items[takeptr];

            System.out.println("take count:"+count);
            --count;
            if(++takeptr == items.length){
                takeptr = 0;
                notFull.signal();
            }
            return x;
        }finally {
            lock.unlock();
        }
    }


    @Test
    public void testAwait() throws InterruptedException {

//        PutterThread putterThread = new PutterThread();
//        TakerThread takerThread = new TakerThread();
//        putterThread.start();
//        takerThread.start();

        AwaitThread awaitThread  = new AwaitThread();
        awaitThread.start();
        System.out.println("await 30s");
        TimeUnit.SECONDS.sleep(30);
        SignalThread signalThread = new SignalThread();
        signalThread.start();

        TimeUnit.SECONDS.sleep(300);
    }

    class PutterThread extends Thread{
        @Override
        public void run() {
            Integer i = 0;
            try {
                while (true) {
                    put(i++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class TakerThread extends  Thread{
        @Override
        public void run() {
            try {
                while (true) {
                    take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class AwaitThread extends Thread{

        @Override
        public void run() {

            lock.lock();
            try {
                System.out.println("await线程进入阻塞状态");
                notFull.await();
                System.out.println("await方法返回，当前线程已抢占到锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    class SignalThread extends  Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                notFull.signal();
                System.out.println("condition通知await等待线程");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
