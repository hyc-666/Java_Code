package yuewen.q1;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

/**
 * @author hyc
 * @date 2020/10/21
 */
public class Solution {
    /**
     *
     * @param root TreeNode类
     * @param p TreeNode类
     * @param q TreeNode类
     * @return TreeNode类
     */
    public TreeNode nearestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        // write code here
        if (root == null || p == null || q == null){
            return root;
        }
        TreeNode left = nearestCommonAncestor(root.left,p,q);
        TreeNode right = nearestCommonAncestor(root.right,p,q);
        if (left == null){
            return right;
        }else if(right == null){
            return left;
        }
        return root;
    }
}
