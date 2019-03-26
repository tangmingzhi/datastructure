package recursion;

import java.util.Enumeration;
import java.util.Stack;

/**
 * 汉诺塔问题
 * @author tangkun
 * @date 2019-01-03
 */
public class HanoiTowerTest {

    public static void main(String[] args) {
        //FILO
        Stack<Integer> A = new Stack<>();
        A.push(3);
        A.push(2);
        A.push(1);

        Stack<Integer> B = new Stack<>();

        Stack<Integer> C = new Stack<>();

        int n = A.size();

//        将将较小的 n-1个盘子看做一个整体，也就是我们要求的子问题，以借助 B 塔为例，可以借助空塔 B 将盘子A上面的 n-1 个盘子从 A 移动到 B ；
//        将A 最大的盘子移动到 C ， A 变成空塔；借助空塔 A ，将 B 塔上的 n-2 个盘子移动到 A，将 C 最大的盘子移动到 C， B 变成空塔。。

        //已经完成移动到梵塔C上的小盘
        int completedSize = 0;



        int size = C.size();
        for (int i = 0; i < size; i++) {
            System.out.println(C.pop());
        }
    }

    public void moveEle(Stack A, Stack B,Stack C, int totalSize,int completedSize){

        //单
        if(completedSize %  2 == 1){

        }else {
            int n = A.size()-1;
            for (int i = 1; i <= n; i++) {
                if(i % 2 == 1){
                move(A,C);
                }else {
                    move(A,B);
                    //移动2次需要把2次移动小盘按规则放到B梵塔
                    move(C,B);
                }
            }

        }


    }

    public void move(Stack source, Stack target){
        target.push(source.pop());
    }




}
