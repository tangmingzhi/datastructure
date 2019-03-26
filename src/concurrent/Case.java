package concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangkun
 * @date 2019-02-28
 */
public class Case {

    public volatile int n;

    public int a;

    public static final int COUNT = 10000;

    public  void addUseVolatile() {
        n++;
    }

    public synchronized void addUseSynchronized() {
        a++;
    }

    final  ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Test
     public void testAddUseVolatile(){

        for (int i = 0; i < COUNT; i++) {
            executorService.submit((Runnable) () -> addUseVolatile());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}

        Assert.assertEquals(COUNT, n);
    }


    @Test
    public void testAddUseSynchronized(){

        for (int i = 0; i < COUNT; i++) {
            executorService.submit((Runnable) () -> addUseSynchronized());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}

        Assert.assertEquals(COUNT, a);
    }
}
