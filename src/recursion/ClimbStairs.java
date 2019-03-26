package recursion;

/**
 * @author tangkun
 * @date 2019-01-16
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int size = 100;
        long time = System.currentTimeMillis();
        f(size);
        System.out.println(System.currentTimeMillis()-time);
        long endTime = System.currentTimeMillis();
        dynamic(size);
        System.out.println(System.currentTimeMillis()-endTime);
    }

     static    int  f(int n) {
          if (n == 1) {
              return 1;
          }
          if (n == 2) {
              return 2;
          }
          return f(n-1) + f(n-2);
        }

    static int dynamic(int n){

        int a = 2;
        int b = 3;

        //存储前2项值
        int tmp = a+b;

        for (int i = 4; i < n; i++) {
            //a b交换
            a = b;
            b=tmp;
            //保存最新值
            tmp = a+b;
        }

        return  tmp;
    }
}
