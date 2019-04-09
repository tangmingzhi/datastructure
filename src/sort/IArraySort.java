package sort;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangkun
 * @date 2019-04-09
 */
public interface IArraySort {

     int[] arr = {10,9,8,7,6,5,4};
     AtomicInteger sum = new AtomicInteger();

    int[] sort(int[] arr);
}
