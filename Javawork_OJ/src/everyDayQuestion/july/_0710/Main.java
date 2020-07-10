package everyDayQuestion.july._0710;

/**
 * @author hyc
 * @date 2020/7/10
 */

/**
 * ■题目描述
 * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下:我每天
 * 给你10万元，你第一天给我1分钱，第二天2分钱，
 * 第三天4分钱
 * 这样交换30天后，百万富翁交出了多少钱?陌生人交出了多少钱? (注意一 个是万元，
 * 一个是分)
 * 输入描述:
 * 该题没有输入
 * 输出描述:
 * 输出两个整数，分别代表百万富翁交出的钱和陌生人交出的钱，富翁交出的钱以万元
 * 作单位，陌生人交出的钱以分作单位。
 */

//时过不久，再次遇到这个题，关键在于，即使是使用long类型，计算结果也是会溢出
public class Main {
    public static void main(String[] args) {
//        System.out.println((long)Math.pow(2,30));
        //经过测试，2^30不会溢出，因此每算出达到1w就转换成万
        long out = 0;
        long sum = 0;
        for (int i = 0; i < 30; i++) {
            long temp = (long)Math.pow(2,i);
            while (temp >= 1000000L){
                //每次达到一万元就结果就多加一万，out以万做单位
                temp -= 1000000L;
                out++;
            }
            sum += temp;
            while (sum >= 1000000L){
                sum -= 1000000L;
                out++;
            }
        }
        long in = 100000 * 30 * 1000000L;
        System.out.println(out + " " + in);

        //虽然想的挺好，但是结果还是没有算出来，提交还是错的
    }
}
