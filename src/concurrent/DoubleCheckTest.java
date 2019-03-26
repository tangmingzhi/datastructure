package concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author tangkun
 * @date 2019-03-01
 */
public class DoubleCheckTest extends ConcurrentBaseTest{

    private static  Instance instance;

    public   Instance getInstance(){

        if (instance == null){
            synchronized (DoubleCheckTest.class){
                if(instance == null){
                instance = new Instance();
                }
            }
        }

        return instance;
    }

    @Test
    public void testGetInstance(){

        System.out.println("*****************begin*********");
        for (int i = 0; i < COUNT; i++) {
            executorService.submit((Runnable) () -> {
                    Instance in =   getInstance();
                    System.out.println(in);


            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){}


    }

    class Instance{

        public void sayHello(){
            System.out.println("hello world!");
        }
    }
}
