# leetcode 1143 最长公共子序列

#### [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)

难度中等77

给定两个字符串 `text1` 和 `text2`，返回这两个字符串的最长公共子序列。

一个字符串的 *子序列* 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

**示例 1:**

```
输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
```

**示例 2:**

```
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
```

**示例 3:**

```
输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。
```

 

**提示:**

- `1 <= text1.length <= 1000`
- `1 <= text2.length <= 1000`
- 输入的字符串只含有小写英文字符。

# 思路

```
1.解释dp[i][j]的含义 根据我们要求什么
	dp[i][j] 表示  s1[0...i] 与 s2[0...j] 两个（子）字符串的最长公共子序列
2.确定 dp[i][j] 的公式 即 dp[i][j]的另一种形式 它是咋转移来的，一般与它挨边的有关。 一般是关注 dp[i-1][j-1], dp[i-1][j], dp[i][j-1].
	A. 当 Si == Sj的时候 ， dp[i][j] = dp[i-1][j-1] + 1; 注意这时候在等式右边不要掺入，这里dp[i][j] 是未知的 需要由他前面的得到。
	这里为什么不用 Math.max(dp[i][j-1], dp[i-1][j]) + 1
	因为 如果按上面那样用的话 就是默认 Si == Sj .
	B. 当 Si != Sj 的时候 这时候就看 
		dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
		// dp[i][j-1] 和 dp[i-1][j] 都已经包含了 dp[i-1][j-1]
3.确定初始状态 base 
注意 从 i = 1,j=1开始计算，所以可以使用 new int[n1+1][n2+1]长度。

```

# 代码

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int [][]dp = new int[n1+1][n2+1];
        //int maxLast = 0;
        for(int i = 1; i <= n1; i++){
            //int max = 0;
            for(int j = 1; j <= n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                }
                else{
                   //  dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                   // 使用上面的公式也可以 只不过重复计算了 因为dp[i][j-1] 和 dp[i-1][j] 都已经包含了 dp[i-1][j-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
           
        }
        return dp[n1][n2];
    }
}
```

