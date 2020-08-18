# leetcode 416 DP值 0-1背包问题

#### [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)

难度中等215

给定一个**只包含正整数**的**非空**数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

**注意:**

1. 每个数组中的元素不会超过 100
2. 数组的大小不会超过 200

**示例 1:**

```
输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
```

 

**示例 2:**

```
输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
```

## 思考

```
0-1背包问题是 选与不选的问题，
1.dp[i][j] : 表示 从 nums[0...i]中选取若干个物品（数）， 使得这些数的加和结果为 j.
这里 dp[i][j] = true;
2.公式： 放与不放的问题
	A. 不放 当前物品 dp[i][j] = dp[i-1][j]  即 nums 中 0...i-1 中已经找出若干个数结果为 j 了（true);
	B. 放当前物品 dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]
	注意： 这里 加上 || dp[i-1][j] 是指 当 前数 nums[i] < j; 选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
	因为 有可能 dp[i-1][j-nums[i]]不满足结果。所以也可能 在 nums[i] < j 的情况下 不选择当前nums[i].
	C.还有一种情况就是 当前nums[i]正好等于 j, 即 正好放下
	if(nums[i] == j)
		dp[i][j] = true;    // i 之前的物品都没放进去
3.初始化状态
考虑 为 0 即i = 0 j = 0的问题
首先dp[0][nums[0]] = true;  第 1 个物品放进去， 和（数量）肯定是他自己。
dp[i][0] = false;
```

## 代码

```java
public class Solution {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

