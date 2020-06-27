package everyDayQuestion.june._0626;

/**
 * @author hyc
 * @date 2020/6/27
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * a题目描述
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字:
 * A1 =能被5整除的数字中所有偶数的和;
 * A2 =将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-4...;
 * A3 =被5除后余2的数字的个数;
 * A4 =被5除后余3的数字的平均数，精确到小数点后1位;
 * A5 =被5除后余4的数字中最大数字。
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随
 * 后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 * 输出描述:
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格
 * 分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出"N”。
 *
 * 示例1:输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 1312345678910201618
 * 输出
 * 301129.79
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            switch (num % 5){
                case 0:
                    if (num % 2 == 0){
                        list1.add(num);
                    }
                    break;
                case 1:
                    list2.add(num);
                    break;
                case 2:
                    list3.add(num);
                    break;
                case 3:
                    list4.add(num);
                    break;
                case 4:
                    list5.add(num);
                    break;
                default:
                    break;
            }
        }
        if (list1.isEmpty()){
            System.out.print("N ");
        }else{
            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                sum += list1.get(i);
            }
            System.out.print(sum + " ");
        }
        if (list2.isEmpty()){
            System.out.print("N ");
        }else{
            int a = 1;
            int sum = 0;
            for (int i = 0; i < list2.size(); i++) {
                sum += a * list2.get(i);
                a = a * (-1);
            }
            System.out.print(sum + " ");
        }
        if (list3.isEmpty()){
            System.out.print("N ");
        }else{
            System.out.print(list3.size() + " ");
        }
        if (list4.isEmpty()){
            System.out.print("N ");
        }else{
            double avg = 0.0;
            int len = list4.size();
            for (int i = 0; i < len; i++) {
                avg += list4.get(i);
            }
            System.out.format("%.1f ",avg / len);
        }
        if (list5.isEmpty()){
            System.out.print("N ");
        }else{
            int max = list5.get(0);
            for (int i = 0; i < list5.size(); i++) {
                if (max < list5.get(i)){
                    max = list5.get(i);
                }
            }
            System.out.print(max);
        }
    }
}
