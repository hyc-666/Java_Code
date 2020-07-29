package everyDayQuestion.july._0725;

/**
 * @author hyc
 * @date 2020/7/26
 */

/**
 * 题目描述
 * 给定一个长度为N(N> 1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K], 右
 * 部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大
 * 值减去右部分最大值的绝对值，最大是多少?
 * 给定整数数组A和数组的大小n,请返回题目所求的答案。
 * 测试样例:
 * [2, 7,3,1,1],5
 * 返回: 6
 */
public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int temp = calMax(A,i);
            if (res < temp){
                res = temp;
            }
        }
        return res;
    }

    public static int calMax(int[] arr,int split){
        int maxL = arr[0];
        int maxR = arr[arr.length - 1];
        for (int i = 0; i <= split; i++) {
            if (arr[i] > maxL){
                maxL = arr[i];
            }
        }
        for (int i = split + 1; i < arr.length; i++) {
            if (arr[i] > maxR){
                maxR = arr[i];
            }
        }
        return Math.abs(maxL - maxR);
    }
}