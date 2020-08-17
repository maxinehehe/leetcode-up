package june.code.byhehe.book.DP;

/**
 * 编辑距离 代码 这是较简单版本的
 * 复杂版本的 编辑的代价是不一样的
 * 只需要更改 这一部分代码：
 * 比如 删除代价是 x, 插入代价是 y, 替换代价是 z
 * 则有：
 * 此外还有初始化部分的代码
 * for (int i = 0; i <= n1; i++) {
 *      表示 把s1[0...i] 编辑成 空串的代价 这是 删除代价
 *             dp[i][0] = x * i;
 *         }
 *      表示把s1空串编辑成s2[0...j]的代价 那是插入的代价
 *         for (int j = 0; j <= n2 ; j++) {
 *             dp[0][j] = y * j;
 *         }
 * 计算代价部分
 * dp[i][j] = threeMin(
 *                             dp[i-1][j] + x, //  i 动了 j 没动 s1 在这个位置到 s2 做删除操作
 *                             dp[i][j-1] + y, // 做插入操作
 *                             dp[i-1][j-1] + z // 做替换操作 比如 d 换成 q
 *                     );
 *
 *
 *
 */
public class EditDistance {

    public int minDist(String s1, String s2){
        int n1 = s1.length(), n2 = s2.length();
        if(s1 == null || s2 == null){
            return 0;
        }
        // 定义一个 dp table 用于保存计算的值 其中  dp[i][j] 表示 由 0...i 的字符串
        // 变换到 0...j 的字符串 需要的操作数 为 dp[i][j]
        // dp[i-1][j-1]
        // 存储 s1[0..i] 和 s2[0..j] 的最小编辑距离”

        int[][] dp = new int[n1+1][n2+1];
        // 先初始化 dp[i][0] = i, dp[0][j] = j
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2 ; j++) {
            dp[0][j] = j;
        }
        // 注意 0 位置里面 保存着 0 "" 空 所以从 1 开始
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // skip
                }
                else {
                    // 记住这里是看的操作数 即这个变化的代价 操作数 每次操作都要进行记录操作数 +1 即表示操作数
                    dp[i][j] = threeMin(
                            dp[i-1][j] + 1, //  i 动了 j 没动 s1 在这个位置到 s2 做删除操作
                            dp[i][j-1] + 1, // 做插入操作
                            dp[i-1][j-1] + 1 // 做替换操作 比如 d 换成 q
                    );
                }
            }
        }

        return dp[n1][n2];
    }

    public int threeMin(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}
