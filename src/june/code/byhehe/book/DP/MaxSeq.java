package june.code.byhehe.book.DP;

import java.util.Arrays;

/**
 * DP 问题 之 最长递增子序列
 * input:[10, 9 ,2 ,5,3,7,101,18]
 * output:4
 * 解释： 最长上升子序列是 [2, 3,7,101], 它的长度是 4
 */
public class MaxSeq {
    public int lengthOfLIS(int[] nums){
        // 首先定义 dp 数组
        // dp[i] 表示 0...i 中 最长递增序列长度 为 dp[i]
        int[] dp = new int[nums.length];

        // 初始化为 1  即 每个位置 即使只有它自身 即为 1 至少为 1
        Arrays.fill(dp,1);

        // 对于 其中一个数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 表示 每次从头开始 找到比自己小的递增序列
                if(nums[i] > nums[j]){
                    // 更新dp[i] 的值
                    dp[i] = Math.max(dp[i], dp[j]+1);  // dp[i] 保留有之前的值可能是比他更大的
                }
            }
        }
        // 找出 dp 数组中 最大的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
        // 如果是找序列 只需要 找到 最大的值 然后进行 从这里开始不断向后找 然后
        // 找到 所有序列
    }

}
