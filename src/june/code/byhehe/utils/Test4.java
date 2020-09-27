package june.code.byhehe.utils;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<1){
            // 异常结果需要进行处理
            return ;
        }
        // 接受数组
        int[][] arr = new int[n][];
        // 创建dp数组
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i-1] = new int[2*i - 1];
            // 便利同时对 dp数组进行初始化
            dp[i-1] = new int[2*i-1];
            for (int j = 0; j < 2 * i - 1; j++) {
                arr[i-1][j] = sc.nextInt();
            }
        }

        int lastRes = getRes(arr, dp, n);
        System.out.println(lastRes);

    }

    public static int getRes(int[][] arr, int[][] dp, int n){
        // 最大的结果值
        int maxRes = 0;
        // 解决逻辑 类似机器人的路径问题 比较一下 从左下方 正下方 和 右下方哪个是最大的即可
        dp[0][0] = arr[0][0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // 从左下角处理开始
                dp[i+1][j] = Math.max(dp[i+1][j], arr[i+1][j]+dp[i][j]);

                // 然后是正下方
                if(j+1<arr[i+1].length){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], arr[i+1][j+1]+dp[i][j]);
                }
                // 右下方进行尝试
                if(j+2 < arr[i+1].length){
                    dp[i+1][j+2] = Math.max(dp[i+1][j+2], arr[i+1][j+2]+dp[i][j]);
                }
            }
        }



        for (int i = 0; i < arr[n - 1].length; i++)
            maxRes = Math.max(maxRes, dp[n-1][i]);


        return maxRes;
    }

}
