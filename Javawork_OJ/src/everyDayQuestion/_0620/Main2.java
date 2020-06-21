package everyDayQuestion._0620;

/**
 * @author hyc
 * @date 2020/6/21
 */

/**
 * ■题目描述
 * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下:我每天给
 * 你10万元，你第一天给我1分钱，第二天2分钱，
 * 第三天4分钱....
 * 这样交换30天后，百万富翁交出了多少钱?陌生人交出了多少钱? (注意一 个是万元，
 * 一个是分)
 * 输入描述:
 * 该题没有输入
 * 输出描述:
 * 输出两个整数，分别代表百万富翁交出的钱和陌生人交出的钱，富翁交出的钱以万元
 * 作单位，陌生人交出的钱以分作单位。
 */
public class Main2 {
    public static void main(String[] args) {
        //陌生人交出的钱很好算，10w * 30；
        //富翁第一天交出 pow(2,0) 分
        //第二天交出  pow(2,1);
        //第三天   pow(2,2);
        //第 n天 pow(2,n - 1);
        //这是一个累加的过程
        //30天的话估计应该不会溢出
        int million = 0;
        for (int i = 0; i < 30; i++) {
            million = million + (int)Math.pow(2,i);
        }
        long coin = 100000 * 30;
        //这批题目迷惑的很，算是都会算的，最后在单位上整你那么一下子
        //一分和一万之间的进制应该是10000 * 100
        million = million / 1000000;
        coin = coin * 1000000;
        System.out.println(million);
        System.out.println(coin);

    }
}
