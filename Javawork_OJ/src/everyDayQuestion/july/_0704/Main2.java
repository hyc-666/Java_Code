package everyDayQuestion.july._0704;

/**
 * @author hyc
 * @date 2020/7/5
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ■题目描述
 * 对N个长度最长可达到1000的数进行排序。
 * 输入描述:
 * 输入第一行为一个整数N，(1<=N<=100)。
 * 接下来的N行每行有一一个数，数的长度范围为1<=len<=1000。
 * 每个数都是一个正数，并且保证不包含前缀零。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排
 * 序后的结果，每个数占一行。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * |复制|
 * 3
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 * 33333333
 * 输出
 * | 复制
 * 33333333
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 */

public class Main2 {
    //大整数排序问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                stringList.add(s);
            }
            stringList.sort(new Comparator<String>() {
                //重新定义排序规则
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() < o2.length()){
                        //比较总体长度，没有以0开头的，那么位长的数字肯定大
                        return -1;
                    }else if (o1.length() > o2.length()){
                        return 1;
                    }else {
                        //如果位相等，就从高位往低位比较，相同位上数字大的数大
                        for (int i = 0; i < o1.length(); i++) {
                            if (o1.charAt(i) < o2.charAt(i)) {
                                return -1;
                            } else if (o1.charAt(i) > o2.charAt(i)) {
                                return 1;
                            }
                        }
                    }
                    //如果位长相等，相同位上的数字也相等，那么这两个数就相等。
                    return 0;
                }
            });
            for (String s : stringList){
                System.out.println(s);
            }
        }
    }
}
