package everyDayQuestion.june._0617;

/**
 * @author hyc
 * @date 2020/6/17
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初
 * 始位置x_ 0。对于小易所处的当前位置x，他只能通过神秘的力量移动到4*x + 3或者8
 * *X+ 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000
 * 次。贝壳总生长在能被1 000,000,007整除的位置(比如:位置0，位置,000,000,007,
 * 位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝
 * 壳。
 * 输入描述:
 * 输入一个初始位置x_ _0, 范围在1到1, 000, 000, 006
 * 输出描述:
 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输
 * 出-1
 */
//日怪的题目是越来越多了
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int x = scanner.nextInt();
            System.out.println(count(x));
        }
    }

    //题目很日怪，我看了汗多解析也还是没怎么看明白，
    //所以，代码基本也是抄的
    public static int count(int x){
        if (x % 1000000007 == 0){
            return 0;
        }
        int res = 0;
        while (x != 0 && res < 300000){
            x = ((x << 1) + 1) % 1000000007;
            res++;
        }
        int result = (res + 2 ) / 3;
        return result > 100000 ? -1 : result;
    }
}
