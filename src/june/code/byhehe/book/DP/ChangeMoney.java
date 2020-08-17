package june.code.byhehe.book.DP;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        chMon11();
    }

    /**
     * input:
     * 11 3
     *
     * 1 2 5
     */
    public static void chMon1(){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();  // 表示 面值
        int N = sc.nextInt();  // 表示 面值数
        int[] coins = new int[N+1];
        for (int i = 1; i <= N; i++) {
            coins[i] = sc.nextInt();
//            System.out.println(coins[i]);
        }

        int[][] dp = new int[N+1][M+1];

        int[] dp2 = new int[M+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int i = 0; i < N+1; i++) {
//            Arrays.fill(dp[i], 111);
//        }
//        dp[1][1] = 1;
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(j>=coins[i]){
                    dp[i][j] =
                            Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1);
                }
                System.out.print(dp[i][j]+" ");
//                if(j >= coins[i]){
//                    dp2[j] = Math.min(dp2[j], dp2[j-coins[i]]+1);
//                }
//                System.out.print(dp2[j]+" ");

            }
            System.out.println();
        }


//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <=M; j++) {
//                System.out.print(dp[i][j]+" ");
//
//            }
//            System.out.println();
//        }
    }
    public static void chMon11(){
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int k = sc.nextInt();
        int [] coins = new int[k+1];
        for (int i = 0; i < k; i++) {
            coins[i] = sc.nextInt();
        }
        int []dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }


        if(dp[amount] > amount){
            System.out.println(-1);
        }else {
            System.out.println(dp[amount]);
        }


    }
}
