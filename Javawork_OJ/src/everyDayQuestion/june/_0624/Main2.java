package everyDayQuestion.june._0624;

/**
 * @author hyc
 * @date 2020/6/25
 */

import java.util.Scanner;

/**
 * ■题目描述
 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的
 * 消息传递。假设你是军团中的一名军官，需要把发送来的消息破译出来、并提
 * 供给你的将军。
 * 消息加密的办法是:对消息原文中的每个字母，分别用该字母之后的第5个字母替换
 * (例如:消息原文中的每个字母A都分别替换成字母F)， 其他字符不变，并且消息原
 * 文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
 * 密码字母: ABCDEFGHIJKLMNOPQRST∪V WXY Z
 * 原文字母: VWXY ZABCDEFGHIJKL MNOPQRST∪
 * 输入描述:
 * 输入包括多组数据，每组数据一-行， 为收到的密文。
 * 密文仅有空格和大写字母组成。
 * 输出描述:
 * 对应每- -组数据，输出解密后的明文。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * HELLO WORLD
 * SNHJ
 * 输出
 * | 复制
 * CZGGJ RJMGY
 * NICE
 */
//这算是自嘲么
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(translate(s));
        }
    }

    //先来写转换函数
    public static String translate(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' '){
                if (ch - 5 < 'A'){
                    ch += 21;
                }else {
                    ch -= 5;
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
