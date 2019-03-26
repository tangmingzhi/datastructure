package sort;

import java.util.Arrays;

/**
 * @author tangkun
 * @date 2018-12-06
 */
public class BubbleSortTest {

   static int[] arr = {4,5,6,2,8,9,1};
    public static void main(String[] args) {
        /**
         * 冒泡排序:循环嵌套循环
         * 时间复杂度O(n^2)
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j+1 < arr.length && arr[j] > arr[j+1]  ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
