package wuba.q3;

import java.util.Arrays;

/**
 * @author hyc
 * @date 2020/9/14
 */
public class Solution {
    /**
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int firstMissingPositive (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        while (left < right){
            if (nums[left] == left + 1){
                left++;
            }else if(nums[left] <= 1 || nums[left] > right || nums[nums[left] - 1] == nums[left]){
                nums[left] = nums[--right];
            }else {
                change(nums,left,nums[left] - 1);
            }
        }
        return left + 1;
    }
    public static void change(int[] arr,int i,int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}