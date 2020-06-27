package everyDayQuestion.june._0627;

/**
 * @author hyc
 * @date 2020/6/27
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 小易经常沉迷于网络游戏有- -次他在玩-个打怪升级的游戏他的角色的初始能力值为a.在接下
 * 来的一段时间内，他将会依次遇见n个怪物每个怪物的防御力为b1,b2,b3.. .bn.如果遇到的怪物防御
 * 力bi小于等于小易的当前能力值c那么他就能轻松打败怪物，并且使得自己的能力值增加bi;如果bi
 * 大于c,那他也能打败怪物，但他的能力值只能增加bi与c的最大公约数，那么问题来了,在一系列的锻
 * 炼后，小易的最终能力值为多少?
 * 输入描述:
 * 对于每组数据,第一-行是两个整数n (1Sn<100000)表示怪物的数量和a表示小易的初始能力值.
 * 第二行n个整数, b1, b2. ..bn (1SbiSn)表示每个怪物的防御力
 * 输出描述:
 * 对于每组数据,输出-行.每行仅包含一个整数,表示小易的最终能力值
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * [复制
 * <pre>3 50
 * 50 105 200
 * 520
 * 30 20 15 40 100</pre>
 * 输出
 * |复制
 * 110
 * 205
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();//本轮怪物数量
            int a = scanner.nextInt();//小易的初始能力值
            for (int i = 0; i < n; i++) {
                int power = scanner.nextInt();
                if (a >= power){
                    a += power;
                }else{
                    a += maxCommonDivisor(a,power);
                }
            }
            System.out.println(a);
        }
    }
    //辗转相除法计算最大公约数
    public static int maxCommonDivisor(int a,int b){
        int m = a;
        int n = b;
        if (m < n){      //先确定哪个是除数哪个是被除数
            int temp = m;   //大数为被除数，小数为除数
            m = n;
            n = temp;
        }
        int r;        //r用来记录余数
        do{
            r = m%n;     //大数除小数得到余数
            m = n;      //除数作为被除数
            n = r;       //将余数作为除数
        } while (r != 0);    //r余数不为0则执行循环，否则跳出
        return m;
    }
}
