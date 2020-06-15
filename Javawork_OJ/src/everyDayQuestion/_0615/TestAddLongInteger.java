package everyDayQuestion._0615;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/15
 */
public class TestAddLongInteger {
    public static void main(String[] args) {
        Main2 test = new Main2();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String n1 = scanner.nextLine();
            String n2 = scanner.nextLine();
            System.out.println(test.AddLongInteger(n1,n2));
        }
    }
}
