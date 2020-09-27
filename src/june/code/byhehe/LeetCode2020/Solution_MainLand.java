package june.code.byhehe.LeetCode2020;

public class Solution_MainLand {
}

class Land{
    public boolean[][] marked;
    public char[][] grid;
    //    public String word;
    // 行列
    public int m,n;
/*
            x-1,y
   x,y-1     x,y   x,y+1
            x+1,y
   x,y = (0,0)时
                 -1，0
   0，-1          0，0         0， 1
                 1，0
 */
    public int[][] directions = {{-1,0}, {0,-1}, {0,1},{1,0}};

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        if(m == 0)
            return 0;
        this.n = grid[0].length;

        this.grid = grid;
        // marked 用于标记是否已经访问过
        this.marked = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从当前七点开始 看有哪些没被访问过 也就是说 从当前起点 最多能延伸到哪里
                if(!marked[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(i,j);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j){
        marked[i][j] = true; // 将要被访问
        // 四个方向 都要考虑
        for (int k = 0; k < 4; k++) {
            // 这里的 k 表示 每个方向 索引  （newX, newY） 表示四个方向 都走一遍
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            // 下面对每个位置进行 判断 是否 在区域内   是否 是'1'   是否已经走过了
            if(inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]){
                // 符合以上条件 就带这 这个 坐标 再继续往前走
                dfs(newX,newY);
            }
        }
    }
    public boolean inArea(int newx, int newy){
        return newx>=0 && newy>=0 && newx <m && newy <n;
    }
}
