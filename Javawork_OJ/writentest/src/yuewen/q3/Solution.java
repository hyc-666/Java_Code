package yuewen.q3;

/**
 * @author hyc
 * @date 2020/10/21
 */
public class Solution {
    /**
     *
     * @param str string字符串
     * @return string字符串
     */
    public String removeDuplicatedChars (String str) {
        // write code here
        char[] arr = str.toCharArray();
        //自己写一个hashmap
        boolean[] exits = new boolean[256];
        for (char ch : arr){
            exits[ch] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : arr){
            if(exits[ch]){
                sb.append(ch);
                exits[ch] = false;
            }
        }
        return sb.toString();
    }
}
class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicatedChars("abcbdde"));
    }
}