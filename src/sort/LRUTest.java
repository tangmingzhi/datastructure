package sort;

import org.junit.Test;

/**
 * @author tangkun
 * @date 2019-03-26
 */
public class LRUTest {


    Node head;

    private int size;

    private int MAX_SIZE = 10;

    @Test
    public void test(){
        for (int i = 0; i < 20; i++) {
            putNode(i);
        }
        putNode(18);
        loopNode();
    }

    public void loopNode(){
        while (head != null){
            System.out.println(head.getValue());
            head = head.next;
        }
    }

    public Node putNode(int value){

        Node current = head;
        Node beforeTailNode = head;
        while (current != null){
          if(current.getValue() == value){
                //if pre is null ,current is head node
                if(value == head.getValue()){
                    return head;
                    //do nothing
                }else {
                    beforeTailNode.next = current.next;
                    current.next = head;
                }

            }
            beforeTailNode = current;
            current = current.next;
        }

        head = new Node(value,null,head);
        size++;

        //remove last pre node of tail
       if(size > MAX_SIZE){
         removeTailNode(head);
       }
        return  head;

    }

    public void removeTailNode(Node head){
        Node  lastSecondNode = findLastBudOneNode(head);
        lastSecondNode.next = null ;
    }
    public Node findLastBudOneNode(Node head){

        Node beforeTailNode = head;
        Node tail = head;
        while (tail != null ){
            if(tail.getNext() == null){
                return beforeTailNode;
            }
            beforeTailNode = tail;
            tail = tail.next;

        }
        return null;
    }
    class  Node {

        private int value;



        private Node next;

        public Node(int value, Node pre, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }



        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }


        public void setNext(Node next) {
            this.next = next;
        }
    }

}
