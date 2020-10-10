package leetcode._1010;

/**
 *
 * @author hyc
 * @date 2020/10/10
 */
class Solution53 {
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int sum = 0;
        for (int num : nums){
           if (sum > 0){
               sum += num;
           }else {
               sum = num;
           }
           ret = Math.max(ret,sum);
        }
        return ret;
    }
}
