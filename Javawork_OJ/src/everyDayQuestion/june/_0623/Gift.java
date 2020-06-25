package everyDayQuestion.june._0623;

/**
 * @author hyc
 * @date 2020/6/25
 */
import java.util.*;

/**
 * 题目描述
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红
 * 包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路
 * 和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 若没有金额超过总数的一半，返回0。
 * 测试样例:
 * [1,2,3,2,2],5
 * 返回: 2
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(gifts[i])){
                map.put(gifts[i],1);
            }else {
                int value = map.get(gifts[i]);
                map.put(gifts[i],value + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(gifts[i]) > n / 2){
                return gifts[i];
            }
        }
        return 0;
    }
}