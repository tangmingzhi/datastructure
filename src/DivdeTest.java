import java.util.Arrays;
import java.util.Random;

/**
 * 分治算法
 * @author tangkun
 * @date 2018-12-18
 */
public class DivdeTest {

    /**
     * 求2^10
     * @param args
     */
    public static void main(String[] args) {
        //jdk库自带native方法
        //System.out.println(Math.pow(2,10));
       // System.out.println(myPow(2,10));
        int[] nums = {1,1,2,5,2,5,5,5,5};
        //divide(nums);

    }

        public static double myPow(double x, int n) {
            System.out.println("递归入"+n);
            if(n == 0) return 1.0;
            double d = myPow(x, n/2);
            double result = 0;
            if(n%2 == 0){
                result = d*d;
                System.out.println("n: "+n +" result:"+result);
                return result;
            }
            result = d*d*x;
            System.out.println("n:::"+n +" result:"+result);
            return result;
        }
















    public int divde(int x,int n){

       // if ()
        return 0;
    }

    public static int divide(int[] nums){
        int[] left = Arrays.copyOfRange(nums,0,nums.length/2);
        int[] right = Arrays.copyOfRange(nums,left.length,nums.length);
        System.out.println("left:"+left.length);
        System.out.println("right:"+right.length);
        return 0;

    }


}

class Solution {
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private static int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length/2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }


}
