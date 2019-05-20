package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangkun
 * @date 2019-05-10
 */
public class Lession08_1 {

    public static void main(String[] args) {

        /*
        三选二排列组合
         */
        List<String> terms = Arrays.asList("t1", "t2", "t3");
        combo(terms, 2, new ArrayList<>());
    }

    public static void combo(List<String> terms, int size, ArrayList<String> result){

      //  System.out.println("terms:{} size:{}"+ terms.size() + "\t"+size);
        //组合集合个数等于要求个数
        if(size == result.size()){
            result.forEach(item ->{
                System.out.print(item + "\t");
            });
            System.out.println();
            return;
        }

        if(terms.size() == 0){
            return;
        }

        for (int i = 0; i < terms.size(); i++){

            //添加当前元素到组合
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(terms.get(i));

            //计算当前选择之后剩余的可选集合
            //在原有集合中，t1 在 t2 的前面，所以我们划掉了{t2,t1},t1一定会包含t2,所以不需要t2再包含t1
            List<String> subResult = new ArrayList<>((List<String> )terms.subList(i + 1, terms.size()));

            combo(subResult, size, newResult);
        }

    }

}
