package concurrent;

import org.junit.Test;

import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangkun
 * @date 2019-03-06
 */
public class ReentrantLockTest {
    final ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    @Test
    public void testLock() throws InterruptedException {

        Thread t1 = new X();
        Thread t2 = new X();
        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1000);


    }

    @Test
    public void testNewCondition(){



    }

    public void conditionAwait()throws InterruptedException{

        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException{

        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }


 class  X extends Thread{

     @Override
     public void run() {
         try {
             System.out.println("lock thread name\t"+Thread.currentThread().getName() + " \ttime\t"+System.currentTimeMillis());
             lock.lock();
             System.out.println("locked thread name\t"+Thread.currentThread().getName()+ "\ttime\t"+System.currentTimeMillis());
             TimeUnit.SECONDS.sleep(300);
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
             System.out.println("unlock thread name\t"+Thread.currentThread().getName() + " \ttime\t"+System.currentTimeMillis());
         }
     }
 }
}
