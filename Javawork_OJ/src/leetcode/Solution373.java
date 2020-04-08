package leetcode;

import javax.security.auth.kerberos.KerberosTicket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Pairs implements Comparable<Pairs>{
    int num1;
    int num2;
    int sum;
    public Pairs(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        sum = num1 + num2;
    }

    @Override
    public int compareTo(Pairs o) {
        return this.sum - o.sum;
    }
}
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //为了最后的结果表示方便，直接在外部定义一个Pair的数对.
        //定义优先队列,不过我觉得List照样能解决，都已经实现Comparable接口了，之后排个序就ok
        //但是，要用堆的思路来解。。伤脑经
        //算了，先用List试试，
        List<Pairs> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                list.add(new Pairs(nums1[i],nums2[j]));
            }
        }
        //然后将list排序
        list.sort(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.sum - o2.sum;
            }
        });
        //取出前k小的元素
        List<List<Integer>> result = new ArrayList<>();
        //对k检验
        if (k < 0){
            return null;
        }
        if (k > list.size()){
            //所有数对都符合要求
            for (int i = 0; i < list.size(); i++) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(list.get(i).num1);
                tempList.add(list.get(i).num2);
                result.add(tempList);
            }
            return result;
        }
        for (int i = 0; i < k; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(list.get(i).num1);
            tempList.add(list.get(i).num2);
            result.add(tempList);
        }
        return result;
    }
}
