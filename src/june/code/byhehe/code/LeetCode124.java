package june.code.byhehe.code;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */

import june.code.byhehe.utils.TreeNode;

/**
 * 一个 maxGain 用于获取当前节点的最大贡献值
 * 一个函数 用于遍历当前节点 进行统计 是否有最大值出现
 */
public class LeetCode124 {

    public static void main(String[] args) {

    }
    int max_num = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max_num;
    }
    public int maxGain(TreeNode node){
        if(node == null)
            return 0;
        // 然后 进行获取左右孩子的最大贡献值
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int price_path = node.val + leftGain + rightGain;
        // 然后进行判断  更新最大值 这个是用于全局的
        max_num = Math.max(price_path, max_num);

        // 返回 当前节点的贡献值 叶子节点是 直接自身的值，非叶子节点则是 自身的值 + max(左右孩子的值） ，因为注意题意，根是起点 落点只能是其中一个子节点
        return node.val + Math.max(leftGain , rightGain );
    }
}
