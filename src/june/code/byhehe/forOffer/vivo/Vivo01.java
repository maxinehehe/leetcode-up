package june.code.byhehe.forOffer.vivo;

import java.util.Scanner;

public class Vivo01 {
    public static void main(String[] args) {

        SolutionLeetCode solutionLeetCode = new SolutionLeetCode();
        int[] height = {4,5,1,3,2};//{3,1,2,5,2,4};
        int res = solutionLeetCode.maxArea(height);
        System.out.println(res);

//        Scanner sc = new Scanner(System.in);
//        int n = Integer.valueOf(sc.nextLine());
//        String[] line = sc.nextLine().split(" ");
//        int startX = Integer.valueOf(line[0]);
//        int startY = Integer.valueOf(line[1]);
//        int endX = Integer.valueOf(line[2]);
//        int endY = Integer.valueOf(line[3]);
//
//        char[][] grid = new char[n][n];
//        for (int i = 0; i < n; i++) {
//           grid[i] = sc.nextLine().toCharArray();
//        }
//
//        MyVivoSolution myVivoSolution = new MyVivoSolution();
//        int res = myVivoSolution.getRes(grid, startX, startY, endX, endY);
//        System.out.println(res);
    }
}

class MyVivoSolution{
    public int res = Integer.MAX_VALUE;  // 表示最终的最短路径
    public char[][] grid;
    public int m,n;
    public boolean[][] visited;
    public int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

    public int getRes(char[][] grid, int startX, int startY, int endX, int endY){
        // 这次不许要循环 已给定起点终点
        this.m = grid.length;
        if(m == 0)
            return res;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        // 起点 终点
        dfs(grid,startX, startY, endX, endY, 0);

        return res==Integer.MAX_VALUE?-1:res;
    }

    public void dfs(char[][] grid, int startX, int startY, int endX, int endY, int curLen){
        // 判断是否来到了出口

        if(startX == endX && startY == endY){
            res = Math.min(res, curLen);
//            visited[startX][startY] = false;
            return;
        }
        visited[startX][startY] = true;  // 正在拜访该节点
        // 开始王四个方向探索
        for (int i = 0; i < 4; i++) {
            int newX = startX + directions[i][0];
            int newY = startY + directions[i][1];

            // 进行判断
            if(!inArea(newX, newY) && !visited[newX][newY] && (grid[newX][newY]!='#'||grid[newX][newY]!='@')){
                dfs(grid, newX, newY, endX, endY, curLen+1); // 路径又长了一步
            }

            visited[startX][startY] = false;  // 表示没有走到最后的结果 返回
            return;
        }

    }
    public boolean inArea(int x, int y){
        return x < 0 || x >= m || y < 0 && y >= n;
    }
}


class SolutionLeetCode {
    // 盛最多水的容器
    public int maxArea(int[] height) {
        int len = height.length;
        if(len == 0)
            return 0;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            // 比较 和 height 比啊 。。。
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        int[] rightMax = new int[len];
        // 注意保存当前值啊
        rightMax[len -1] = height[len-1];
        for (int i = len-2; i >=0 ; i--) { // ???? 认真点 这是递减的 哥哥
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        // 然后判断两边
        int maxLen = 0;
        for (int i = 1; i < len - 1; i++) {
            maxLen += Math.max(Math.min(leftMax[i-1], rightMax[i+1]) - height[i], 0);
        }
        return maxLen;

    }
    // 寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 归并
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int p1 = 0, p2 = 0;
        int pa = 0;
        while (p1<m&&p2<n){
            arr[pa++] = nums1[p1]<nums2[p2]?nums1[p1++]:nums2[p2++];
        }
        while (p1<m)
            arr[pa++] = nums1[p1++];
        while (p2<n)
            arr[pa++] = nums2[p2++];
        if((m+n)%2 == 0)
            return (double) (arr[(m+n)/2]+arr[(m+n)/2-1])/2;
        else
            return arr[(m+n)/2];
    }
}