package everyDayQuestion.july._0706;

/**
 * @author hyc
 * @date 2020/7/7
 */

import java.util.Scanner;

/**
 * 题目描述
 * 给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
 * 输入描述:
 * 测试输入包含一一个测试用例，在一行内给出总长度不超过80的字符串。字符串由若
 * 干单词和若干空格组成，其中单词是由英文字母(大小写有区分)组成的字符串，
 * 单词之间用1个空格分开，输入保证句子末尾没有多余的空格。
 * 输出描述:
 * 每个测试用例的输出占-行，输出倒序后的句子。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * Hello World Here I Come
 * 输出
 * 复制
 * Come I Here World Hello
 */
public class Main {
    public static void main(String[] args) {
        //Java的处理方式稍轻松一点
        Scanner scanner = new Scanner(System.in);
        //每个输入只有一个测试用例
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        reverse(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i] + " ");
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1));

    }
    //要做的就是把这个数组内容倒置
    public static void reverse(String[] strings){
        int i = 0;
        int j = strings.length - 1;
        while (i < j){
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
    }
}
