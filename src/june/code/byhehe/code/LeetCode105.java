package june.code.byhehe.code;

import june.code.byhehe.utils.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

public class LeetCode105 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        r1.left = n1;
        r1.right = n2;

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]){
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(preorder,i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
            }
        }
        return node;
    }

    public static TreeNode helper(int[] preorder, int pr, int pl, int[] inorder, int ir, int il){
        TreeNode node = new TreeNode();
        int root = preorder[pr];
        node.val = root;

        int i;
        for (i = ir; i < il; i++) {
            if(inorder[i] == root)
                break;
        }

        node.left = helper(preorder, pr, pr+i, inorder, ir, i);
        node.right = helper(preorder,pr+i, pl, inorder, i, il);

        return node;



    }

}
