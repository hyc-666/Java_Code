package zuiyou.q2;

/**
 * @author hyc
 * @date 2020/9/23
 */
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * func getTriggerTime(increase [][]int, requirements [][]int) []int
     * @param increase int整型二维数组 属性增加值
     * @param requirements int整型二维数组 剧情触发要求
     * @return int整型一维数组
     */
    public int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here
        int[] filed = {0,0,0};
        int[] res = new int[requirements.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < increase.length; i++) {
            for (int j = 0; j < requirements.length; j++) {
                if (filed[0] >= requirements[i][0] && filed[1] >= requirements[i][1] && filed[2] >= requirements[i][2]){
                    res[i] = i;
                }
            }
            filed[0] += increase[i][0];
            filed[1] += increase[i][1];
            filed[2] += increase[i][2];
        }
        return res;
    }
}