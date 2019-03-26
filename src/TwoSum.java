import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 累加二数
 *
 * @author tangkun
 * @date 2018-11-26
 */
public class TwoSum {

    @Test
    public void testTwoSum(){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println(result[0]+"+"+result[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        //空间复杂度O(n)
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i],i);
        }
        //时间复杂度 O(n)
        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            if(map.get(complement) != null){
                return new int[]{i,map.get(complement)};
            }
        }
        return new int[]{};


    }
}
