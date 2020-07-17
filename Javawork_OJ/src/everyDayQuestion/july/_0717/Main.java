package everyDayQuestion.july._0717;

/**
 * @author hyc
 * @date 2020/7/17
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 一个数组有N个元素，求连续子数组的最大和。例如: [-1,2,1], 和最大的连续子数
 * 组为[2,1]，其和为3
 * 输入描述:
 * 输入为两行。第一行一个整数n(1 <= n <= 100000)， 表示一共有n个元素
 * 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
 * 输出描述:
 * 所有连续子数组中和最大的值。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 3-121
 * 输出
 * | 复制
 * 3
 */
public class Main {
    public static void main(String[] args) {
        //那么问题来了，12321算不算连续呢
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            //找最大连续的起始位置和结束位置
            int[] res1 = endLenLower(arr);
            int[] res2 = endLenUpper(arr);

            int max = 0;
            int end = 0;

            if (res1[0] > res2[0]){
                end = res1[1];
                max = res1[0];
            }else{
                end = res2[1];
                max = res2[0];
            }

            int sum = 0;
            for (int i = 0; i <= max; i++) {
                sum += arr[end];
                end--;
            }
            System.out.println(sum);
        }
    }

    public static int[] endLenUpper(int[] arr){
        int i = 0,j = 1,end = 0;
        int max = 0,temp = 0;
        while (i < arr.length && j < arr.length){
            if (arr[i] - arr[j] == -1){
                i++;
                j++;
                temp++;
                if (max < temp ){
                    max = temp;
                    end = i;
                }
            }else{
                temp = 0;
                i++;
                j++;
            }
        }
        int[] a = new int[2];
        a[0] = max;
        a[1] = end;
        return a;
    }

    public static int[] endLenLower(int[] arr){
        int i = 0,j = 1,end = 0;
        int max = 0,temp = 0;
        while (i < arr.length && j < arr.length){
            if (arr[i] - arr[j] == 1){
                i++;
                j++;
                temp++;
                if (max < temp ){
                    max = temp;
                    end = i;
                }
            }else{
                temp = 0;
                i++;
                j++;
            }
        }
        int[] a = new int[2];
        a[0] = max;
        a[1] = end;
        return a;
    }
}
