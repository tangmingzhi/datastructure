package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangkun
 * @date 2019-03-01
 */
public class ConcurrentBaseTest {

    final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static final int COUNT = 1000;

}
