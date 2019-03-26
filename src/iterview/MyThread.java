package iterview;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangkun
 * @date 2019-01-30
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(MySingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {

//        MyThread[] mts = new MyThread[10];
//        for(int i = 0 ; i < mts.length ; i++){
//            mts[i] = new MyThread();
//        }
//
//        for (int j = 0; j < mts.length; j++) {
//            mts[j].start();
//        }


       // ThreadPoolExecutor pool = new   ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
       ThreadPoolExecutor pool = new   ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 100; i++) {
            pool.submit(()->{
                System.out.println( MySingleton.getInstance().hashCode());
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()){

        }
    }

}
