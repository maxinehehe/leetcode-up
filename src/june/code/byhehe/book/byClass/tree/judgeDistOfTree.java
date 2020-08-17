package june.code.byhehe.book.byClass.tree;

import june.code.byhehe.utils.TreeNode;

/**
 * 求树的距离
 * 和属地深度是啊不多， 最大距离 就是某个节点 左子树深度 + 右子树深度
 * 遍历过程纪录最大值即可
 */
public class judgeDistOfTree {

    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        return max;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        // 判断最大值
        max = Math.max(max, left+right);

        return 1 + Math.max(left, right);
    }
}
