package june.code.byhehe.utils;


import java.awt.*;
import java.util.*;
import java.util.List;

/*
练习题：蒜头君回家
蒜头君要回家，但是他家的钥匙在他的朋友花椰妹手里，他要先从花椰妹手里取得钥匙才能回到家。
花椰妹告诉他：“你家的钥匙被我复制了很多个，分别放在不同的地方。”
蒜头君希望能尽快回到家中，他需要首先取得任意一把钥匙，请你帮他计算出回家所需要的最短路程。
蒜头君生活的城市可以看做是一个n×m的网格，其中有道路有障碍，钥匙和家所在的地方可以看做是道路，可以通过
。蒜头君可以在城市中沿着上下左右4个方向移动，移动一个格子算做走一步。
输入格式
第一行有两个整数n，m。城市的地图是n行m列。(1≤n,m≤2000)
接下来的n行，每行m个字符，代表城市的地图。'.' 代表道路，'#' 代表障碍物，
'S' 代表蒜头君所在的位置，'T' 代表蒜头家的位置，'P'代表钥匙的位置。除了障碍物以外，
别的地方都可以通过。(题目保证蒜头君至少有一条路径可以顺利拿到钥匙并且回家)
输出格式
输出蒜头回家要走的最少步数，占一行。
样例输入
8 10
P.####.#P#
..#..#...#
..#T##.#.#
..........
..##.#####
..........
#####...##
###....S##
样例输出
21
 */
class point1 {
    int x, y, cont, juge;

    public point1(int xx, int yy, int cont, int juge) {
        x = xx;
        y = yy;
        this.cont = cont;
        this.juge = juge;

    }
}

public class GoHome_bfs {
    public static int bfs(int x, int y, char[][] dt) {
        List<point1> four = new ArrayList<>();
        point1 up = new point1(0, -1, 0, 0);
        point1 down = new point1(0, 1, 0, 0);
        point1 left = new point1(-1, 0, 0, 0);
        point1 right = new point1(1, 0, 0, 0);
        four.add(up);
        four.add(down);
        four.add(left);
        four.add(right);
        Queue<point1> q = new LinkedList<>();
        point1 sp = new point1(x, y, 0, 0);
        int[][][] juge = new int[dt.length][dt[0].length][2];
        juge[x][y][0] = 1;
        ((LinkedList<point1>) q).add(sp);
        while (q.isEmpty()) {
            point1 npoint = q.poll();
            for (int i = 0; i < four.size(); i++) {
                int nx = npoint.x + four.get(i).x;
                int ny = npoint.x + four.get(i).y;
                int flog = npoint.juge;
                if (dt[nx][ny] != '#' && juge[nx][ny][flog] != 1 && nx >= 0 && nx < dt.length && ny >= 0 && ny < dt[0].length) {
                    if (dt[nx][ny]=='P'){
                        ((LinkedList<point1>) q).push(new point1(nx,ny,npoint.cont+1,1));
                    }else if (dt[nx][ny]=='T'&&flog==1){
                        return npoint.cont+1;
                    }else {
                        ((LinkedList<point1>) q).push(new point1(nx,ny,npoint.cont,npoint.juge));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        GoHome_bfs a=new GoHome_bfs();
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int sx=0;
        int sy=0;
        char[][] dt=new char[x][y];
        for (int i = 0; i <dt.length ; i++) {
            for (int j = 0; j <dt[0].length ; j++) {
                dt[i][j]=sc.next().charAt(0);
                if (dt[i][j]=='S'){
                    sx=i;
                    sy=j;
                }
            }
        }
        System.out.println(a.bfs(sx,sy,dt));
    }

}
