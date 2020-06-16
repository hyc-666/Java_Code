package everyDayQuestion._0616;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/16
 */
public class TestGetSequeOddNum {
    public static void main(String[] args) {
        Main2 test = new Main2();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            System.out.println(test.GetSequeOddNum(n));
        }
    }
}
