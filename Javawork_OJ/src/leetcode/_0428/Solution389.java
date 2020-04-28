package leetcode._0428;
//找不同

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
//        List<Character> lists = new ArrayList<>();
        List<Character> listt = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character ch = s.charAt(i);
//            lists.add(ch);
//        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            listt.add(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            listt.remove(ch);
        }
        return listt.remove(0);
    }
}
