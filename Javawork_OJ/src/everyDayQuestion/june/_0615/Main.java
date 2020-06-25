package everyDayQuestion.june._0615;

/**
 * @author hyc
 * @date 2020/6/15
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史
 * 上首位编写计算机代码的总统。2014年底， 为庆祝“计算
 * 机科学教育周”正式启动，奥巴马编写了很简单的计算机代码:在屏幕上画一个正方
 * 形。现在你也跟他一起画吧!
 * 输入描述:
 * 输入在- -行中给出正方形边长N (3<=N<=20)和组成正方形边的某种字符c，间隔
 * 一个空格。
 * 输出描述:
 * 输出由给定字符c画出的正方形。但是注意到行间距比列间距大，所以为了让结果
 * 看上去更像正方形，我们输出的行数实际上是列数的50号
 * (四舍五入取整)。
 */

//所以，有时候一些题目就很日怪
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            char ch = scanner.next().charAt(0);
            for (int i = 0; i < n; i++) {
                System.out.print(ch);
            }
            System.out.println();
            for (int i = 0; i < n / 2 - 2; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1){
                        System.out.print(ch);
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < n; i++) {
                System.out.print(ch);
            }
        }
    }
}
