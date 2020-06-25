package everyDayQuestion.june._0624;

/**
 * @author hyc
 * @date 2020/6/25
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(foo(20,3));
    }
    public static int foo(int x,int y){
        if (x <= 0 || y <= 0){
            return 1;
        }
        return 3 * foo(x - 6,y / 2);
    }
}
