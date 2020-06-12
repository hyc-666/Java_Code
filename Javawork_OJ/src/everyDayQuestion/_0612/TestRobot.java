package everyDayQuestion._0612;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/12
 */
public class TestRobot {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(robot.countWays(x,y));
        }
    }
}
