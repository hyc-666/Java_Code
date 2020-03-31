package leetcode;
//股票的跨度

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class StockSpanner {
    List<Integer> list;
    int size = 0;
    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        size ++;
        list.add(0,price);
        int ret = 1;
        for (int i = 1; i < size; i++) {
            if (price >= list.get(i)){
                ret ++;
            }else {
                break;
            }
        }
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */