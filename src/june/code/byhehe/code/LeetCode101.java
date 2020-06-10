package june.code.byhehe.code; /**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import june.code.byhehe.utils.TreeNode;

/**
 * 思路：
 * 判断一棵树是不是镜像 先看它的左右节点是否相等
 * 重新整理：
 * 既然判断是否为镜像 不妨当成两棵树 进行比较
 *     1       |        1
 *    / \      |      /  |
 *   2   2     |     2    2
 *  / \ / \    |    / \  / \
 * 3  4 4  3   |   3  4 4  3
 * 就像上面 直接进行 对比  用两棵树直接进行对比 要比一棵树 好操作
 */
public class LeetCode101 {
    public static void main(String[] args) {
        // 测试
    }
    public static class Solution{
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);

        }

        public boolean check(TreeNode root1, TreeNode root2){
            if(root1 == null && root2 == null)
                return true;
            if(root1 == null || root2 == null)
                return false;

            return root1.val == root2.val && check(root1.right, root2.left)
                    && check(root1.left, root2.right);
        }
    }

}
