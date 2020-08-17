package june.code.byhehe.book.DP;

import java.util.Scanner;

public class ZeroOneBag {
    public static void main(String[] args) {
        System.out.println("zo:");
        zo();
    }

    public static void zo(){
        int m,n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[] dp = new int[m+1];
        int[] w = new int[n+1];
        int[] c = new int[n+1];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        // 0/1 背包
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1 ; j++) {
                if(j>=w[i]){
                    dp[j] = Math.max(dp[j], dp[j-w[i]] + c[i]);
                }

            }

        }

        System.out.println("结果： "+ dp[m]);
    }
}
