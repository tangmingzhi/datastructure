import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangkun
 * @date 2018-12-04
 */
public class RecursionTest {

    //public Integer[] arr = new Integer[]{1,4,2,10,8,9,3,5,11};
    public Integer[] arr = new Integer[]{1,4,2};

    ListNode head;
    ListNode current;

    @Test
    public void testRecursion(){

        for (int i = 0; i < arr.length; i++) {
            if(head == null){
                head = new ListNode(arr[i]);
                current = head;
            }else {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }
        }

//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        List<ListNode> nodes = new ArrayList<>();
        recursion(head,nodes);
       // nodes.forEach(item -> System.out.println(item.val));

    }

    public void recursion(ListNode root, List<ListNode> nodes){

        if(root != null ){

            if(root != null) {
                System.out.println("node=" + root.val);
            }
            root=root.next;
            recursion(root,nodes);
            nodes.add(root);
            if(root != null) {
                System.out.println("list node=" + root.val);
            }
            //System.out.println("nodes size"+nodes.size());
        }
    }



    public ListNode getNextNode(ListNode root){
        if(root != null){
            return getNextNode(root.next);
        }else {
            return null;
        }
    }
}
