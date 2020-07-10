package everyDayQuestion.july._0710;

/**
 * @author hyc
 * @date 2020/7/10
 */

/**
 * ■题目描述
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓错过等七年”。给你一个回顾历史
 * 的机会，已知-支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第1个
 * 元素(prices[i]) 代表该股票第i天的股价。假设你- 开始没有股票,但有至多两次买
 * 入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会
 * 都放弃，收益为0。设计算法，计算你能获得的最大收益。输入 数值范围:
 * 2<=n<=100,0<=prices[i]<=100
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 3,8,5,1, 7,8
 * 输出
 * 复制
 * 12
 */
public class Solution {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        //这个实例中，股价为1的时候买入两股，8的时候卖出则收益为2*8-2=14，
        //但是实例中确是12，也就是说，示例中，是3的时候买入一股8的时候卖出一股，
        //再1的时候买入一股而后8 的时候卖出一股，收益是 8-3+8-1=5+7=12
        //那么规则就是每次买入和卖出只能一股
        //虽然题目基本是读懂了，但是我还是不会算
        return maxPrice(prices);
    }

    public static int maxPrice(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k; l < arr.length; l++) {
                        int temp = arr[l] - arr[k] + arr[j] - arr[i];
                        if (temp > max){
                            max = temp;
                        }
                    }
                }
            }
        }
        return max;
    }
}