 package june.code.byhehe.forOffer.netEase;

import java.util.Scanner;

public class Main1 {
    //    public int []dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long []res = new long[sc.nextInt()];
res();

//        int[] dp;
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            int num = sc.nextInt();
//            if(num < 2)
//                continue;
//            dp = new int[num+1];
//            if(dp[num] != 0){
//                sum+=dp[num];
//            }else {
//                sum += splitToOrdNum(num, dp);
//            }
//        }
//        System.out.println(sum);
    }


    public static int res(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] w = new int[n+1];
        int [] s = new int[n+1];
        // 假设 体积都为 1 转变
        for (int i = 0; i < n; i++) {
            w[i] = 1;
            s[i] = sc.nextInt();
        }
        int [] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
//                if(j<w[i]){
//                    dp[j] = dp[j]
//                }
                if(j>=w[i]){
                    dp[j] = Math.max(dp[j-1], dp[j-w[i]] + s[i]);
                }

            }
            /*
            5
            5 15 5 15 5
   40
             */
        }

        System.out.println(dp[n]);

        return 0;
    }



    // 一个数能拆成几个素数
    public static int splitToOrdNum(int num, int []dp){
        // 首先从最小的值拆 保证拆的最多 因为即使拆成大的还得往下拆
        // 这里考虑使用 DP
        /**
         * 分析 对于一个数 可以理解成  比如 7
         * 理解成 w = [2, 3] c = [1,1]  即价值都按 1 计算 计数
         * 画出 Dpt  table
         *
         */
//        int [] dp = new int[num+1];  // 容量
        int [] w = new int[]{0, 2, 3};
//        int [] c = {1,1};
        int c = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 2; j >= 1; j--) {
//                dp[i] = Math.max(dp[j])

                if(i >= w[j])
                    dp[i] = Math.max(dp[i], dp[i-w[j]]+1);

            }
//            for (int j = 0; j < dp.length; j++) {
//                System.out.print(dp[j]+" ");
//            }
//            System.out.println();
        }
//        System.out.println(dp[num]);
        return dp[num];
    }

    // 判断是不是 素数
    public static boolean isOrdNum(int num){
        if(num == 2)
            return true;
        if(num < 2)
            return false;
        int res = num/2;
        for (int i = 2; i < num / 2; i++) {
            if(res % i == 0)
                return false;
        }
        return true;
    }
}
