package shengzhou.q1;

import java.util.*;

/**
 * @author hyc
 * @date 2020/9/15
 */
public class Solution {
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
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += countBig(arr,i);
        }
        Map<Integer,Integer> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        list.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        return sum;
    }
    //需要判断每个数后面一共有多少个数比他大
    public static int countBig(int[] arr,int index){
        int count = 0;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] > arr[i]){
                count++;
            }
        }
        return count;
    }
/*    //看每个数后面有几个比他小的
    public static int countSmall(int[] arr,int index){
        int count = 0;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] < arr[i]){
                count++;
            }
        }
        return count;
    }*/
}
