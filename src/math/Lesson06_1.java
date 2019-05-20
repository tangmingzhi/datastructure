package math;

import java.util.Arrays;

/**
 * @author tangkun
 * @date 2019-05-10
 */
public class Lesson06_1 {

    static int[] arr = {4, 9, 0, 2, 7, 8, 20, 34};

    public static void main(String[] args) {
       int[] sortedArr = (mergeSort(arr));
       for (int i : sortedArr){
           System.out.println(i);
       }
    }

    public static int[] mergeSort(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        if(arr.length != 1){
            int middle = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, middle);
            int[] right = Arrays.copyOfRange(arr, middle, arr.length);
            int[] sortLeft = mergeSort(left);
            int[] sortRight =mergeSort(right);
            return sort(sortLeft, sortRight);
        }

        return null;
    }

    public static int[] sort(int[] sortLeft, int[] sortRight){

        int[] sortedArr = new int[sortLeft.length + sortRight.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            if(leftIndex != sortLeft.length && rightIndex != sortRight.length){
                if(sortLeft[leftIndex] < sortRight[rightIndex]){
                    sortedArr[i] = sortLeft[leftIndex++];
                    continue;
                }else {
                    sortedArr[i] = sortRight[rightIndex++];
                    continue;
                }
            }

            if(leftIndex == sortLeft.length){
                sortedArr[i] = sortRight[rightIndex++];
                continue;
            }

            if(rightIndex == sortRight.length){
                sortedArr[i] = sortLeft[leftIndex++];
                continue;
            }

        }
        return  sortedArr;
    }




}
