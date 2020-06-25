package everyDayQuestion.june._0619;

/**
 * @author hyc
 * @date 2020/6/20
 */

import java.util.*;

/**
 * ■题目描述
 * 给定-个正整数N代表火车数量，0<N<10, 接下来输入火车入站的序列，一共N辆火
 * 车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
 * 输入描述:
 * 有多组测试用例，每-组第一行输入一个正整数N (0<N<10) ，第二行包括N个正
 * 整数，范围为1到9。
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序
 * 列换行，具体见sample。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 123
 * 输出
 * 复制
 * 123
 * 132
 * 213
 * 231
 * 321
 */
public class Main {
    public static void main(String[] args) {
        //栈的全排列问题，好像并不会
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();
            List<Integer> list = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                list.add(scanner.nextInt());
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                stack.push(list.get(i));
            }

        }
    }
}
