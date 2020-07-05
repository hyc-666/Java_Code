package everyDayQuestion.july._0703;

/**
 * @author hyc
 * @date 2020/7/5
 */

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方
 * 案数。
 * 当两种选取方案有一个数字的下标不一样，我们就认为是不同的组成方案。
 * 输入描述:
 * 输入为两行:
 * 第一行为两个正整数n(1≤n≤1000)， sum(1 ≤sum≤1000)
 * 第二行为n个正整数A[i] (32位整数)，以空格隔开。
 * 输出描述:
 * 输出所求的方案数
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 5 1555102 3
 * 输出
 * |复制
 * 4
 */

//这几天的题目有点让人崩溃啊
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(getAll(arr,sum));
        }
    }

    public static int getAll(int[] arr,int sum){
        int count = 0;
        for (int i = 1; i < arr.length; i++) {//为什么小标要从1开始呢？
            count += getM(arr,i,0,sum);
        }
        return count;
    }

    public static int getM(int[] arr,int i,int zero,int sum){
        int count = 0;
        if (i == 0){
            return sum == 0 ? 1 : 0;
        }
        for (int j = zero; j < arr.length - i; j++) {
            if (arr[j] <= sum){
                count += getM(arr,i - 1,zero + 1,sum - arr[j]);
            }
        }
        return count;
    }
}
