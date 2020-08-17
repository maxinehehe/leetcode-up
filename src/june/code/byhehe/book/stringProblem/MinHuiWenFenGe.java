package june.code.byhehe.book.stringProblem;

public class MinHuiWenFenGe {
    public static void main(String[] args) {
        System.out.println(getLessSplitNum("ABA"));
    }
    public static int getLessSplitNum(String s){
        if(s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        //
        int[] dp = new int[len+1];
        dp[len] = -1;  // 如果 不设置 ABA 这样的值 会返回 1
        boolean[][] p = new boolean[len][len];

        for (int i = len - 1; i >= 0 ; i--) {
            // 这里做这一步是为了 后面比较最小 因为数组初始化为 0  所以影响比较
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                // chars[i...j] 如何 与 chars[i+1...j-1] 息息相关
                if(chars[i] == chars[j] && (j - i < 2 || p[i+1][j-1])){
                    p[i][j] = true;
                    // 这里判断失误  dp[i] 是判断 str[i..j]的 所以要得到str[j+1...len]
                    // 的结果
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }

        return dp[0];
    }
}
