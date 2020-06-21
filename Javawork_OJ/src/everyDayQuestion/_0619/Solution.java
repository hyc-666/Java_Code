package everyDayQuestion._0619;

/**
 * @author hyc
 * @date 2020/6/20
 */

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义:源二叉树
 *       8
 *      / \
 *     6  10
 *   / \  / \
 *  5  7 9 11
 * 镜像二叉树
 *       8
 *      / \
 *    10   6
 *   / \  / \
 * 11  9 7   5
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public void Mirror(TreeNode root) {
        //记得判空
        if (root == null){
            return;
        }
        //递归镜像
        //先递归镜像左子树，
        //如果左子树不为空就向左递归，之后向右递归
        //最后交换当前树的左右结点
        if (root.left == root.right){
            return;
        }
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
