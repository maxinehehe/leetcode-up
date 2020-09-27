package june.code.byhehe.forOffer.yuanFuDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class YMain {
    public static void main(String[] args) {
        int N,M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int [][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        helper2(matrix);
//        System.out.println(getRes(matrix));
    }
    // 单调栈 注意是圆柱对的 有点坑
    public static int getRes(int[][] matrix){
        if(matrix.length == 0 || matrix == null||matrix[0].length == 0)
            return 0;
        int maxValue = 0;

        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                height[i] += matrix[i][j];
            }
            maxValue = Math.max(helper(height), maxValue);
        }
        return maxValue;

    }
    public static int helper(int[] height){
        if(height.length == 0|| height == null)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()&&height[stack.peek()]>height[i]){
                int j = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                int curVal = (i-k-1) *height[j];
                maxValue = Math.max(maxValue, curVal);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int curVal = (height.length - k - 1)* height[j];
            maxValue = Math.max(maxValue, curVal);
        }
        return maxValue;
    }


    public static int helper2(int[][] matrix){
        if(matrix.length == 0 || matrix == null||matrix[0].length == 0)
            return 0;
        int maxValue = 0;

        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                height[j] += matrix[i][j];
            }
//            maxValue = Math.max(helper(height), maxValue);
        }
//        for (int i = 0; i < height.length; i++) {
//            System.out.print(height[i]+" ");
//        }

        int sum = 0;
        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            int curV = sum;
            sum += height[i];
            sum = Math.max(curV, sum);
        }

        return sum;
    }

}
