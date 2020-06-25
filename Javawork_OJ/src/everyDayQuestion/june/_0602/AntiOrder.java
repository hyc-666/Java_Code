package everyDayQuestion.june._0602;

/**
 * @author hyc
 * @date 2020/6/3
 */
public class AntiOrder {
    public int count(int[] A, int n) {
        // write code here
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}