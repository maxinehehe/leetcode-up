package june.code.byhehe.forOffer.pdd;

import java.util.*;

// 第二题
/*
5 6
X00100
00000X
01T000
0X1010
00000X

4
0 0 1 5
 */
public class Pdd02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board;
        PddNo2 pdd = new PddNo2();
        while (sc.hasNext()){
            String[] nm = sc.nextLine().split(" ");
            int N = Integer.valueOf(nm[0]);
            int M = Integer.valueOf(nm[1]);
            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                board[i] = sc.nextLine().toCharArray();
            }

            Map<Integer, List<Integer>> res = pdd.getRes(board);
            Set<Map.Entry<Integer, List<Integer>>> entries = res.entrySet();

            Iterator it = entries.iterator();
            //while (it.hasNext()){
                Map.Entry<Integer, List<Integer>> myres = (Map.Entry<Integer, List<Integer>>) it.next();
                System.out.println(myres.getKey());
                List<Integer> list = myres.getValue();
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if(i!=list.size())
                        System.out.print(" ");
                }
                System.out.println();
//            }
        }
    }
}

class PddNo2 {
    public char[][] board;
    public int N, M;
    //    public boolean[][] marked;
    public Map<Integer, List<Integer>> res;
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    public int count = 0;

    public Map<Integer, List<Integer>> getRes(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return res;
        // 默认升序排序
        this.res = new TreeMap<>();
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;

        List<Integer> list;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X') {
//                    System.out.println("起点 "+" x -> "+i+" y -> "+j);
                    queue.clear();
                    queue.add(new int[]{i, j});
                    list = BFS(queue, i, j);
                    if (list != null && list.size() != 0) {
                        int key = list.get(0).intValue();

                        if (res.containsKey(key)) {
                            List temp = res.get(key);
                            temp.add(list.get(1));
                            temp.add(list.get(2));
                        } else {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(list.get(1));
                            temp.add(list.get(2));
                            res.put(key, temp);
                        }
                    }
                }
            }
        }
        return res;
    }

    // list 存储 [length, newX, newY] 表示 (i,j) 到 （newX, newY）的路径长度 length
    public List<Integer> BFS(Queue<int[]> queue, int i, int j) {
        // 这里必须要 创建新的 visited 访问表 因为 每一个起始点开始， 都是全新的路程 这里不会和之前的结果产生联系
        boolean[][] visited = new boolean[N][M];
        // 这个路径表 是用来记录每一 从 (i,j) 为起点的到自己这里的路径长度
        // 使用一个新的路径长度表记录
        int[][] gridLen = new int[N][M];
        // 起始点到自己的 路径长度为 0
        gridLen[i][j] = 0; // 起点

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 移除队列头部的坐标
            int[] xy = queue.remove();
            // 作为起点
            int length = gridLen[xy[0]][xy[1]];
            visited[xy[0]][xy[1]] = true;
            for (int k = 0; k < 4; k++) {
                int newX = xy[0] + directions[k][0];
                int newY = xy[1] + directions[k][1];

                if (!inArea(newX, newY) || board[newX][newY] == '1' || visited[newX][newY])
                    continue;

                queue.add(new int[]{newX, newY});
                gridLen[newX][newY] = length + 1;

                if (board[newX][newY] == 'T') {
                    res.add(gridLen[newX][newY]);
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return null;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}



