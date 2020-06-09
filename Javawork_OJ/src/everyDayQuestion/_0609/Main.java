package everyDayQuestion._0609;

/**
 * @author hyc
 * @date 2020/6/9
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 有一个数组a[N]顺序存放0~N_1，要求每隔两个数删掉一个数， 到末尾时循环至开头继
 * 续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例: {0, 1, 2, 3,
 * 4，5, 6, 7}，0->1->2(删除)->3->4->5(删除)->6->7->0(删除)如此循环直到最后一 个
 * 数被删除。
 * 输入描述:
 * 每组数据为一行-一个整数n (小于等于1000)，为数组成员数，如果大于1000，则对
 * a[999]进行计算。
 * 输出描述:
 * -行输出最后一个被删掉的数的原始下标位置。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 输出
 * 复制|
 * 6
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            if (n > 1000){
                n = 1000;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            //实际上，最后剩下的那个数字就是这个数字的原始下标
            int i = 0;
            int size = n;
            while (size > 1){
                i += 2;
                if (i == n){
                    i = 0;
                }
                if (i > n){
                    i = 1;
                }
                while (arr[i] == -1){
                    i++;
                    if (i == n){
                        i = 0;
                        continue;
                    }
                    if (i > n){
                        i = 1;
                    }
                }
               arr[i] = -1;
                size--;
            }
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] != -1){
                    index = j;
                    break;
                }
            }
            System.out.println(arr[index]);
        }
    }
}