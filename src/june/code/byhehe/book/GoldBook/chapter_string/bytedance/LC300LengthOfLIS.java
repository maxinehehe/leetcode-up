package june.code.byhehe.book.GoldBook.chapter_string.bytedance;

import java.util.Arrays;

public class LC300LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        LC300 lc300 = new LC300();
        System.out.println(lc300.lengthOfLIS(nums));
    }
}

class LC300{
    public int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
//        dp[0] = 1;
        int maxRes = 1;
        // 像 4,10,4,3,8,9 一个循环跑不出来  4 10 4 对应的 dp 结果 就是 1 2 2（应该是1）
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                // nums[i] 向前看  更新dp[i] 的值
                if(nums[i] > nums[j]) // 跳过 10
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            // 标记最大值
            maxRes = Math.max(maxRes, dp[i]);
//            System.out.println(nums[i]+" - "+dp[i]);
        }
        return maxRes;
    }
}
