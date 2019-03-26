package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author tangkun
 * @date 2019-03-17
 */
public class SleepUtils {

    public static final void second(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
