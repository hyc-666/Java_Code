package everyDayQuestion._0605;

/**
 * @author hyc
 * @date 2020/6/7
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一-些物品，这些物品的总体积必须是
 * 40。John现在有n个想要得到的物品，每个物品的体积分别是a1, 2...... an。John可以从这些物
 * 品中选择一些， 如果选出的物体的总体积是40，那么利用这个神奇的]袋，John就可以得到这些
 * 物品。现在的问题是，John有多少种不同的选择物品的方式。
 * 输入描述:
 * 输入的第一-行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有
 * 一个1到40之间的正整数，分别给出a1，a...m的值。
 * 输出描述:
 * 输出不同的选择物品的方式的数目。
 * 示例1输入输出示例仅供调试， 后台判题数据-般不包含示例
 * 输入
 * 复制
 * 3
 * 20
 * 20
 * 20
 * 输出
 * | 复制
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int count = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {

            }
            /*for (int i = 0; i < n; i++) {
                int step = 0;
                sum = array[i];
                for (int j = i; j < n; j++) {
                    if (i == j){
                        continue;
                    }
                    sum += array[j];
                    if (sum == 40){
                        count++;
                        step++;
                        sum = array[i];
                        j = i + step;
                    }else if(sum > 40){
                        step++;
                        sum = array[i];
                        j = i + step;
                    }
                }
            }*/
            System.out.println(count);
        }
    }
}
