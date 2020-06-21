package everyDayQuestion._0620;

/**
 * @author hyc
 * @date 2020/6/21
 */
public class Test9 {
    private static int x = 100;

    public static void main(String[] args) {
        Test9 t1 = new Test9();
        t1.x++;
        Test9 t2 = new Test9();
        t2.x++;
        t1 = new Test9();
        t1.x++;
        Test9.x--;
        System.out.println("x = " + x);
    }
}
