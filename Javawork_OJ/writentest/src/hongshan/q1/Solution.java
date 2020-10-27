package hongshan.q1;

import java.util.Arrays;

/**
 * @author hyc
 * @date 2020/10/26
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将UUID字符串转换成byte数组，并以字符串形式返回
     * @param uuid string字符串
     * @return string字符串
     */
    public String strToBytes (String uuid) {
        // write code here
        String[] strings = uuid.split("-");
        byte[] res = new byte[16];
        int j = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int k = 0; k < strings[i].length(); k += 2) {
                String s1 = strings[i].substring(k,k + 2);
                res[j++] = strToDec(s1);
            }
        }
        return Arrays.toString(res);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.strToBytes("000c29be-6c340000-5a0ec7f6-21ae8e6b"));
//    }
    //将一个2位的字符串转换为10进制
    public byte strToDec(String s){
        byte low = charToInt(s.charAt(1));
        byte high = charToInt(s.charAt(0));
        byte res = (byte) (high * 16 + low);
        return res;
    }
    public byte charToInt(char ch){
        if (ch >= '0' && ch <= '9'){
            return (byte)(ch - 48);
        }
        switch (ch){
            case 'a':
                return 10;
            case 'b':
                return 11;
            case 'c':
                return 12;
            case 'd':
                return 13;
            case 'e':
                return 14;
            case 'f':
                return 15;
        }
        return 0;
    }
}