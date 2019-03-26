import java.util.PriorityQueue;

/**
 * @author tangkun
 * @date 2018-12-04
 */
public class MinHeap {

   private int size;

   int[] minHeap = new int[5];


   public void add(int ele){

       if(size == 0){
           minHeap[0] = ele;
       }

       siftUp(size, ele);

   }

    public void siftUp(int count, int ele){

        while (count > 0){

            int index = count - 1 ;

            int index_ele = minHeap[index];
            if (ele > index_ele){
                minHeap[count] = ele;
                break;
            }

            minHeap[index] = ele;
            minHeap[count] = index_ele;

            count--;
        }


    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();
        queue.add(15);
        queue.add(16);
        queue.add(14);
        queue.add(13);
        queue.add(12);
        queue.add(11);
        queue.add(10);
        queue.add(9);
        queue.add(8);
        queue.add(7);



    }
}
