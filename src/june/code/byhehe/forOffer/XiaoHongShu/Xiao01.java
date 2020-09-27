package june.code.byhehe.forOffer.XiaoHongShu;

import java.util.Scanner;
class SolX{
    public int[] area;
    public int L;
    public int T;
    public int X;
    public void handle(){
        Scanner sc = new Scanner(System.in);
        "".substring(0);
        int X = sc.nextInt();
        int L = sc.nextInt();
        int T = sc.nextInt();
        int N = sc.nextInt();
        this.L = L;
        this.T = T;
        this.X = X;
        this.area = new int[N];
        for (int i = 0; i < N; i++) {
            this.area[i] = sc.nextInt();
        }

        // 处理
        int lastCount = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < X; j++) {
            dfs(j, X, count);
            count = Math.min(lastCount, count);
        }

        System.out.println(count);

    }

    public int simple(int L,int T, int X){
        // X 表示目的地
//        for()
        return 0;
    }

    public void dfs(int cur,int dest, int count){
        if(cur == dest)
            return;
        if(isInArea(cur))
            count++;
        for (int i = L; i < T; i++) {
            dfs(cur+i, dest, count);
        }
    }

    public boolean isInArea(int x){
        for (int i = 0; i < area.length; i++) {
            if(x == area[i])
                return true;
        }
        return false;
    }
}
public class Xiao01 {
//    public int[] area;
    public static void main(String[] args) {
        SolX sx = new SolX();
        sx.handle();
    }




    public static int[] subSort(int[] arr){
        int []res = {-1,-1};
        if(arr.length == 0){
            return res;
        }
        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        int left = -1;
        int right = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < maxVal)
                right = i;
            else
                maxVal = Math.max(maxVal, arr[i]);

            if(arr[arr.length-1 - i] > minVal)
                left = arr.length - 1 - i;
            else
                minVal = Math.min(minVal, arr[arr.length-1-i]);
        }
        res[0] = left;
        res[1] = right;
        return res;
    }
}
