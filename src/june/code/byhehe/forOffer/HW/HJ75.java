package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(lianxuLCS(s1, s2));
        }
    }
    public static int lianxuLCS(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 0;
//        }
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }else {
                    dp[i][j] = 0;   // 注意找的是连续的 从 斜线下来
                }
            }

        }
        return maxLen;
    }
}
