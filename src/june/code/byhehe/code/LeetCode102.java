package june.code.byhehe.code;


import june.code.byhehe.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

/**
 * 层序遍历 多会用到一个队列，这里由于要分层 所以可以考虑 队列里面放一个 列表
 *
 * 一种更加巧妙的做法是：
 * 我们可以用一种巧妙的方法修改 BFS：
 *
 * 首先根元素入队
 * 当队列不为空的时候
 * 求当前队列的长度 s_i
 * 依次从队列中取 s_i 个元素进行拓展，然后进入下一次迭代
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        r1.left = n1;
        r1.right = n2;
        System.out.println(levelOrder2(r1));
    }

    public static List<List<Integer>> levelOrder2(TreeNode root){
        // 层序遍历
        List<List<Integer>> resList = new LinkedList<>();
        if(root == null)
            return resList;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left!=null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            resList.add(list);

        }
        return resList;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        // 层序遍历 多用队列
        List<List<Integer>> resList = new LinkedList<>();
        if(root == null)
            return resList;

        Queue<List<TreeNode>> queue = new LinkedList<>();

//        new LinkedList<>().add(root.val);
//        queue.add(new LinkedList<>().add);
        queue.add(new LinkedList<TreeNode>(){{
            add(root);
        }});

        while(!queue.isEmpty()){
            // 出队列进行判断
            List<TreeNode> list = queue.poll();
            // 接收元素
            List<Integer> list2 = new LinkedList<>();
            List<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node:list){
                list2.add(node.val);
                if(node.left != null)
                    tmp.add(node.left);
                if(node.right != null)
                    tmp.add(node.right);
            }
            if(tmp.size()>0)
                queue.add(tmp);
            resList.add(list2);
        }
        return resList;
    }
}
