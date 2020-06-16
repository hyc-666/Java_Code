package everyDayQuestion._0616;

/**
 * @author hyc
 * @date 2020/6/16
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ■题目描述
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使
 * 得最后得到的数尽可能小(注意0不能做首位)。例如:
 * 给定两个0，两个1,三个5,一个8，我们得到的最小的数就是10015558。
 * 现给定数字，请编写程序输出能够组成的最小的数。
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示
 * 我们拥有数字0、数字1、... 数字9的个数。整数间用-一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
 * 输出描述:
 * 在一行中输.出能够组成的最小的数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            //把这些数存到list中
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int n = scanner.nextInt();
                for (int j = 0; j < n; j++) {
                    list.add(i);
                }
            }
            //排序
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int index = 0;
            //找第一个不是0的最小的数的下标
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != 0){
                    index = i;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(list.get(index) + "");
            for (int i = 0; i < list.size(); i++) {
                if (i != index) {
                    stringBuilder.append(list.get(i));
                }
            }
            //真的难用，它输出说的是输出一个数，但是转成数字却不行，还是要输出字符串
//            System.out.println(Integer.parseInt(stringBuilder.toString()));
            System.out.println(stringBuilder.toString());
        }
    }
}
