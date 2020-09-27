package june.code.byhehe.Review.leetcodeByHuaWei;

/*
剑指 Offer 29. 顺时针打印矩阵
 */
public class Offer29 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = s.spiralOrder(matrix);
        for(int ele: res)
            System.out.print(ele+" ");
    }
}

class Solution {
    // 注意这个方向严格不能乱变
    public int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        // 控制方向 +
        int rows = matrix.length;
        int cols = matrix[0].length;

        int total = rows*cols;  // 总数
        int[] ord = new int[total];
        // 还要判断访问过了吗
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0;   // 初始
        // 另外需要有一个 变量来控制取 四个方向的那个方向
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ord[i] = matrix[row][col];  // 进入当前位置
            // 开始访问
            visited[row][col] = true;
            // 然后 获取下一个位置 通过directions
            int newRow = row + directions[directionIndex][0];
            int newCol = col + directions[directionIndex][1];
            // 然后判断这两个方向有没有出界
            if(newRow < 0 || newRow >=rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]){
                // 进行更新方向 以 4 取余 {{0,1},{1,0},{0,-1},{-1,0}}
                directionIndex = (directionIndex + 1) % 4; // 方向+1 表示换到下一个
            }
            // 然后 才是 更新下次要去的位置
            // 意思就是用 newRow 和 newCol 来判断能走不， 能走 才 更新 row 和 col 来进行下一次
            // 因为这里的 directionIndex 可能进行更新了
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return ord;
    }
}
