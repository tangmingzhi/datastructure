package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author tangkun
 * @date 2019-04-09
 */
public class SelectionSortTest  implements IArraySort {


    @Test
    public void testSort() {
        int[] sortArr = sort(arr);
        System.out.println(Arrays.toString(sortArr));
        System.out.println(sum);
    }

    @Override
    public int[] sort(int[] arr) {

        int[] sortArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            /**
             *复杂度+1
             * 1：每轮会找出待排序元素中最小的值，找到后放入排序位置
             * 2：下一轮查找的起始位置会在上一轮位置+1，因为前一轮会插入一个排序元素
             */
            sum.incrementAndGet();
            for (int j = i + 1; j < arr.length; j++) {
                if (min > sortArr[j]) {
                    min = sortArr[j];
                    index = j;
                }
                //复杂度+1
                sum.incrementAndGet();
            }

            if (i != index) {
                sortArr[index] = arr[i];
                sortArr[i] = min;
            }

        }
        return sortArr;
    }
}