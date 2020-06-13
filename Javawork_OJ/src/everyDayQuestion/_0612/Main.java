package everyDayQuestion._0612;

/**
 * @author hyc
 * @date 2020/6/12
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 口题目描述
 * 给定一个k位整数N = dk-1*10k-1+ .. +d1*101+ do (0<=d|<=9, i0..K1. dk-1>0),请编
 * 写程序统计每种不同的个位数字出现的次数。例如:给定N= 100311,则有2个0，3个
 * 1,和1个3。
 * 输入描述:
 * 每个输入包含1个测试用例，即- 一个不超过1000位的正整数N。
 * 输出描述:
 * 对Nv中每一种不同的个位数字， 以D:M的格 式在-行中输出该位数字p及其在N中出
 * 现的次数M。要求按D的升序输出。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 100311
 * 输出
 * | 复制
 * 0:2
 * 1:3
 * 3: 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            long n = scanner.nextInt();
            String s = n + "";
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int key = ch - 48;
                if (!map.containsKey(key)){
                    map.put(key,1);
                }else{
                    int value = map.get(key);
                    map.put(key,value + 1);
                }
            }
            for (int i = 0; i < 10; i++) {
                if (map.containsKey(i)){
                    System.out.println(i + ":" + map.get(i));
                }
            }
        }
    }
}
