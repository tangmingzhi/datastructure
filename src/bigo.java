import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangkun
 * @date 2018-11-25
 */
public class bigo {

    /**
     * log(1)
     * 无论n多大都只调用一次打印方法
     */
    @Test
    public void test_O_1() {

        int n = 1000;

        System.out.println(n);
    }

    /**
     * O(n)
     * 打印方法调用为n次，当前n为3
     */
    @Test
    public void test_O_n() {
        int j = 1000;

        System.out.println(j);
        System.out.println(j);
        System.out.println(j);
    }

    /**
     * O(log n)
     * 2^12=1024--->log(2)(1024)=12
     */
    @Test
    public void test_O_log_n() {
        int N = 1024;
        int b = 1;
        int a = 2;
        int length = 1;

        while (a <= N) {
            a = a * b;
            System.out.println("i+" + a);
            length++;
        }
        System.out.println("计算次数" + length);
    }

    /**
     * O(log n^2)
     * n=10，运算次数为100，即为n^2
     */
    @Test
    public void test_O_log_n_2() {
        int n = 10;
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                len++;
                System.out.println("运算次数" + len);

            }
        }
    }

    /**
     * O(log n^3)
     * n=10，运算次数为1000，即为n^3
     */
    @Test
    public void test_O_log_n_3() {
        int n = 10;
        int len = 0;
        for (int i = 0; i < n * n * n; i++) {
            len++;
        }
        System.out.println("运算次数" + len);
    }

    /**
     * O(log 2^n)
     * n=10，运算次数为1024，即为2^10
     */
    @Test
    public void test_O_2_n() {
        int n = 10;
        int len = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
            len++;
        }
        System.out.println("运算次数" + len);
    }

    /**
     * O(n!)
     * n=10，运算次数为10*9*8*7...1=3628800即为10！
     */
    @Test
    public void test_O_n_() {
        int n = 10;
        int len = 0;
        for (int i = 0; i < factor(n); i++) {
            len++;
        }
        System.out.println("运算次数" + len);
    }


    public int factor(int n) {
        int a = 1;
        //递归出口
        if (n == 1) {
            return 1;
        } else {
            a = n * factor(n - 1);
            return a;
        }
    }




}