package everyDayQuestion.july._0721;

/**
 * @author hyc
 * @date 2020/7/22
 */

import java.util.Scanner;

/**
 * s题目描述
 * 对字符串中的所有单词进行倒排。
 * 说明:
 * 1、每个单词是以26个大写或小写英文字母构成;
 * 2、非构成单词的字符均视为单词间隔符;
 * 3、要求倒排后的单词间隔符以一个空格表示;如果原字符串中相邻单词间有多
 * 个间隔符时，倒排转换后也只允许出现一个空格间隔符;
 * 4、每个单词最长20个字母;
 * 输入描述:
 * 输入一行以空格来分隔的句子
 * 输出描述:
 * 输出句子的逆序
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * I am a student
 * 输出
 * |复制
 * student a am I
 */
public class Main2 {
    public static void main(String[] args) {
        //不知道这样行不行
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] s = scanner.nextLine().split("\\W");
            reverse(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i] + " ");
            }
            System.out.println(sb.substring(0,sb.length() - 1));
        }
    }
    //90%case通过率是我没有想到的
    //应该是把所有非单词字符都要换成间隔符
    //正则表达式挺香的
    public static void reverse(String[] strings){
        int i = 0,j = strings.length - 1;
        while (i < j){
            String temp =  strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
    }
}
