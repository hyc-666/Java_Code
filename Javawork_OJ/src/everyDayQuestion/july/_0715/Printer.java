package everyDayQuestion.july._0715;

/**
 * @author hyc
 * @date 2020/7/15
 */
//说实话算法对于我来说挺难的
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n * n];
        int index = 0;
        int cur = n;
        for (int i = 1; i <= 2 * (n - 1) + 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k - j + 1 == cur){
                        res[index++] = arr[j][k];
                    }
                }
            }
            cur--;
        }

        return res;
    }
}