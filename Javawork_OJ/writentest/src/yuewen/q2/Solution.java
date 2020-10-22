package yuewen.q2;

/**
 * @author hyc
 * @date 2020/10/21
 */
public class Solution {
    /**
     * 计算int对应二进制中1的个数
     * @param n int整型 数字
     * @return int整型
     */
    public int countBit (int n) {
        // write code here
        int count  = 0;
        while (n > 0){
            if ((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
