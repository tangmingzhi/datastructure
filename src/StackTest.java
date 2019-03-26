import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author tangkun
 * @date 2018-12-02
 */
public class StackTest {

    String str = "([]){}";

    @Test
    public void test() {
        System.out.println(verifyStr(str));
    }

    public boolean verifyStr(String str){
        Map<String,String> map = new HashMap<String, String>(){{
            put("(",")");
            put("[","]");
            put("{","}");
        }};
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(String.valueOf(c))){
                stack.add(String.valueOf(c));
            }else {

                if(!stack.isEmpty() && String.valueOf(c).equals(map.get(stack.peek()))){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
