package leetcode;
//将数组分成和相等的三个部分

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum %3 != 0){//如果不能被三等分，则返回false
            return false;
        }
        sum /= 3;
        int avg = 0;
        int count = 0;
        for(int item :A) {
           avg += item;
           if (avg == sum) {
               count++;
               avg = 0;
           }
        }
        return count >= 3;

        //直接找三段吧，这个算法可能有点问题

//        int left = 0;
//        int right = A.length - 1;
//        boolean res = false;
//        int sum_l = 0;
//        int sum_r = 0;
//        while (left < right){
//            //从左向右找三等分
//            if (sum_l != sum /3){
//                sum_l += A[left];
//                left ++;
//            }
//            if (sum_r != sum /3){
//                sum_r += A[right];
//                right --;
//            }
//            if (sum_l == sum / 3 && sum_r == sum / 3){
//                res  = true;
//                break;
//            }

//        }
        //还要检测一下剩余部分是否长度大于0;
//        if (left == 0 || right == A.length){//要判断是否初始定义的结果正好是三分的结果
//            return false;
//        }
//        return res;
    }
}
