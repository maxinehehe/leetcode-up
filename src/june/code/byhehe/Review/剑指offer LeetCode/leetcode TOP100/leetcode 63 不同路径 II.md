# 不同路径 II

#### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

难度中等245

一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

网格中的障碍物和空位置分别用 `1` 和 `0` 来表示。

**说明：***m* 和 *n* 的值均不超过 100。

**示例 1:**

```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

## 思路

```
这里需要比不带障碍物要多些考虑，
1. 行走的时候 要判断 obstacleGrid[i][j](存储输入的数组)是否存在障碍物，即是否为 1。
   然后 在判断 ：
   obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]!=1
   都成立 才能进行从上和从左过来：
   dp[i][j] = dp[i-1][j] + dp[i][j-1];
2. 初始化 的时候 如果碰到 == 1（即有障碍物的情况，那么就不用再往后初始化了，因为后面的路走不通了）
for(int i = 0; i < col;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 2;
        }
        for(int j = 0; j < row; j++){
            if(obstacleGrid[j][0] == 1){
                break;
            }
            dp[j][0] = 2;
        }
```



## 代码

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return (int)useDP(obstacleGrid);
        // 使用 int 注意超大数的情况
    }
    public long useDP(int[][] obstacleGrid){
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int col = obstacleGrid[0].length;
        long[][] dp = new long[row][col];
        for(int i = 0; i < col;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 2;
        }
        for(int j = 0; j < row; j++){
            if(obstacleGrid[j][0] == 1){
                break;
            }
            dp[j][0] = 2;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j]!=1){  // 不是判断你dp
                    if(obstacleGrid[i-1][j]!=1 && obstacleGrid[i][j-1]!=1){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                    
                }
            }
        }
        return dp[row-1][col-1]/2;
    }
}
```

