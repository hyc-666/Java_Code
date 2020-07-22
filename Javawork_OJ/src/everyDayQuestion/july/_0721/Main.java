package everyDayQuestion.july._0721;

/**
 * @author hyc
 * @date 2020/7/22
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 从C/C++转到Java的程序员，- 开始最不习惯的就是变量命名方式的改变。C语言风
 * 格使用下划线分隔多个单词，例如"hello_ world"; 而Java则采用-种叫骆驼命名法的
 * 规则:除首个单词以外，所有单词的首字母大写，例如"helloWorld"。
 * 请你帮可怜的程序员们自动转换变量名。
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据一行，包含一个c语言风格的变量名。每个变量名长度不超过100。
 * 输出描述:
 * 对应每一组数据，输出变量名相应的骆驼命名法。
 * 示例1输入输出示例仅供调试，后台判题数据般不包含示例
 * 输入
 * 复制I
 * hello_ world
 * nice_ to_ meet_ you
 * 输出
 * 复制
 * helloworld
 * niceToMeetYou
 */

//对于Java来说这样的操作就方便很多了
    //如果要是把Java风格的变量名转换成C语言的就要非典力气了
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strings = scanner.nextLine().split("_");
            //忘记了，第一个单词首字母不用大写的
            for (int i = 1; i < strings.length; i++) {
                strings[i] = toUpperCase(strings[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(strings[i]);
            }
            System.out.println(sb.toString());
        }
    }
    public static String toUpperCase(String s){
        char[] arr =s.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }
}
