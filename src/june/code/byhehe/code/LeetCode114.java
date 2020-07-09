package june.code.byhehe.code;

import june.code.byhehe.utils.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

/**
 * 解题思路：
 *    2
 *   / \
 *  3  4
 *  假设当前节点为 node ， 将当前节点 的左孩子 变成右孩子，原来的右孩子则变为 原做孩子的右孩子
 *
 */
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(1);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        flatten2(root);
        while (root!=null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten2(TreeNode root){
        while (root != null){
            if(root.left == null)
                root = root.right;  // 直接下一个
            else {
                // 找到其左子树最右的节点
                TreeNode pre = root.left;
                while (pre.right != null)
                    pre = pre.right;
                // 将右子树街道这个节点上
                pre.right = root.right;
                // 再将左子树 接到  右子树上
                root.right = root.left;
                root.left = null;

                // 继续下一个  往右走
                root = root.right;

            }
        }
    }
    public static TreeNode pre = null;
    public static void flatten(TreeNode root) {
        TreeNode tmp;
        if(root == null)
            return ;
        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;
        pre = root;
    }

}
