package everyDayQuestion.july._0723;

/**
 * @author hyc
 * @date 2020/7/25
 */

import java.util.HashMap;
import java.util.Map;

/**
 * ■题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长
 * 度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length < 1){
            return 0;
        }
        //哈希表还是好用的
        Map<Integer,Integer> map = new HashMap<>();
        int len = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                int count = map.get(num);
                map.put(num,count + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.get(num) > len){
                return num;
            }
        }
        return 0;
    }
}