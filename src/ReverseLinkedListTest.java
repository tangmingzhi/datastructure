import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangkun
 * @date 2018-11-29
 */
public class ReverseLinkedListTest {

    //Input: 1->2->3->4->5->NULL
    //Output: 5->4->3->2->1->NULL

    ListNode head = new ListNode(1);
    @Before
    public void init(){
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next    =new ListNode(4);
        head.next.next.next.next    =new ListNode(5);
        head.next.next.next.next.next    =new ListNode(6);
       // head.next.next.next.next.next.next    =head;
//        head.next.next.next.next     =new ListNode(5);
//        head.next.next.next.next.next      =null;
    }

    @Test
    public void reverse(){
        //ListNode listNode = swapPairs(head);
       // System.out.println(hashCycle(head));
        System.out.println(fastAndSlowPoint(head));
    }

    /**
     * 链表反转
     * input 1 2 3 4
     * output 4 3 2 1
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){

        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            //当前下个节点
            ListNode tempNode = current.next;
            current.next=prev;
            prev =current;
            current = tempNode;
        }
        return prev;
    }

    /**
     * 链表 两两交换
     * input  1 2 3 4 5 6
     * output 2 1 4 3 6 5
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){

        ListNode current  = head;
        ListNode next = current.next;
        boolean flag = true;
        ListNode returnNode = next;
        ListNode prevNode = null;
        while (next != null){
            ListNode tempNext = next.next;
            if(flag) {
                //交换位置
                next.next = current;
                current.next=null;
                if(prevNode != null) {
                    prevNode.next = next;
                }
                flag = false;
            }else {
                //链上
                current.next = next;
                prevNode=current;
                current=next;
                flag = true;
            }
            next = tempNext;

        }
        return  returnNode;
    }

    /**
     * 判断链表是否有环
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head
     * @return
     */
    public  boolean hashCycle(ListNode head){

        boolean flag = false;
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null){
            if (nodeList.contains(head)){
                flag = true;
                break;
            }else {
                nodeList.add(head);
                head = head.next;
            }
        }
        return flag;
    }

    /**
     * 快慢指针探测法
     * 时间复杂度： O(n)
     * @param head
     * @return
     */
    public boolean fastAndSlowPoint(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }


}
