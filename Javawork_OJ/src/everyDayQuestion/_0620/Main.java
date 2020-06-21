package everyDayQuestion._0620;

/**
 * @author hyc
 * @date 2020/6/21
 */

import java.util.Scanner;

/**
 * s题目描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例(定义为GC-Ratio)
 * 是序列中G和C两个字母的总的出现次数除以总的字母数目(也就是序列长度)。 在基
 * 因工程中，这个比例非常重要。因为高的GC-Ratio可能是 基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中
 * 找出GC-Ratio最高的子序列。
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述:
 * 找出Gcc比例最高的子串,如果有多个输出第一个的子串
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * AACTGTGCACGACCTGA
 * 5
 * 输出
 * | 复制
 * GCACG
 */

//每次这个都题目就就让我很是费劲，要么就是有的题目啰里啰唆说不清楚，
//要么就是有的题目简短的想让人不知道它要干什么
//还有的题目描述的输入输出与给的示例输入输出差别太大或者是根本就不一样
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int subLength = scanner.nextInt();
        if (subLength > s.length() || subLength < 0) {
            return;
        }
        //由于如果要是比例相同的那么题目要求是返回第一次出现的
        //故而我们从后往前倒着检测，顺着检测也行，就是遇到相同比例的就丢弃，更大的就替换
        String str = "";
        int len = 0;
        for (int i = 0; i < s.length() - subLength + 1; i++) {
            String tempStr = s.substring(i, i + subLength);
            int tempLen = max(tempStr);
            if (tempLen > len) {
                len = tempLen;
                str = tempStr;
            }
        }
        System.out.println(str);

    }

    //由于字串的长度在每个给定的输入是不变的，因此不用计算比例，直接按照GC在其中的数量，返回数量就可以了
    public static int max(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                count++;
            }
        }
        return count;
    }
}
