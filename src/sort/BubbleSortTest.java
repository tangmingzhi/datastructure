package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author tangkun
 * @date 2018-12-06
 */
public class BubbleSortTest implements IArraySort {


   @Test
   public void testSort(){
       int[] sortArr =  sort(arr);
        System.out.println(Arrays.toString(sortArr));
        System.out.println(sum);
    }


    @Override
    public  int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            sum.incrementAndGet();
            //每轮会把最大的元素移到最右边，下一轮比较元素就比上一轮少1
            for (int j = 0; j < arr.length - i; j++) {
                sum.incrementAndGet();
                if (arr[j] > arr[j + 1]) {
                    //左边 》 右边  左右交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }
}
