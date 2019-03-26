import java.util.Arrays;

/**
 * @author tangkun
 * @date 2018-12-05
 */
//建立最小堆（数组从1开始）
public class Test {

    public static void main(String[] args){
        Test t = new Test();
        int[] heap={0,45,35,67,33,87,8,4,2,5,12};
        String str = Arrays.toString(heap);
        System.out.println(str);
        t.swap(heap,2,3);
        for(int i=heap.length-1/2; i>=1; i--){
            t.sift_down(heap,i);
        }
        String str2 = Arrays.toString(heap);
        System.out.println(str2);

        //测试向上调整，添加一个数据时
//        int heap2[]={0,2,5,4,33,12,8,35,45,67,87,1};
//        t.sift_up(heap2,heap2.length-1);
//        String str3 = Arrays.toString(heap2);
//        System.out.println(str3);
    }

    public int delete_min(int[] heap){
        int t = heap[1];
        //将最后一个元素赋值给堆顶
        heap[1]=heap[heap.length-1];
        //将heap的长度减1 n--
        //因为heap的不是全局变量
        sift_down(heap,1);
        return t;
    }

    //向上调整（添加元素）
    public void sift_up(int[] heap, int i){
        int n = heap.length-1;
        int flag = 0;
        if(i == 1) {
            return;//如果时候对顶就直接返回
        }

        while(i != 1 && flag==0){
            if(heap[i] < heap[i/2]){
                swap(heap,i,i/2);

            }else{
                flag=1;
            }
            i=i/2;
        }
    }
    //向下调整（删除堆顶元素，添加一个元素需要用到向下调整）
    public void sift_down(int[] heap,int i){
        int temp,flag=0;//flag标记是否继续向下调整
        int n = heap.length-1;
        while(i*2 <= n && flag == 0){
            temp = i;
            if(heap[i*2] < heap[i]){
                temp = i*2;
            }
            if(i*2+1 <= n){
                if(heap[i*2+1] < heap[temp]){
                    temp = i*2+1;
                }
            }
            if(temp != i){//如果当前节点不是最小节点
                swap(heap,temp,i);
                i = temp;//更变当前节点，继续向下调整
            }
            else{
                flag = 1;
            }

        }
    }

    public void swap(int[] heap,int a,int b){
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }
}

