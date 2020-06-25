package everyDayQuestion.june._0623;

/**
 * @author hyc
 * @date 2020/6/25
 */
/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的
 * 结点之前
 * 给定-个链表的头指针ListNode* pHead,请返回重新排列后的链表的头指针。注意:分
 * 割以后保持原来的数据顺序不变。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null){
            return null;
        }
        // write code here
        ListNode small = new ListNode(-1);
        ListNode smallTail = small;
        ListNode big = new ListNode(-2);
        ListNode bigTail = big;
        for (ListNode node = pHead;node != null;node = node.next){
            if (node.val < x){
                smallTail.next = new ListNode(node.val);
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(node.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = big.next;
        return small.next;
    }
}