package everyDayQuestion._0601;

/**
 * @author hyc
 * @date 2020/6/1
 */
import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int len = a.length;
        Arrays.sort(a);
        if (K >= n){
            return a[0];
        }
        if (K <= 0){
            return a[len - 1];
        }
        return a[len - K];
    }
}