package everyDayQuestion.july._0716;

/**
 * @author hyc
 * @date 2020/7/17
 */

/**
 * ■题目描述
 * 将-个英文语句以单词为单位逆序排放。例如"I am a boy",逆序排放后为"boy a aml'"
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 接口说明
 * /**
 * *反转句子
 * * @param sentence原句子
 * * @return反转后的句子
 * */

import java.util.Scanner;

/** public String reverse(String sentence);
        *输入描述:
        *将一个英文语句以单词为单位逆序排放。
        *输出描述:
        *得到逆序的句子
        *示例1输入输出示例仅供调试， 后台判题数据-般不包含示例
        *输入
        *I am aboy
        *输出
        *boyaamI
 */
public class Main2 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()){
             String[] str = scanner.nextLine().split(" ");
             int i = 0;
             int j = str.length - 1;
             while (i < j){
                 String temp = str[i];
                 str[i] = str[j];
                 str[j] = temp;
                 i++;
                 j--;
             }
             StringBuilder sb = new StringBuilder();
             for (int k = 0; k < str.length; k++) {
                 sb.append(str[k] + " ");
             }
             System.out.println(sb.substring(0,sb.length() - 1));
         }
     }
}
