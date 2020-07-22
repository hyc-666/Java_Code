package everyDayQuestion.july._0720;

/**
 * @author hyc
 * @date 2020/7/22
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ■题目描述
 * 输入两个整数n和m,从数列1, 2, ......中随意取几个数，使其和等于m，要求将
 * 其中所有的可能组合列出来
 * 输入描述:
 * 每个测试输入包含2个整数, n和m
 * 输出描述:
 * 按每个组合的字典序排列输出,每行输出一-种组合
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 55
 * 输出
 * 复制
 * 14
 * 23
 * 5
 */
//如果只是算两个数字的和应该可以的
//这种组合和一些过程中不确定的算法我真的不会，我真的不是数学家

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if (m <= 0 || n <= 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        dfs(list, new ArrayList<Integer>(), m);

    }

    private static void dfs(List<Integer> list, List<Integer> sub, int m) {
        int sum = 0;
        for (int i = 0; i < sub.size(); i++) {
            sum += sub.get(i);
        }
        if (sum == m) {
            for (int i = 0; i < sub.size(); i++) {
                System.out.print(sub.get(i));
                if (i != sub.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < list.size(); i++) {
            sub.add(list.get(i));
            dfs(list.subList(i+1, list.size()), sub, m);
            sub.remove(sub.size()-1);
        }

    }
}