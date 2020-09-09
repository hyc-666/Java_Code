package leetcode._200909;

/**
 * @author hyc
 * @date 2020/9/9
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        //这个题目用异或运算比较快速简便
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}
