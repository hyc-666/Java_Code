package everyDayQuestion.july._0703;

/**
 * @author hyc
 * @date 2020/7/5
 */

import java.util.Scanner;

/**
 * 题目描述
 * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩:
 * 1.首先，所有人员都将-张写有自己名字的字条放入抽奖箱中;
 * 2.待所有字条加入完毕，每人从箱中取一个字条;
 * 3.如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了!”
 * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖?
 * 输入描述:
 * 输入包含多组数据，每组数据包含- -个正整数n (2SnS20) 。
 * 输出描述:
 * 对应每- -组数据，以“xx. xx8”的格式输出发生无人获奖的概率。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 2
 * 输出
 * 50. 00号
 */

//出成数学题我都不一定会算，别说编程题了
    //我觉得这题应该出给数学家
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            float p = notSelf(n) / all(n) * 100;
            System.out.format("%.2f",p);
            System.out.printf("%%\n");
        }
    }
    //计算所有可能的情况
    public static float all(int n){
        float res = 1.0f;
        if (n == 0){
            return 1;
        }else if(n > 0){
            res = n * all(n - 1);
        }
        return res;
    }

    //计算每个人都抽不到自己的情况
    public static float notSelf(int n){
        //就是计算错排的情况
        if (n == 1){
            //只有一个人无错排情况
            return 0;
        } else if (n == 2){
            //两个人只有一种错排情况
            return 1;
        }else{
            return (n - 1) * (notSelf(n - 1) + notSelf(n - 2));
        }
    }
}
