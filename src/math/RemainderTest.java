package math;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author tangkun
 * @date 2019-04-19
 */
public class RemainderTest {

    int source = 625;
    int random = 590127;
    int hashK = 7;

    /**
     * 余数实现加密
     */
    @Test
    public void testRemainder(){
        int encryption = encryption(source, random, hashK);
        int decode = decode(encryption);
        System.out.println(String.format("source:%s\t encryption:%s\t decode:%s", source, encryption, decode));
    }

    /**
     * 1：对原数百位，十位，个位 都加上随机数得到一个 三个较大的数
     * 2：对三个较大的数都除以7，得到的余数 替代 百 十 个 位；
     * 3：第一位与第三位进行交换
      */
    public Integer encryption(int source, int random, int hashK){

        int result = 0;

        //拆分加随机数
        Integer[] arr = convertIntToArr(source, random);
        List<Integer> ints =Arrays.asList(arr);
        ints.forEach(System.out::println);

        //求余
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            tmp = tmp  % hashK;
            arr[i] = tmp;
        }

        //交换位置
        swapArr(arr);
        ints =Arrays.asList(arr);
 //       ints.forEach(System.out::println);

        //转换为整数
        result = convertArrToInt(arr);
        System.out.println("加密结果 :"+result);
        return result;
    }

    public Integer decode(Integer decry){
        int reverse = reverse(decry);
        Integer[] integers = convertIntToArr(reverse, 0);
        for (int i = 0; i < integers.length; i++) {
            integers[i] = calculate(integers[i], hashK, random);
        }

        return  convertArrToInt(integers);
    }

    //转换为整数
    public static Integer convertArrToInt(Integer[] arr){
        int result = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            //除个位数外，其余位数都乘10对应的次方
            if(i == arr.length - 1){
                result += (int)arr[i];
            }else {
                result += (int) arr[i] * Math.pow(10, 2 - i);
            }
        }

        return result;
    }

    //交换位置
    public static void swapArr(Integer[] arr){
        int tmp = arr[0];
        arr[0] = arr[2];
        arr[2] = tmp;
    }

    //反转
    public static int reverse(int source){
        long result = 0;
        while (source > 0){
            result *= 10;
            result += source % 10;
            source /= 10;
        }
        return (int)result;
    }

    public static Integer[] convertIntToArr(Integer source,  int random){
        Integer[] arr = new Integer[3];
        byte[] bytes = Integer.toUnsignedString(source).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            char c = (char)bytes[i];
            arr[i] = random + Integer.valueOf(String.valueOf(c));
        }
        return  arr;
    }

    public static int calculate(int source, int k, int random){

        int a = (random - source) % k;
        a = 7- a;
        System.out.println("calculate i :{}" + a);
        return  a;
    }

    public static void main(String[] args) {
       // System.out.println(590122%7);
        System.out.println(reverse(590122));
    }
}
