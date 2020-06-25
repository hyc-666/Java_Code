package everyDayQuestion.june._0624;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/25
 */

/**
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生-只兔子，小兔子长到第三个月后每个月
 * 又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少?
 * *统计出兔子总数。
 * * @param monthCount第几个月
 * * @return兔子总数
 * */
 /*public static int getTotalCount(int monthCount)
        *return 0;
        *输入描述:
        *输入int型表示month
        *输出描述:
        *输出兔子总数int型
 */

 //经典兔子繁殖问题
    //斐波那契数列
public class Main {
    public static void main(String[] args) {
        //第一个月 1
        //第二个月 1
        //第三个月 1 + 1 = 2
        //第四个月 1 + 2 = 3
        //第五个月 2 + 3 = 5
        // 。。。
        //第n个月 f(n - 1) + f(n - 2);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int month = scanner.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
    public static int getTotalCount(int monthCount){
        return monthCount <= 2 ? 1 : getTotalCount(monthCount - 1) + getTotalCount( monthCount - 2);
    }
}
