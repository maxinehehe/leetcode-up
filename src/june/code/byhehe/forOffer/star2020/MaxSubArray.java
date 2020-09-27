package june.code.byhehe.forOffer.star2020;

import java.util.*;
/*
9
-2 1 -3 4 -1 2 1 -5 4
 */
public class MaxSubArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            Solution s = new Solution();
            int res = s.maxSubArray(nums);
            System.out.println(res);
        }
    }
}
class Solution{
    public int maxSubArray(int[] nums){
        if(nums.length == 0)
            return 0;
        // 记录全局最大和
        int maxSum = nums[0];
        // 创建动态规划数组
        // dp[i] 表示 nums[0...i] 最大的连续子数组的和
        int[] dp = new int[nums.length];
        // 初始化 开始条件
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            // 当前最大子序列和
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            // 不断记录当前的子序列和 是否 比比上一个子序列和更大 最后得到的就是最大的
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}