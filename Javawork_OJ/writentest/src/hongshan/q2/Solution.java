package hongshan.q2;

/**
 * @author hyc
 * @date 2020/10/26
 */
public class Solution {
    String[] strings = {"","A","B","C","D","E","F","G","H","I","J","K","L",
            "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将整数转换成A-Z编号的字符串
     * @param n int整型 大于0的整数
     * @return string字符串
     */
    public String intToAZ (int n) {
        // write code here
        if(n < 26){
            return strings[n];
        }
        StringBuilder stringBuilder = new StringBuilder();
        int t = 0;
        while (n > 0){
            t = n % 26;
            if (t == 0){
                t = t + 1;
            }
            stringBuilder.append(strings[t]);
            n = n / 26;
        }
//        System.out.println(stringBuilder.reverse().toString());
        return stringBuilder.reverse().toString();
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.intToAZ(28));
//    }
}