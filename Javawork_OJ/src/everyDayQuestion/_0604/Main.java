package everyDayQuestion._0604;

/**
 * @author hyc
 * @date 2020/6/5
 */

import java.util.Scanner;

/**
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的
 * 包装(包装不可拆分)。可是小易现在只想购买恰好n个苹果， 小易想购买尽量少的袋数
 * 方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 * 输入描述:
 * 输入一个整数n，表示小易想购买n(1≤n≤100)个苹果
 * 输出描述:
 * 输出一-个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 20
 * 输出
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            //一一定要写scanner.hasNextInt.其他都是徒劳和白努力
            int n = scanner.nextInt();
            int max8 = n / 8;
           int other = n % 8;
             /*if (other == 0){
                System.out.println(max);
                continue;
            }
            if (other == 6){
                System.out.println(max + 1);
                continue;
            }*/
            int max6 = 0;
            while (other % 6 > 0 && max8 > 0){
                max8 = max8 - 1;
                other = other + 8;
                max6 = max6 + other / 6;
                other = other % 6;
            }
            if (max8 > 0){
                System.out.println(max8 + max6 + other / 6);
            }else {
                if (other % 6 != 0) {
                    System.out.println(-1);
                }else{
                    System.out.println(max8 + max6 + other / 6);
                }
            }
        }
    }
}
