package everyDayQuestion.writtenexam1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/8/3
 */

/**
 * ■题目描述
 * 读入一个字符串str,输出字符串str中的连续最长的数字串
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str,长度不超过255。
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * abcd12345ed125ss123456789
 * 输出
 * 123456789
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string[] = scanner.next().split("\\D");
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch >= '0' && ch <= '9'){
//                sb.append(ch);
//            }else{
//
//            }
        Arrays.sort(string, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        System.out.println(string[0]);
    }
}
