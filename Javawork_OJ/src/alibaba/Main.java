package alibaba;

import java.util.Scanner;

/**
 * 寻找相邻的组合，一个或多个，计算全部组合
 * @author hyc
 * @date 2020/9/8
 */
public class Main {

    //第一感觉是用环形链表或者环形队列来做。。。。
    //分析（试图寻找规律。。。。。）：
    //    n        f(n)
    //    1         1   1
    //    2         3   1,2,(1,2)
    //    3         6    1,2,3,(1,2),(2,3),(3,1)
    //    4         13  1,2,3,4,(1,2),(2,3),(3,4),(4,1),(1,2,3),(2,3,4),(3,4,1),(4,1,2),(1,2,3,4)
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //感觉只是时间不够
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
        }
    }
/*    public static int countCow(SingleList head,int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {

        }
    }*/
}
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class SingleList{
    Node head = null;

    public void add(int value){
        Node node = new Node(value);
        if (head == null){
            head = node;
            return;
        }
        head.next = node;
    }

    public void circle(){
        if (head == null){
            return;
        }
        //将此单链表变为环形单链表
        Node node = head;
        while (node.next != null){
            node = node.next;
        }
        node.next = head;
    }
}