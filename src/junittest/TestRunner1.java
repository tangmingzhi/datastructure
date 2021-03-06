package junittest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author tangkun
 * @date 2019-02-15
 */
public class TestRunner1 {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit1.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(""+result.wasSuccessful());
        System.out.println(""+result.getRunCount());
    }
}
