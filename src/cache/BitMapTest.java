package cache;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author tangkun
 * @date 2019-04-12
 */
public class BitMapTest {

    @Test
    public void testSet(){

      BitSet bitSet = new BitSet(100);

        for (int i = 0; i < 100; i++) {
            //如果数值超过了bit map表达的最大长度，bit map 会进行扩容
            bitSet.set(i, true);
        }

        System.out.println(bitSet.size());
       // System.out.println(bitSet.get(100));
    }
}
