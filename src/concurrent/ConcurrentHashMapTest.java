package concurrent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tangkun
 * @date 2019-03-05
 */
public class ConcurrentHashMapTest {

    @Test
    public void testPut(){

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1","aaa");

    }
}
