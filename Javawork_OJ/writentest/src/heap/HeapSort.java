package heap;
//堆排序

/**
 * @author hyc
 * @date 2020/9/24
 */
public class HeapSort {
    public static void main(String[] args) {
        int a = 5,b = 7,c;
        c = a+++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    //建堆的过程
    public static void buildHeap(int[] arr,int n){
        //从倒数第一个非叶子节点开始建堆
        int i = 0;
        for (i = n - 1; i >= 0; i--) {
            int c1 = 2 * i + 1;
            int c2 = 2 * i + 2;
            int max = 0;
            if (arr[c1] > arr[c2]){
                max = c1;
            }
            if (arr[i] < arr[max]){
                swap(arr,i,max);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
