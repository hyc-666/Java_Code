package everyDayQuestion.july._0716;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/17
 */

/**
 * ■题目描述
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”
 * They are students. "和"aeiou",则删除之后的第一个字符串变成Thy「stdnts."
 * 输入描述:
 * 每个测试输入包含2个字符串
 * 输出描述:
 * 输出删除后的字符串
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * They are students .
 * aeiou
 * 输出
 * 复制
 * Thy r stdnts.
 */
public class Main {
    public static void main(String[] args) {
        //不知道是不是要区分大小写，题目也说不明白，好多时候还得要自己去试
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String s = removeChars(s1,s2);
            System.out.println(s);
        }
    }

    public static String removeChars(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    arr1[i] = 0;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != 0){
                sb.append(arr1[i]);
            }
        }
        return sb.toString();
    }
}
