package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author tangkun
 * @date 2018-12-06
 */
public class MergeSort implements IArraySort{

    @Test
    public  void testSort() {
         int[] sort = split(arr);
        System.out.println(Arrays.toString(sort));
    }

    @Override
    public int[] sort(int[] arr) {
        return split(arr);
    }

    public  int[] split(int[] arr){

        //如果数组已经被拆分为每片区域只有一个元素
        if(arr.length < 2){
            return arr;
        }

        /**
         * 向下取整
         * 3/2 = 1
         *
         */
        int middle = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);

        return merge(split(left), split(right));
    }

    public static int[] merge(int[] left,int[] right){

        //存放合并结果
        int[] result = new int[left.length+right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0){
            if(left[0] <= right[0]){
                //比较之后将元素迁移后，重置比较的数组，让比较下标位置总是从0开始
                result[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }

        //left 和 right 交叉比较后会有未比较完
        while (left.length > 0 ){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

         while (right.length > 0 ){
                    result[i++] = right[0];
                    right = Arrays.copyOfRange(right,1,right.length);
        }

        return result;
    }
}
