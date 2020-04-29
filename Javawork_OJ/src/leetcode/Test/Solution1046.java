package leetcode.Test;
//最后一块石头的重量

import java.util.*;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
       /* //方法一，使用list然后循环做
        List<Integer> list = new ArrayList<>();
        //将所有时头装入list
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        while (list.size() > 1){
            //降序排列
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            if (list.size() <= 1){
                break;
            }
            int y = list.remove(0);
            int x = list.remove(0);
            if(y == x){
            }else {
                list.add(y - x);
            }
        }
        if (list.isEmpty()){
            return 0;
        }
        return list.remove(0);*/
       //方法二，使用优先队列
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while (!queue.isEmpty()){
            if (queue.size() <= 1){
                break;
            }
            int y = queue.poll();
            int x = queue.poll();
            if (y != x){
                queue.offer(y - x);
            }
        }
        if (queue.isEmpty()){
            return 0;
        }
        return queue.poll();

        //经过实测，两种方法在leetcode上的提交记录中时间/空间耗费差不多。。。。
        //不过这个测试有随机性，同样的代码。有时是1ms，有时是2ms，
        //总的来说，方法二还是要优于方法一的
    }
}
