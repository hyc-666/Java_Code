package everyDayQuestion.june._0626;


/**
 * @author hyc
 * @date 2020/6/27
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here
        if (leftHeight(root) - rightHeight(root) > 1){
            return false;
        }
        if (rightHeight(root) - leftHeight(root) > 1){
            return false;
        }
        return true;
    }
    //计算以当前结点位根节点的树的高度
    public static int height(TreeNode root){
        return Math.max(root.left == null ? 0 : height(root.left),root.right == null ? 0 : height(root.right)) + 1;
    }
    //分别计算左右子树的高度
    public static int leftHeight(TreeNode root){
        if (root.left == null){
            return 0;
        }
        return height(root.left);
    }
    public static int rightHeight(TreeNode root){
        if (root.right == null){
            return 0;
        }
        return height(root.right);
    }
}