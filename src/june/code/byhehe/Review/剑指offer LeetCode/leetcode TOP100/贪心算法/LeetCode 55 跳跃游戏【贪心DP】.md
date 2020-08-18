#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

难度中等631

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



## 思路 1 DP 进行剪枝

```
使用动态规划 
定义boolean 数组， dp[i]  表示 对于 在数组 arr[0..i] 可以走到 i 的位置
子问题 dp[i-1] 同样适用。
下面开始寻找 dp[i] 的状态转移方程
对于当前位置的 元素 它是否能够由前面的位置跳转过来， 需要判断 dp[i-1] 的情况以及 判断 可否由 当前位置 i 之前的位置走到自己所在的位置。
所以公式有： dp[i] = dp[i-1] && arr[i-1] >= 1;
采用剪枝的写法， 即前面有任何一个位置能够走到 当前位置 就算找到了路径，可以结束当前位置的判断了。
现在 i 表示当前位置， j 表示 i 之前的位置，那么则有：
dp[i] = dp[i-j] && arr[i-j] >= j; 即表示 看是否能由 i 前面的位置直接走到  i 。

然后还要考虑 初试情况：
	dp[0] = arr[0] == 0? false:true; 
	然后进行判断 如果dp[0] == false 可以直接返回 false;
	

```

## 代码

```java
 // dp  时间复杂度 O(nlog^n)? 空间复杂度 O(n) 
    public boolean useDP(int []arr){
        int length = arr.length;
        if(length == 0) return false;
        if(length == 1) return true; 
        boolean[] dp = new boolean[length];
        // 初始化
        dp[0] = arr[0] == 0? false:true;
        if(dp[0]==false) return false;
   
        for(int i = 1; i < length; i++){
            for(int j = 1; j <= i; j++){ // 现在这个 3ms以内 反过来 则是要 1000多ms  j = 1 即不用再判断自身了
                if(i-j>=0){
                    dp[i] = dp[i - j] &&  arr[i-j] >= j; // 判断 i 前面的 判断能否从前面走到自己这
                    if(dp[i]){  // 有一个能到达的就结束了
                        break;
                    } 
                }
            }
        }
        return dp[length-1];
    }
```

## 思路2 贪心算法

```
贪心的思路 其实是在动态规划的基础上，每次都选择最优的解来解决问题。
下面 来看看他的思想：
首先 遍历 数组， 用一个变量 maxValue 记录 最远可以到达的位置, 判断该位置是否 >= 数组.length - 1,是的话就返回 true。
[2,3,1,1,4]  ->  
	- 我们一开始在位置 0，可以跳跃的最大长度为 2，因此最远可以到达的位置被更新为 2；

	- 我们遍历到位置 11，由于 1 ≤ 2，因此位置 1 可达。我们用 1 加上它可以跳跃的最大长度 3，将最远可以到达的位置更新为 4。由于 4 大于等于最后一个位置 4，因此我们直接返回 True。

if (i <= rightmost) {} 这一步很关键 ， 如果开头 [0,1,2,3]  开头为0， 要保证 maxValue 不会更新
maxValue = Math.max(maxValue, i + nums[i]);  // 这样 初始时 maxValue = 0; 上面就是
maxValue = Math.max(0, 0 + 0);
```

## 代码

```java
 // 使用贪心算法 每次遍历 看最远能到达的位置  时间复杂度 O(n) 空间复杂度 O(1)
    public boolean useGreedy(int[] arr){
        int len = arr.length;
        int maxDist = 0;
        for(int i = 0; i < len; i++){
            if(i <= maxDist){
                maxDist = Math.max(maxDist, i + arr[i]); // 关键一步 进行记录最远能到达的位置
                if(maxDist >= len - 1)
                    return true;
            }
        }
        return false;
    }
```



## 另外 尝试使用 回溯法进行解决， 结果超时，这里不再给出具体相关思路和代码了， 上面两个足够好用。