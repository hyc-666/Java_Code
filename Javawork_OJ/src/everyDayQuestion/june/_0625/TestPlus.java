package everyDayQuestion.june._0625;

/**
 * @author hyc
 * @date 2020/6/25
 */
public class TestPlus {
    public static void main(String[] args) {
        Plus test = new Plus();
        ListNode a = new ListNode(9);
        a.add(9);
        a.add(9);

        ListNode b = new ListNode(1);
        b.add(1);
        b.add(1);

        System.out.println(test.plusAB(a,b));
    }
}
