package junittest;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import tree.BinaryTest;

/**
 * @author tangkun
 * @date 2019-02-15
 */
public class JunitTestSuite {

    public static void main(String[] a) {
        // add the test's in the suite
        TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class );
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());
    }
}
