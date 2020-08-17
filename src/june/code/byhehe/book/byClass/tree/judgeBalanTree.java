package june.code.byhehe.book.byClass.tree;

import june.code.byhehe.utils.TreeNode;

/**
 * 判断是不是平衡二叉树
 * 平衡二叉树： 左右子树深度小于 1
 * 一棵树的高度 为 它 最高的 那个孩子的高度
 */
public class judgeBalanTree {
    boolean p = true;
    public boolean isBalanced_Solution(TreeNode root){
        height(root);
        return p;
    }

    // 判断树的深度
    public int height(TreeNode root){
        if(root == null)
            return 0;
        else {
            int rightHeight = height(root.right);
            int leftHeight = height(root.left);
            if(Math.abs(rightHeight - leftHeight)>1){
                p = false;
            }
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

}
