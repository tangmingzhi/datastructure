package recursion;

/**
 * @author tangkun
 * @date 2019-01-13
 */
import org.junit.Test;

import java.util.*;

public class Hanoi {

 static    Stack A = new Stack();
 static    Stack B = new Stack();
 static    Stack C = new Stack();
    static  Map<Integer,Stack> stackMap  = new HashMap<>();
    static {
        stackMap.put(1,A);
        stackMap.put(2,B);
        stackMap.put(3,C);
    }
    //p1为初始盘，p3为目标盘
    public static void solve(int n,int p1,int p2,int p3){
        if(n==1) {
            System.out.println("从" + p1 + "移动到" + p3);
            moveEle(p1,p3);
        } else{
            solve(n-1,p1,p3,p2);
            moveEle(p1,p3);
            System.out.println("完成一次从"+p1+"移动到"+p3);
            solve(n-1,p2,p1,p3);
        }
    }

    public static void moveEle(int sourceIndex, int targetIndex){
       stackMap.get(targetIndex).push(stackMap.get(sourceIndex).pop());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            A.push(i);
        }

        solve(n,1,2,3);

        for (int i = 0; i <n ; i++) {
            System.out.println(C.pop());
        }
    }

    public void moveOne(int n, String init, String desti){    //只有一个盘子的情况
        System.out.println(" move:"+n+" from "+init+" to "+desti);
    }
    public void move(int n, String init, String temp, String desti){
        if(n == 1){
            moveOne(n,init,desti);
        }else{
            //首先将上面的（n-1）个盘子从init杆借助desti杆移至temp杆
            System.out.println("首先将上面的"+(n-1)+"个盘子从init杆借助desti杆移至temp杆");
            move(n-1, init, desti, temp);

            //然后将编号为n的盘子从init杆移至desti杆
            moveOne(n, init, desti);
            System.out.println("最后将上面的"+(n-1)+"个盘子从temp杆借助init杆移至desti杆");
            move(n-1, temp, init, desti);
        }
    }

    @Test
    public void moveTest(){
        move(5, "A", "B", "C");
    }

}
