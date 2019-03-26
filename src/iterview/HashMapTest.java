package iterview;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author tangkun
 * @date 2019-01-31
 */
public class HashMapTest {

    /**
     * 默认方式 ：长度=16 负载因子0.75 安全阀值 = 长度 * 负载因子 = 12；
     * 指定长度 17-31：长度 = 大于输入参数且最近的2的整数次幂的数 = 32 ， 负载因子0.75 安全阀值 = 32 * 0.75 = 24;
     * 扩容 在上一次长度*2
     * 元素存储：hash(key)% size 取模，hash冲突，则将新元素作为head头
     */

    @Test
    public void testPut(){


        HashMap map = new HashMap<>(31);
        for (int i = 0; i < 31; i++) {
            map.put(String.valueOf(i),i);
        }

    }

    @Test
    public void specialSize(){
        for (int i = 20; i < 31; i++) {
            System.out.println(tableSizeFor(i));
        }

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return  n + 1;
    }

}
