package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
//            System.out.println("n: "+n+" m: "+m);
            System.out.println(getMethods(n+1, m+1));
        }
    }

    public static int getMethods(int n, int m){
        // 使用递归
        int[][] dp = new int[n][m];
        // dp[i][j]  表示 从 i 和 j 之间 有多少种方法
        // 先初始化 dp[0][j] 和 dp[i][0]
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        /**
         * 公式： dp[i][j] = dp[i-1][j] + dp[i][j-1]
         */
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
            
        }
        return dp[n-1][m-1];
    }
}
