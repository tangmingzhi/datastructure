import org.junit.*;

/**
 * @author tangkun
 * @date 2018-12-22
 */
public class MajorityElementTest {

    @org.junit.Test
    public void test(){
        int[] nums = {2,2,1,3,5,3,2,3,7,3,3,2};
        int left = 0;
        int right = 1;
        //依次遍历相邻2个数，不相等标记为0
        while (right <= nums.length-1){
            if(nums[left] != nums[right]) {
                if(left > 0 && nums[left - 1] != 0){
                    nums[left-1] = 0;
                }else {
                    nums[left] = 0;
                    nums[right] = 0;
                }
            }
                left++;
                right++;
        }

        //
        System.out.println(majorityElement(nums));
    }

        private int countInRange(int[] nums, int num, int lo, int hi) {
            System.out.println("***********:"+num);
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        private int majorityElementRec(int[] nums, int lo, int hi) {

            // base case; the only element in an array of size 1 is the majority
            // element.
            System.out.println("递归进入 lo: hi:"+lo+"\t"+hi);
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi-lo)/2 + lo;

            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid+1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                System.out.println("=====================");
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length-1);
        }
}
