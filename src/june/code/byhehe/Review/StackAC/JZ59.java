package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

/**
 * 思路： 层序遍历的变种， 就是每一层遍历的时候 分为 正序遍历和倒叙遍历
 * 使用一个 boolean 和 一个额外额外的容器记录一下 临时保存数据 看是否需要倒序
 */
public class JZ59 {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> PrintByZhi(TreeNode node){
        // 这里采用一个 Boolean 标记
        // 定义一个结果集合 用于保存要返回的结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // 再定义一个 队列 queue , 层序遍历 少不了 queue
        LinkedList<TreeNode> queue = new LinkedList<>();

        // 将根节点添加进 queue
        queue.add(node);

        // 定义标志位 正序还是 倒序
        boolean flag = true;
        while(!queue.isEmpty()){
            // 获取 队列的大小
            int size = queue.size();
            // 定义一个 额外的容器用于保存 看是否需要 倒序的数据
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 接受队列
                TreeNode curNode = queue.poll();

                if(node == null)
                    continue;
                // 这是后需要判断 是正序保存还是倒序保存
                if(flag)
                    list.add(curNode.val);
                else
                    list.add(0, curNode.val);  // 倒序

                queue.add(curNode.left);
                queue.add(curNode.right);

                // 这种写法 不完全正确 如果碰到 空树 根节点都是 null 这时候判断 其左右子节点肯定报错 所以可以直接使用
                // node 判断是否为空 if(node == null) continue;
//                if(node.left!=null)
//                    queue.offer(node.left);
//                if(node.right!=null)
//                    queue.offer(node.right);

            }
            // 结果遍历完了以后 将数据进行 将数据 数据再保存到 返回结果中
            if(list.size()!=0)
                result.add(list);
            flag = !flag;

        }

        return result;
    }
}
