package leetcode._20_0920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hyc
 * @date 2020/9/20
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && i != j && j != k && i != k){
                        List<Integer> tempList = new ArrayList<>(3);
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        list.add(tempList);
                    }
                }
            }
        }
        //将每个集合排序,便于去重
        for (List<Integer> item : list){
            item.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i >= list.size()){
                    break;
                }
                if (i != j && same(list.get(i),list.get(j))){
                    list.remove(i);
                }
            }
        }
        return list;
    }

    private boolean same(List<Integer> integers, List<Integer> integers1) {
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) != (integers1.get(i))){
                return false;
            }
        }
        return true;
    }
}

class TestThreeSum{
    public static void main(String[] args) {
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Solution15 tst = new Solution15();
        List<List<Integer>> lists = tst.threeSum(arr);
        for (List<Integer> item : lists){
            System.out.println(Arrays.toString(item.toArray()));
        }
    }
}