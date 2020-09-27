package june.code.byhehe.book.GoldBook.chapter_string.bytedance;


import june.code.byhehe.utils.BuildTree;
import june.code.byhehe.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103ZigZagPrint {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] lastOrder = {9,15,7,20,3};
        BuildTree bt = new BuildTree();
        TreeNode root = bt.build(inorder, lastOrder);
        bt.dfs(root);

        LC103 lc103 = new LC103();
        System.out.println(lc103.zigzagLevelOrder(root));
    }
}

class  LC103{
    /*
    使用 队列保存每层的数据
    使用 list 保留每层出来的数据 然后 存储
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;  // 用于控制方向
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 可以根据 size 知道不为空
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(flag)
                    list.add(node.val);
                else
                    list.add(0, node.val);
            }
            if(list.size()!=0){
                res.add(list);
                flag = !flag;
            }
        }
        return res;
    }

//    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
//
//    }
}


