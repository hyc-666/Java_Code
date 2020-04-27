package leetcode._0427;
//找到字符串中第一个不重复的字符

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        /*List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!list.contains(ch)){
                list.add(ch);
                set.add(ch);
            }else{
            //这里如果直接写成list.remove(s.charAt(i))有可能会把s.charAt(i)解析成一个整数，从而发生下标越界的事故
                list.remove(ch);
            }
        }
        if (list.isEmpty()){
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == list.get(0)){
                return i;
            }
        }
        return -1;*/
        //map统计出每个字符出现的次数
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                int value = map.get(ch);
                map.replace(ch,value + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Solution387 test = new Solution387();
        System.out.println(test.firstUniqChar(s));
    }
}
