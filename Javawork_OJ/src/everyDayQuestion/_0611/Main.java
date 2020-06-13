package everyDayQuestion._0611;

/**
 * @author hyc
 * @date 2020/6/12
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * s题目描述
 * Fibonacci数列是这样定义的:
 * F[0]=0
 * F[1]= 1
 * for eachi≥2:F[]=F[-1]+ F[-2]
 * 因此，Fibonacci数列就形如: 0, 1, 1,2, 3, 5, 8, 13, ...在Fibonacci数列中的数我们称
 * 为Fibonacci数。给你一个N,你想让其变为-个Fibonacci数，每一步你可以把当前数
 * 字X变为X-1或者X+1,现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * 输入描述:
 * 输入为一个正整数N(1≤N≤1,000, 000)
 * 输出描述:
 * 输出一-个最小的步数变为Fibonacci数”
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 15
 * 输出
 * | 复制
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = fibList(1000000);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (n >= list.get(i) && n <= list.get(i + 1)){
                    index = i;
                    break;
                }
            }
            int left = n - list.get(index);
            int right = list.get(index + 1) - n;
            System.out.println(Math.min(left,right));
        }
    }
    public static List<Integer> fibList(int N){
        int f0 = 0,f1 = 1;
        List<Integer> list = new ArrayList<>();
        int fn = f0 + f1;
        list.add(f0);
        list.add(f1);
        list.add(fn);
        while (fn <= N){
            f0 = f1;
            f1 = fn;
            fn = f0 + f1;
            list.add(fn);
        }
        return list;
    }
}
