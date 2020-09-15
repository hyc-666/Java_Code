package shengzhou.q1;

import java.util.Arrays;

/**
 * @author hyc
 * @date 2020/9/15
 */
public class Solution1 {
    /**
     *
     * @param inData string字符串 请求参数
     * @return int整型
     */
    public int sort (String inData) {
        // write code here
        String[] strings = inData.split(" ");
        int len = strings.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] != copy[i]){
                sum++;
            }
        }
        return sum;
    }
}