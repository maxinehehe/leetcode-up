package june.code.byhehe.forOffer;

import java.util.Scanner;

public class HT02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        MySolv ms = new MySolv();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(ms.getRes(arr));
    }
    // 找最长 如果不是最长 那么就是找 最短 最短不符合 可能需要回溯
    // 初步考虑 使用 dfs+visted 返回的

}

class MySolv{
    public int[][] dirs = {{-1,0}, {1,0},{0,-1},{0,1}};
    public int rows, columns;
    public int getRes(int[][] matrix){
        // 首先判断 特殊值
        if(matrix == null || matrix.length == 0||matrix[0].length == 0)
            return 0;
        // 行
        rows = matrix.length;
        // 列
        columns = matrix[0].length;
        // visited 用来记录 缓存 已经走过的路径当前所记录的最长路径
        int[][] visited = new int[rows][columns];
        int ans = 0;
        // 由于可以从每个满足要求的点 出发 因此需要进行遍历每个点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 每遍历一个点 看结果是不是 比当前值更大， 如果是则更新最大值
                ans = Math.max(ans, dfs(matrix, i,j, visited));
            }
        }

        return ans;
    }

    public  int dfs(int[][] matrix, int row, int column, int[][] visited){
        // 进行剪枝 不然复杂度太大 ， 看有没有已经访问过该点， 有的话直接返回其所保存的路径长度
        if(visited[row][column] != 0){
            return visited[row][column];
        }
        // 如果没有， 说明可以来到当前点 说明该点是符合要求的，那么就进行+1
        // 可以理解为 这里最开始是 进行初始化 每个节点的 起始值 为 1， 既需要包括自身， 如果这里不进行 +1
        // 那么 再返回结果中 就需要 进行 return ++visited[row][column];
        ++visited[row][column];
//        for (int i = 0; i < 4; i++) {
//
//        }
        // 或者携程下面这样也行
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newColumn = column  + dir[1];
            if(newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn<columns
            &&matrix[newRow][newColumn] > matrix[row][column]){
                // matrix[newRow][newColumn] > matrix[row][column] 是关键 如果判断递减 只需要 < 即可
                // 另外我们不能用 走没走过来简单的判断 需要结合 visited[row][column] 从不同方向过来所能获取到的最大值
                // 通过上面的判断 (newRow, newCloumn) 这个点可以走， 那么接下来 就可以尝试 走到这个点 和 不走到这个点的哪个结果更大
                // 可以看到 dfs(...) 是能走到后面 所以进行 +1
                visited[row][column] = Math.max(visited[row][column],
                                                dfs(matrix, newRow, newColumn, visited)+1);
            }
        }
        return visited[row][column];
    }
}
