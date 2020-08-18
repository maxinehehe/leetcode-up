# LeetCode 53

#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

难度简单1746

给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

**示例:**

```
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

**进阶:**

如果你已经实现复杂度为 O(*n*) 的解法，尝试使用更为精妙的分治法求解。

###  第一种 采用 双数组dp 未经优化 会有很多重复计算

> - **不能完全通过，由于双数组会出现内存溢出**
> - **好处是不用考虑那么多，就是暴力法**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return dp2(nums);
    }
 // 双数组
    public int dp2(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        // base
        dp[0][0] = nums[0];
        int max = dp[0][0];
        for(int i = 1; i < n;i++){
            for(int j = 0; j < i; j++){
                dp[j][i] = dp[j][i-1] + nums[i];
                if(dp[j][i]<nums[i]){
                    dp[j][i] = nums[i];
                }
                if(dp[j][i] > max){
                    max = dp[j][i];
                }
            }
        }
        return max;
    }   
}
```

### 第二种 对双数组进行优化 

> - **其实使用一维数组就足够了，因为要求是连续的，即当前数只可能向后找，不会往前看，因此一维数组足够**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return dp2(nums);
    }
	// 使用 一维  DP 数组 优化
    public int dp(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        // base
        dp[0] = nums[0];  
        int maxValue = dp[0];
        for(int i = 1; i < n; i++){
            // 状态转移方程
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            // 记录转移过程中的最大连续值
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}
```

### 第三种 优化过了时间之后

> - **优化过了时间之后，其实还可以优化空间。因为每次计算过之后就不再需要前面的值了，所以没必要还用数组进行保存，用过直接丢掉就好了**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return dp2(nums);
    }
	//优化一维DP 使用一遍循环 搜最大子序列
    public int traverse(int[] nums){
        int n = nums.length;
        int sum =0; // 用于记录累积和
        int max =nums[0];
        for(int i = 0; i < n; i++){
            sum = Math.max(sum+nums[i], nums[i]);
            max = Math.max(sum , max);
        }
        return max;
    }
}
```

