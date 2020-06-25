package everyDayQuestion.june._0625;

/**
 * @author hyc
 * @date 2020/6/25
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ■题目描述
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但
 * 是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
 * 下，某串珠子里是否包含了全部自己想要的珠子?如果是，那么告诉她有多少多余的
 * 珠子;如果不是，那么告诉她缺了多少珠子。
 * 为方便起见，我们用[0-9]、 [a-z]、 [A-Z]范围内的字符来表示颜色。例如，YrR8RrY是
 * 小红想做的珠串;那么ppRYYGrrYBR2258可以买，因为包含了
 * 全部她想要的珠子，还多了8颗不需要的珠子; ppRYYGrrYB225不能买， 因为没有黑
 * 色珠子，并且少了一颗红色的珠子。
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红
 * 想做的珠串，两串都不超过1000个珠子。
 * 输出描述:
 * 如果可以买，则在一行中输出“Yes"”以及有多少多余的珠子，如果不可以买，则在
 * -行中输出“No"以及缺了多少珠子。其间以1个空格分隔。
 * 示例1输入输出示例仅供调试，后台判题数据般不包含示例
 * 输入
 * 复制
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 输出
 * 复制
 * Yes 8
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String give = scanner.next();
        String wanted = scanner.next();
        int gl = give.length();
        int wl = wanted.length();
        List<Character> gList = new ArrayList<>(gl);
        for (int i = 0; i < gl; i++) {
            gList.add(give.charAt(i));
        }
        int count = 0;
        boolean enough = true;
        for (int i = 0; i < wl; i++) {
            Character ch = wanted.charAt(i);
            if (gList.contains(ch)){
                gList.remove(ch);
            }else{
                count++;
                enough = false;
            }
        }
        if (enough){
            System.out.println("Yes" + gList.size());
        }else{
            System.out.println("No" + count);
        }
    }
}
