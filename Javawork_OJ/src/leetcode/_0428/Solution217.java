package leetcode._0428;
//存在重复元素

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution217 {
    //使用循环判断可以搞定，现在使用set
    public boolean containsDuplicate(int[] nums) {
        //虽然看起来比较笨重，但是经过测试，下面这个代码却是最快的。。。。
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if(nums[i] == nums[i+1]){
//                return true;
//            }
//        }
//        return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                return true;
            }
            //将每一个元素放进set里，重复元素不会被放进去
            set.add(num);

        }
        //如果有重复元素，则set.size一定不等于nums.length
        //如果没有重复元素，则二者长度相等
        return set.size() != nums.length;
        //执行时间7ms，感觉还不如上面呢
    }
}
