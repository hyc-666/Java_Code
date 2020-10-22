package yuewen.q4;

/**
 * @author hyc
 * @date 2020/10/21
 */
public class Solution {
    /**
     *
     * @param str string字符串
     * @return int整型
     */
    public int palindromeCount (String str) {
        // write code here
        if (str == null || str.length() < 1){
            return 0;
        }
        int count = 0;//单个字符串可以作为回文串
        //依次验证
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length() && j > i; j++) {
                String s = str.substring(i,j);
                if (isPlain(s)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isPlain(String s){//判断是否回文串
        if (s.length() == 1){
            return true;
        }
        int i = 0,j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.palindromeCount("abcb"));
    }
}
