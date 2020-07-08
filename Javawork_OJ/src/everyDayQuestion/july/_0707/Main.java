package everyDayQuestion.july._0707;

/**
 * @author hyc
 * @date 2020/7/7
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 如果你是哈利波特迷，你会知道魔法世界有它自己的货币系统一就如海格告诉哈
 * 利的:“十七个银西可(Sickle)兑一 个加隆(Galleon), 二
 * 十九个纳特(Knut)兑一个西可， 很容易。“现在， 给定哈利应付的价钱P和他实付的钱
 * A,你的任务是写一个程序来计算他应该被找的零钱。
 * 输入描述:
 * 输入在1行中分别给出p和A，格式为"Galleon. sickle. Knut",其间用1个空格
 * 分隔。这里Galleon是[0，107]]区间内的整数， sickle是 [0,
 * 17)区间内的整数，Knut是 [0，29)区间内的整数。
 * 输出描述:
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么
 * 输出的应该是负数。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * |复制|
 * 10.16.27 14.1.28
 * 输出
 * 复制
 * 3.2.1
 */

//我只想说一句我不是哈利波特迷。。
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //有时候吧，他每个输入只有一个测试用例，你写成多个就有问题
        String need = scanner.next();
        String payed = scanner.next();
        //由于正则表达式.表示陪陪任意单字符，所以这里用一位非数字来分隔
        String[] n = need.split("\\D");
        String[] p = payed.split("\\D");
        //化成统一货币然后直接相减
        long fee = Integer.valueOf(n[0]) * 17 * 29 + Integer.valueOf(n[1]) * 29 + Integer.valueOf(n[2]);
        long pay = Integer.valueOf(p[0]) * 17 * 29 + Integer.valueOf(p[1]) * 29 + Integer.valueOf(p[2]);
        long res = pay - fee;
        long parr = Math.abs(res);
        long[] arr = trans(parr);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i] + ".");
        }
        if (res > 0){
            System.out.println(s.substring(0,s.length() - 1));
        }else{
            System.out.println("-" + s.substring(0,s.length() - 1));
        }

    }
    public static long[] trans(long x){
        long[] arr = new long[3];
        long yuan = x / (17 * 29);
        x = x % (17 * 29);
        long jia = x / 29;
        x = x % 29;
        arr[0] = yuan;
        arr[1] = jia;
        arr[2] = x;
        return arr;

    }
}

