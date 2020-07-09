package everyDayQuestion.july._0708;

/**
 * @author hyc
 * @date 2020/7/9
 */

/**
 * 题目描述
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩-次可以上1阶、2阶、3阶。 请实现一个
 * 方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 100000007
 * 给定一个正整数int n, 请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例1:
 * 1
 * 返回: 1
 * 测试样例2:
 * 3
 * 返回: 4
 * 测试样例3:
 * 4
 * 返回: 7
 */
public class GoUpstairs {
    //跟曾经的一个青蛙跳台阶的题类似
    public int countWays(int n) {
        // write code here
//        return (int) (count(n) % 100000007);
        //代码可行，但是栈溢出，所以，得把递归转换为迭代
        /**
         * 分析：
         * n   结果
         * 0    0
         * 1    1
         * 2    2(1+1或者2)
         * 3    4（1+1+1或者1+2或者2+1或者3）
         * 4    1+2+4(前三项之和)
         */
        //那么可以用迭代算了
        long f1 = 1;
        long f2 = 2;
        long f3 = 4;
        if (n == 1){
            return (int)f1;
        }
        if (n == 2){
            return (int)f2;
        }
        if (n == 3){
            return (int)f3;
        }
        long fn = 0;
        for (int i = 4; i <= n; i++) {
            fn = f1 + f2 + f3;
            f1 = f2 % 100000007;
            f2 = f3 % 100000007;
            f3 = fn % 100000007;
        }
        return (int)(fn % 100000007);
    }
    public static long count(int n){
        if (n == 1){//只有一种跳法
            return 1;
        }
        if (n == 2){//有两种跳法，1，1或者2
            return 2;
        }
        if (n == 3){//有4种跳法：1，1，1或者1，2或者2，1或者3
            return 4;
        }
        return count(n - 1) + count(n - 2) + count(n - 3);
    }
}