package leetcode;

import java.util.LinkedList;

/**
 *
 给定一个二叉树，确定它是否是一个完全二叉树。

 百度百科中对完全二叉树的定义如下：

 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 来源：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution958 {
    //二叉树的层序遍历，创建一个队列，将根节点加入队列
    //如果根节点不为空，则将左子树和右子树加入队列
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur;
        queue.addLast(root);
        while ((cur = queue.removeFirst()) != null){//根节点出队并判断根节点是否空，一边遍历一边检查
            queue.addLast(cur.left);//这里其实只是检查父节点是否为空，如果父节点不为空，则将其两个子节点入队
            queue.addLast(cur.right);//而空结点也会被入队
        }
        while (!queue.isEmpty()){
            if(queue.removeLast() != null){
                //这个时候队尾结点是层序遍历的最后一个结点，也是右子节点
                //如果右子节点不为空则说明右右子树，则不是完全二叉树
                return false;
            }
        }
        return true;
    }
}
