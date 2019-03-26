package iterview;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangkun
 * @date 2019-01-30
 */
public class MySingleton {

    private static MySingleton instance = null;

    private MySingleton(){}

    public static MySingleton getInstance() {
        try {
            if(instance != null){//懒汉式

            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (MySingleton.class) {
                    instance = new MySingleton();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new   ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 100; i++) {
            pool.submit(()->{
                System.out.println( getInstance().hashCode());
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()){

        }
    }


}
