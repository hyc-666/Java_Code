package everyDayQuestion.july._0718;

/**
 * @author hyc
 * @date 2020/7/19
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ■题目描述
 * 根据输入的日期，计算是这一年的第几天。
 * 。
 * 详细描述:
 * 输入某年某月某日，判断这一天是这一年的第几天?
 * 。
 */
public class Main {
    //真没想到这样写都能通过
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int date = dayOfYear(year,month,day);
            System.out.println(date);
        }
    }

    public static int dayOfYear(int year,int month,int day){
        if (year < 1){
            return -1;
        }
        if (month > 12 || month < 1){
            return -1;
        }
        if (day < 1 || day > 31){
            return -1;
        }

        //month - 1 是因为在calendar里月份的下标是从0开始的，有悖常理
        Calendar calendar = new GregorianCalendar(year,month - 1,day);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
}
