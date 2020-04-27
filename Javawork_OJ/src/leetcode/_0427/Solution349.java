package leetcode._0427;
//两个数组的交集

import java.util.*;
import java.util.function.Consumer;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1){
            list1.add(num);
        }
        Set<Integer> list2 = new HashSet<>();
        for (int num : nums2){
            if (list1.contains(num)){
                list2.add(num);
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        Iterator<Integer> iterator = list2.iterator();
        while (iterator.hasNext()){
            res[i++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution349 test = new Solution349();
        int[] res = test.intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
