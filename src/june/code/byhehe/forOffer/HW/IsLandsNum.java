package june.code.byhehe.forOffer.HW;

import java.util.*;

/*
4,5
SSHHH
SSHHH
HHSHH
HHHSS
 */
public class IsLandsNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            int M = Integer.valueOf(s1.split(",")[0]);
            int N = Integer.valueOf(s1.split(",")[0]);
            char[][] chars  = new char[M][N];
            for (int i = 0; i < M; i++) {
                String s = sc.nextLine();
                chars[i] = s.toCharArray();
            }
            Solution s = new Solution();
            int res = s.numIslands(chars);
            System.out.println(res);

        }
    }
}

class Solution {
    public boolean[][] marked;
    public char[][] grid;
    //    public String word;
    // 行列
    public int m,n;

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
                if(!marked[i][j] && grid[i][j] == 'S'){
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
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if(inArea(newX, newY) && grid[newX][newY] == 'S' && !marked[newX][newY]){
                dfs(newX,newY);
            }
        }
    }
    public boolean inArea(int newx, int newy){
        return newx>=0 && newy>=0 && newx <m && newy <n;
    }
}