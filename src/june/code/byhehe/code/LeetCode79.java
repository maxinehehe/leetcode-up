package june.code.byhehe.code;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode79 {
    public boolean[][] marked;
    public char[][] board;
    public String word;
    public int m,n;
    /*
              x-1, y
   x,y-1       x, y   x, y+1
              x+1, y
    因此 当 x, y = 0, 0 时
    那么就有 [-1,0],[0,-1],[0,1],[1,0]
     */
    // 根据上面的情况 定义四个方向如下：
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    // 使用方向判断的好处 就是 我们可以更加清晰明了的控制方向
    public boolean exist(char[][] board, String s){
        if(board.length == 0 )
            return false;
        this.board = board;
        this.word = s;
        this.m = board.length;
        this.n = board[0].length;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i, j, 0))
                    return true;
            }

        }

        return false;
    }

    public boolean dfs(int i, int j, int start){
        // 出口 判断 start 的位置是不是来到了最后 来到了最后 是不是 字符是相等的
        if(word.length() - 1 == start){
            return board[i][j] == word.charAt(start);
        }

        // 只有当前字符相等 我们才能走下一步
        if(board[i][j] == word.charAt(start)){
            // 首先 我们来到了 board[i][j] 的位置
            marked[i][j] = true;    // 表示使用它
            // 记住要走四个方向 需要判断 4 个方向
            for (int k = 0; k < 4; k++) {
                // 这里的 i,j 表示 x,y
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                // 然后判断 区域是否在范围内 以及是否以及走过
                // 错误点  注意 我们现在是使用的是 newX newY 所以应该判断 marked[newX][newY] 而不是marked[i][j]
                if(inArea(newX, newY) && !marked[newX][newY]){
                    if(dfs(newX, newY, start+1))
                        return true;
                }
            }
            // 走到这里说明 失败了 进行回溯 marked 清除之前的位 表示此路不通 退出
            marked[i][j] = false;
        }
        return false;
    }

    public boolean inArea(int newX, int newY){
        return newX >=0 && newX < m && newY >= 0 && newY <= n;
    }

    // 内部静态类 用于测试
    public static class Main{
        public static void main(String[] args) {
            char[][] board = {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
                    };
            String word = "ABCB";

            LeetCode79 lt = new LeetCode79();
            System.out.println(lt.exist(board, word));
        }
    }
}
