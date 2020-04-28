package leetcode._0428;
//最常见的单词

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 *  
 *
 * 示例：
 *
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *  
 *
 * 提示：
 *
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-common-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        //把段落里的字母都转换成小写
        int len = paragraph.length();
        char[] str = paragraph.toCharArray();
        for (int i = 0; i < len; i++) {
            if (str[i] >= 'A' && str[i] <= 'Z'){
                str[i] = Character.toLowerCase(str[i]);
            }
        }
        //统计出段落中每个单词的出现次数
        Map<String,Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str[i] >= 'a' && str[i] <= 'z'){
                stringBuilder.append(str[i]);
            }else{
                String string = stringBuilder.toString();
                if (string.length() < 1){
                    continue;
                }
                if (!map.containsKey(string)){
                    map.put(string,1);
                }else {
                    int value = map.get(string);
                    map.put(string,value + 1);
                }
                stringBuilder = new StringBuilder();
            }
        }
        //要判断最后一个字符是不是字母，如果不是则已经放完全部单词，如果是
        //把最后一个单词也要放进去
        if (str[len - 1] >= 'a' && str[len - 1] <= 'z'){
            String last = stringBuilder.toString();
            if (!map.containsKey(last)){
                map.put(last,1);
            }else{
                int count = map.get(last);
                map.put(last,count + 1);
            }
        }

        //然后筛选禁用单词
        for (String string : banned){
            if (map.containsKey(string)){
                map.remove(string);
            }
        }
        //将出现次数摘出来
        int[] counts = new int[map.size()];
        int i = 0;
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            counts[i++] = entry.getValue();
        }
        int max = 0;
        //找最大的（出现次数最多的单词）
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] > max){
                max = counts[j];
            }
        }
        //再根据value查找到单词
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() >= max){
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution819 test = new Solution819();
        String str = "Bob. hIt, baLl";
        String[] ban ={"bob","hit"};
        System.out.println(test.mostCommonWord(str,ban));
    }
}
