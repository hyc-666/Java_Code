package everyDayQuestion.july._0701;

/**
 * @author hyc
 * @date 2020/7/2
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * a题目描述
 * 输入一个数n,然后输入n个数值各不相同，再输入-个值x，输出这个值在这个数组中
 * 的下标(从0开始，若不在数组中则输出-1)。
 * 输入描述:
 * 测试数据有多组，输入n(1<=n<=200)， 接着输入n个数，然后输入x。
 * 输出描述:
 * 对于每组输入，请输出结果。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 2
 * 13
 * 0
 * 输出
 * 复制
 * -1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            Map<Integer,Integer> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                int key = scanner.nextInt();
                map.put(key,i);
            }
            int x = scanner.nextInt();
            System.out.println(map.get(x) == null ? -1 : map.get(x));
        }
    }
}
