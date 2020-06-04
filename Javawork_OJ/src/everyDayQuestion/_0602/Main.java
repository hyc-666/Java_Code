package everyDayQuestion._0602;

/**
 * @author hyc
 * @date 2020/6/3
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 有这样一道智力题:“某商店规定: 三个空汽水瓶可以换一瓶汽水。小张手上有十个空
 * 汽水瓶，她最多可以换多少瓶汽水喝?”答案是5瓶，方法如下:先用9个空瓶子换3瓶
 * 汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩
 * 2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子
 * 换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝?
 * 输入描述:
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一一个正整数
 * n (1<=n<=100) ，表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不
 * 应当处理这一行。
 * 输出描述:
 * 对于每组测试数据，输出- -行，表示最多可以喝的汽水瓶数。如果- -瓶也喝不到，
 * 输出0。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()){
            int n = input.nextInt();
            if (n == 0){
                return;
            }
    /*        int res = 0;
            int bottle = n;
            while (bottle > 2){
                int drink = bottle/3;// 能喝到的汽水=空瓶/3
                res = res + drink;//总数=已经喝到的+本轮喝到的
                bottle = drink + bottle % 3;//本轮得到的空瓶数量=本轮喝到的汽水+本轮剩余的空瓶
            }
            if (bottle == 2){//如果最后还剩余两个空瓶，那么还可以多喝一瓶
                System.out.println(++res);
            }else{
                System.out.println(res);
            }*/
            System.out.println(drinkCount(n));
        }
    }
    public static int drinkCount(int bottle){
        int res = 0;
        while (bottle > 2){
            int drink = bottle / 3;
            res += drink;
            bottle = drink + bottle % 3;
        }
        if (bottle == 2){
            res++;
        }
        return res;
    }
}
