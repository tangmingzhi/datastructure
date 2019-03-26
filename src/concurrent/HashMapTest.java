package concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tangkun
 * @date 2019-03-04
 */
public class HashMapTest extends  ConcurrentBaseTest{

    @Test
    public void testLock(){

        HashMap<KeyEntity,Integer> map = new HashMap<>();
        //ConcurrentHashMap<Entity,Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < COUNT; i++) {
            executorService.submit(()->{
                Integer age = new Random().nextInt(100);
                //System.out.println("age:"+age);
                map.put(new KeyEntity(UUID.randomUUID().toString(),age),age);
                map.get(age);
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}

        System.out.println(map.size());
        int i = 0;
        for (Map.Entry<KeyEntity,Integer> key: map.entrySet()) {
         i++;
        }
        System.out.println("i:"+i);
    }

    class  KeyEntity{

        private String name;
        private Integer age;

        public KeyEntity(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            return age.equals(((KeyEntity)obj).age);
        }


    }
}
