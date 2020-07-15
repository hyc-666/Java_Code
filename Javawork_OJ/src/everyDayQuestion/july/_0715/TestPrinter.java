package everyDayQuestion.july._0715;

import java.util.Arrays;

/**
 * @author hyc
 * @date 2020/7/15
 */
public class TestPrinter {
    public static void main(String[] args) {
        Printer test = new Printer();
        int[][] t = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[] arr = test.arrayPrint(t,4);
        System.out.println(Arrays.toString(arr));
    }
}
