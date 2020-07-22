package everyDayQuestion.july._0722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/22
 */

/**
 * a题目描述
 * 题目描述
 * 实现一个可存储若干个单词的字典。用户可以:
 * ➢在字典中加入单词。
 * ➢查找指定单词在字典中的兄弟单词个数。
 * ➢查找指定单词的指定序号的兄弟单词，指定序号指字典中兄弟单词按字典
 * 顺序(参见Page 3)排序后的序号(从1开 始)
 * ➢清空字典中所有单词。
 * 定义，格式说明
 * 由小写英文字母组成，不含其它字符。
 * 兄弟单词
 * 给定一个单词X，如果通过任意交换单词中字母的位置得到不同的单词Y,那么定义Y是
 * X的兄弟单词。
 * 字典顺序
 * 两个单词(字母按照自左向右顺序)，先以第一个字母作为排序的基准， 如果第一个字母
 * 相同，就用第二个字母为基准，如果第二个字母相同就以第三个字母为基准。依此类推，
 * 如果到某个字母不相同，字母顺序在前的那个单词顺序在前。如果短单词是长单词从首
 * 字母开始连续的一-部分，短单词顺序在前。
 * 举例: bca是abc的兄弟单词; abc与abc是相同单词，不是兄弟单词
 * 规格
 * ➢0<=字典中所含单词个数<=1000
 * ➢1<=单词所含字母数<=50
 * 测试用例保证，接口中输入不会超出如上约束。
 * 输入描述:
 * 先输入字典中单词的个数，再输入n个单词作为字典单词。
 * 输入一个单词，查找其在字典中兄弟单词的个数
 * 再输入数字n
 * 输出描述:
 * 根据输入，输出查找到的兄弟单词的个数
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 3
 * abc
 * bca
 * cab
 * abc
 * 1
 * 输出
 * bca
 * |2
 */

//华为的题是真的够难，够怪米日眼
    //看着代码我都一个头三个大
public class Main2 {
    private static boolean isBrother(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return new String(chars1).equals(new String(chars2)) && !str1.equals(str2);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] words = line.split(" ");

            // 要查的单词
            String item = words[words.length - 2];
            // 兄弟单词列表
            List<String> list = new ArrayList<>();
            for (int i = 1; i < words.length - 2; i++) {
                if(isBrother(words[i], item)){
                    list.add(words[i]);
                }
            }

            // 排序：字典顺序
            list.sort(String::compareTo);
            // 兄弟单词的个数
            System.out.println(list.size());
            int index = Integer.parseInt(words[words.length - 1]);
            // 需要判断
            if(!list.isEmpty() && index <= list.size()){
                System.out.println(list.get(index - 1));
            }
        }
    }
}
