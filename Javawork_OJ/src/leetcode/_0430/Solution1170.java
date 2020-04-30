package leetcode._0430;
//比较字符串最小字母出现频次

import java.util.HashMap;
import java.util.Map;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 *提示：
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1170 {
    //说实话，这个题读懂题目都费了我好大劲，不过代码提交一次过
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len = queries.length;
        int[] word = new int[words.length];
        //统计words中每个最小字符的出现频次
        for (int i = 0; i < words.length; i++) {
            word[i] = getCount(words[i]);
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
           int count1 = getCount(queries[i]);
           int count = 0;
            for (int j = 0; j < word.length; j++) {
                if (count1 < word[j]){
                    count++;
                }
            }
            res[i] = count;
            //获得字母序最小的字符并得到出现频次
        }
        return res;
    }
    //写一个辅助方法用来统计每个字符串中最小字母的出现频次
    private int getCount(String s){
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        char minChar = 'z';
        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                int value = map.get(ch);
                map.put(ch,value + 1);
            }
            if (ch < minChar){
                minChar = ch;
            }
        }
        return map.get(minChar);
    }
}
