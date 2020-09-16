package wuba.q2;

/**
 * @author hyc
 * @date 2020/9/14
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}


public class Solution {
    /**
     *
     * @param node TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if ((node == null)){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            ArrayList<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}