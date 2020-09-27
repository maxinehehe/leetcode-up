package june.code.byhehe.utils;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
    public static void main(String[] args) {
        Solution102 s102 = new Solution102();
        String[][] maps = {
                {"S","."},
                {"#","T"}
        };
        System.out.println(s102.maze(maps));
    }


}

 class Solution102 {
     /**
      * @param maps string字符串二维数组 地图
      * @return int整型
      */
//     public  int useV = 1000;
     public boolean visit[][] = new boolean[1000][1000];
     public int n,m;
     public int []row = {-1,0,1,0};
     public int []col = {0,-1,0,1};
     public int startx, starty, endx,endy, val=Integer.MAX_VALUE;
     public List<String> v = new ArrayList<>();
     public boolean judge (int x, int y){
         //判断能走不
         if(x<0||x>=m)
             return false;
         if(y<0||y>=m)
             return false;
         if(visit[x][y] == false)
             return false;
         return true;
     }
     public void dfs(int x, int y, int ans){
         if(x==endx&&y==endy){
             if(val>ans) val = ans;
         }else {
             for (int i = 0; i < 4; i++) {
                 int xx = x;
                 int yy = y;
                 xx += row[i];
                 yy += col[i];
                 if(judge(xx,yy)){
                     ans++;
                     visit[xx][yy]=false;
                     dfs(xx,yy,ans);
                     visit[xx][yy] = true;
                     ans--;
                 }
             }
         }

     }
     public int maze(String[][] maps) {
         // write code here
         n = maps.length;
         m = maps[0].length;
         int ans = 0;
         for (int i = 0; i < n; i++) {

             for (int j = 0; j < m; j++) {
                 if(maps[i][j].equals("#"))
                     visit[i][j] = false;
                 else
                     visit[i][i]=true;
                 if(maps[i][j].equals("S")){
                     startx = i;
                     starty = j;
                 }
                 if(maps[i][j].equals("T")){
                     endx = i;
                     endy = j;
                 }

             }

             v.add(maps[i].toString());

         }
         visit[startx][starty] = false;
         dfs(startx, starty, ans);
         System.out.println(val);
         return val;
     }

 }
