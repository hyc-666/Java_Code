package everyDayQuestion.june._0612;

/**
 * @author hyc
 * @date 2020/6/12
 */
/**
 * m题目描述
 * 给定一个数组A101...n-1]请构建一个数组B[0,1... ,n-1],其中B中的元素
 * B[j]=A[0]1[...*-li-1-][+1[*1...*[n-1]。不能使用除法。
 */
public class Solution {
    //有时候，我真的以为我读懂题目了
    public int[] multiply(int[] A) {
        if (A == null || A.length < 1){
            return null;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = bi(i,A);
        }
        return B;
    }
    public static int bi(int i,int[] A){
        int ret = A[0];
        for (int j = 1; j < A.length && i != j; j++) {
            ret = ret * A[j];
        }
        return ret;
    }
}