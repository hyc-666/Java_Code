package everyDayQuestion._0616;

/**
 * @author hyc
 * @date 2020/6/16
 */

/**
 * ■题目描述
 * 验证尼科彻斯定理，即:任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如:
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 * 接口说明
 * 原型:
 * /*
 * 功能:验证尼科彻斯定理，即:任何一个整数m的立方都可以写成m个连续奇数之和。
 * 原型:
 * int GetSequeOddNum(int m,char * pcSequeOddNum);
 * 输入参数:
 * int m:整数(取值范围: 1~ 100)
 * 返回值:
 * m个连续奇数(格式:“7+9+11");
 * */
 /*public String GetSequeOddNum(int m)
        * /*在这里实现功能
        *return null;

  */
public class Main2 {
    /**
     * 为什么要把程序员当成是数学家呢
     * @param m
     * @return
     */
    public String GetSequeOddNum(int m){
        //先计算m的立方吧，按照题目要求，这个结果应该没有越界
        //至于这个sum怎么分解我真的不是数学家
        //分解后第一个开始的数是 n*n-n+1
        //所以，我算什么三次方呢，这不是就出来了么，
        //数学上已经证明了的
        StringBuilder stringBuilder = new StringBuilder();
        //第一个数是是n*n-n+1
        int first = m * m - m + 1;
        for (int i = 0; i < m; i++) {
            stringBuilder.append(first + "+");
            first += 2;
        }
        String s = stringBuilder.toString();
        return s.substring(0,s.length() - 1);//返回的时候去掉最后一个加号
    }
}
