package june.code.byhehe.code;

import june.code.byhehe.utils.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

/**
 * 排除所有错误的思路就是正确的答案了
 * 1. 判断当前节点   它是自己左子树的范围上限， 是其右子树的范围下限。
 */
public class LeetCode98 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        r1.left = n1;
        r1.right = n2;
        System.out.println(isValidBST(r1));


    }
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);

    }

    public static boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null)
            return true;

        // 判断不是的情况
        if(lower != null && lower >= node.val)
            return false;
        if(upper != null && upper <= node.val)
            return false;
        // 别忘了 还要去判断子树的情况
        int val = node.val;
        if(!helper(node.left, lower, val)) return false;
        if(!helper(node.right, val, upper)) return false;

        return true;  // 排除所有错误的情况就是正确的情况
    }

}
