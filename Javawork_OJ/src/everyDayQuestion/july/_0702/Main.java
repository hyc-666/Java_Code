package everyDayQuestion.july._0702;

/**
 * @author hyc
 * @date 2020/7/4
 */

import java.util.Scanner;

/**
 * 题目描述
 * 守形数是这样一种整数，它的平方的低位部分等于它本身。比如25的平方是625, 低
 * 位部分是25,因此25是一个守形数。编一个程序， 判断N是否为守形数。
 * 输入描述:
 * 输入包括1个整数N，2<=N<100。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 输出"Yes !”表示w是守形数。
 * 输出"No!"表示N不是守形数。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 25
 * 4
 * 输出
 * | 复制
 * Yes!
 * No!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            if (judge(n)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
    public static boolean judge(int x){
        int pow = x * x;
        int sum = pow % 10;
        while (pow > 0){
            pow = pow / 10;
            if (sum == x){
               return true;
           }
           sum = sum + (pow % 10) * 10;
        }
        return false;
    }
}
