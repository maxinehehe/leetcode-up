package june.code.byhehe.book.byClass.tree;

import june.code.byhehe.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 根据 先根 和 中根 遍历 构建二叉树
 * Arrays.copyOfRange(nums, from, to);  表示 拷贝 nums 数组内容， 从 from 位置拷贝到 to位置
 * 注意 包左不包右
 */
public class buildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0||inorder.length==0)
            return null;
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]){
                // 找到根节点 开始构建   prordeer[0] 以及用过
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder,0,i));
                // inorder 要用 i+1 , 因为 i 处是 root
                node.right = buildTree(Arrays.copyOfRange(preorder, i+1,preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
            }

        }
        return node;
    }
}
