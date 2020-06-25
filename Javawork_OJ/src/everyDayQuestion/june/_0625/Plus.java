package everyDayQuestion.june._0625;

/**
 * @author hyc
 * @date 2020/6/25
 */

/**
 * ■题目描述
 * 有两个用链表表示的整数，每个结点包含一个数位。 这些数位是反向存放的，也就是个位
 * 排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A, ListNode* B，请返回A+ B的结果(L istNode*)》。
 * 测试样例:
 * {1,2,3}，{3,2,1}
 * 返回: {4,4,4}
 */

//题目似曾相识，当时见过原题，可是当时没有做
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public void add(int val){
        ListNode head = this;
        while (head.next != null){
            head = head.next;
        }
        head.next = new ListNode(val);
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null){
            stringBuilder.append(node.val + ", ");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        //跟前面算长整数加法一样，这里用链表表示，并且已经把位对齐了。
        //表示进位
        boolean carry = false;
        ListNode resHead = new ListNode(-1);//采用傀儡节点方法比较方便
        ListNode sumResult = resHead;
        ListNode headA = a;
        ListNode headB = b;
        while (headA != null && headB != null){
            int sum = headA.val + headB.val;//计算和
            if (sum > 9 && carry){//如果本轮结果有进位并且上一轮的计算结果也有进位
                sumResult.next = new ListNode(sum - 9);
                carry = true;//标记本轮有进位
            }else if (sum < 10 && carry){//如果本轮没有产生进位，但是上一轮计算结果有进位
                if (sum + 1 > 9){//如果本轮计算结果没有进位但是加上上一轮的进位之后本轮产生了进位
                    sumResult.next = new ListNode(sum  - 9);
                    carry = true;//标记本轮计算结果还是产生了进位
                }else{//如果本轮计算结果加上上一轮的进位之后也没有产生进位
                    sumResult.next = new ListNode(sum + 1);//那么本轮的结果就是本轮的计算结果加上进位
                    carry = false;//本轮的最终结果是没有产生进位的
                }
            }else if (sum > 9 && !carry){//如果本轮有进位但是上一轮没有进位
                sumResult.next = new ListNode(sum - 10);//不用处理上一轮的进位，只处理本轮的进位
                carry = true;//标记本轮结果有进位
            }else{//最后的情况就是本轮没有进位上一轮也没有进位
                sumResult.next = new ListNode(sum);
                carry = false;//本轮没有产生进位的
            }
            headA = headA.next;//记得各指针也要往后挪
            headB = headB.next;
            sumResult = sumResult.next;
        }
        //因为是链表存在长度不一样的问题并且不像数组一样空位有默认值0
        //所以要处理后续的没有处理完的结果
        //上面的循环结束以后至少有一个链表尾部已经到达末端，下面的循环只会执行其中一个或者两个都不会执行
        while (headA != null){
            if (carry){//要判断最后一次的运算有没有进位发生
                int sum = headA.val + 1;
                if (sum > 9){
                    sumResult.next = new ListNode(sum - 10);
                    carry = true;
                }else{
                    sumResult.next = new ListNode(sum);
                    carry = false;
                }
            }else{
                sumResult.next = new ListNode(headA.val);
                carry = false;
            }
            headA = headA.next;
            sumResult = sumResult.next;
        }
        while (headB != null){
            if (carry){
                int sum = headB.val + 1;
                if (sum > 9){
                    sumResult.next = new ListNode(sum - 10);
                    carry = true;
                }else{
                    sumResult.next = new ListNode(sum);
                    carry = false;
                }
            }else{
                sumResult.next = new ListNode(headB.val);
                carry = false;
            }
            sumResult = sumResult.next;
            headB = headB.next;//同步更新指针
        }
        //还有处理两个链表同时到达末尾时还有进位的情况
        if (carry){
            sumResult.next = new ListNode(1);
        }
        return resHead.next;
    }
    //唉，聪明反被聪明误啊，一开始是对的，结构后边因为一个小小的问题以为我错了
    //又整个全部重新规划写完以后才发现了第一次没有发现的那个问题，
    //然后，才发现第一次写的是对的。。。。
    //命运捉弄人啊。
}