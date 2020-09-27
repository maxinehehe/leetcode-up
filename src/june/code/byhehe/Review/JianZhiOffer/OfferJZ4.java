package june.code.byhehe.Review.JianZhiOffer;

import june.code.byhehe.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class OfferJZ4 {
}

class JZ4{
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        // 递归重建 先找到 前序遍历的 第一个阶段吗然后在找到中序遍历对应的位置
        if(pre.length == 0 || in.length == 0)
            return new TreeNode();
        int key = pre[0];
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        for (i = 0; i < in.length; i++) {
            // 找到 in 中key位置
            if(in[i] == key)
                break;
        }
//        Arrays.copyOfRange();  包左不包右
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
        return root;
    }
}
