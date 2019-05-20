package math;

import java.util.ArrayList;

/**
 * @author tangkun
 * @date 2019-05-10
 */
public class Lesson05_1 {

    static int[] rewards = {1, 2, 5, 10};

    public static void main(String[] args) {
        getRewards(10, new ArrayList<>());
    }

    public static void getRewards(int totatlRewards, ArrayList<Integer> result){

        //匹配成功
        if(totatlRewards == 0){
            System.out.println("匹配的组合"+result);
            return;
        }

        //匹配不符合规则
        if(totatlRewards < 0){
            return;
        }

        for (int i = 0; i < rewards.length; i++) {
            ArrayList<Integer> newResult = (ArrayList<Integer>)result.clone();
            newResult.add(rewards[i]);
            getRewards(totatlRewards - rewards[i], newResult);
        }

    }
}
