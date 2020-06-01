package everyDayQuestion._0601;
//每日一题0601

/**
 * @author hyc
 * @date 2020/6/1
 */

import java.util.Scanner;

/**
 * ■题目描述
 * “回文串”是一个正读和反读都一样的字符串，比如"level"或者"noon"等等就是
 * 回文串。花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼
 * 物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字
 * 符串A使产生的字符串是一个回文串。 你接受花花的请求，帮助她寻找有多少
 * 种插入办法可以使新串是一个回文串。 如果字符串B插入的位置不同就考虑为
 * 不一样的办法。
 * 例如:
 * A=“aba", B=“b"。这里有4种把B插入A的办法:
 * *在A的第一个字母之 前: "baba"不是回文
 * *在第一个字母'a'之后: "abba"是回文
 * *在字母b'之后: "abba"是回文
 * *在第二个字母'a'之后"abab"不是回文
 * 所以满足条件的答案为2
 * 输入描述:
 * 每组输入数据共两行。
 * 第一行为字符串A
 * 第二行为字符串B
 * 字符串长度均小于100且只包含小写字母
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int count = 0;
            for (int i = 0; i <= s1.length(); i++) {
                String s = s1.substring(0,i) + s2 + s1.substring(i);
                if (isPlain(s)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    //判断回文串，双指针法
    public static boolean isPlain(String str){
        if (str.length() <= 0){
            return false;
        }
        int i = 0,j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
