# leetcode 55 跳跃游戏

#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

难度中等615

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

**示例 1:**

```
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
```

**示例 2:**

```
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```



## 思路

```
使用动态规划解决：
dp[i]  表示 从 0...i 能够来到 dp[i]
1.   公式：dp[i] = dp[i-j] && arr[i-j] >= j  
	: 表示 dp[i] 等于 true还是false, 要看dp[i-j] 和 arr[i-j]是否可以跳跃到 arr[i]。
	即 当前 dp[i] 往前找 只要能找到 能来到 i 位置 且器dp[i]为true, 那么dp[i] = true;
2.  初始条件：
	dp[0] = arr[0] == 0? false:true;
```



## 代码

```java
class Solution {
    public boolean canJump(int[] nums) {
        return useDP(nums);

    }

    // dp
    public boolean useDP(int []arr){
        int length = arr.length;
        if(length == 0) return false;
        if(length == 1) return true; 
        boolean[] dp = new boolean[length];
        // 初始化
        dp[0] = arr[0] == 0? false:true;
        if(dp[0]==false) return false;
        
        for(int i = 1; i < length; i++){
            for(int j = 0; j <= i; j++){
                if(i-j>=0){
                    dp[i] = dp[i - j] && arr[i-j] >= j;
                    if(dp[i]){
                        break;
                    } 
                }
            }
        }
        return dp[length-1];
    }

    // 先尝试回溯法计算一次  这里回溯法 超时 后续可考虑进行优化
    public boolean backTracking(int[] arr, int curIdx){
        if(curIdx == arr.length - 1 || arr.length == 1){
            return true;
        }
        if(curIdx > arr.length || arr.length > 1 && arr[curIdx] == 0 ){
            return false;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            // 开始回溯
            for(int j = arr[i]; j >= 0; j --){
                backTracking(arr, i+j);
            }
        }

        return false;
    }
}
```

