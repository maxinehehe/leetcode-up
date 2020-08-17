package june.code.byhehe.book.byClass.tree;

import june.code.byhehe.utils.TreeNode;

/**
 * 求一颗树的深度
 */
public class getDepthOfTree {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
