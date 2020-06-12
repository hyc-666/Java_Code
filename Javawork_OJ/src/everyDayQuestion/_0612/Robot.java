package everyDayQuestion._0612;

/**
 * @author hyc
 * @date 2020/6/12
 */

/**
 * ■题目描述
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下
 * 角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,inty,请返回机器人的走法数目。保证x+ y小于等于12。
 * 测试样例:
 * 2,2
 * 返回: 2
 */
public class Robot {
    public int countWays(int x, int y) {
        if ( x <= 0 || y <= 0){
            return 0;
        }
        if (x < 2){
            return y - 1;
        }
        if (y < 2){
            return x - 1;
        }
        return combination(x,2) + combination(y,2);
    }
    //计算排列组合
    public static int combination(int n,int m){
        return factorial(n) / (factorial(m) * factorial(n - m));
    }
    //计算阶乘
    public static int factorial(int n){
        int ret = 1;
        for (int i = n; i > 0; i--) {
            ret = ret * i;
        }
        return ret;
    }
}