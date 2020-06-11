package june.code.byhehe.code;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

/**
 * 思路：
 * 公式：
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
 * G(n) = 累加{1,n} G(i - 1) ￿￿. G(n - i)
 */
public class LeetCode97 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        // 注意 n = 0 时， 此时有一种 所以 返回 G[0] = 1
        G[0] = 1;   // 0 的时候 有 1 种  作为 数字   0
        G[1] = 1;   // 1 的时候 只有 1 种   0 1
        // 开始进行主逻辑
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                G[i] += G[j - 1] * G[i - j];    // 记住 不要忘了累加符号

            }
        }
        return G[n];

    }
}
