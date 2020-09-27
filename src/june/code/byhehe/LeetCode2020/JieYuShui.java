package june.code.byhehe.LeetCode2020;

public class JieYuShui {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
    /*
   计算出每一个位置左边的的最大值 和 右边最大值  然后 选一个相对更小的值
   */
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
//        int maxLeftVal = height[0];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
//            System.out.print(leftMax[i]+" ");
//            leftMax[i] = maxLeftVal;
        }
//        System.out.println();
        int [] rightMax = new int[n];
//        int maxRightVal = height[n-1];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
//            rightMax[i] = maxRightVal;
            System.out.print(rightMax[i]+" ");
        }
        System.out.println();
        int sum = 0;
        for(int i = 1; i < n-1; i++){
//            sum += Math.max(Math.min(rightMax[i-1], leftMax[i+1]) - height[i], 0);
            // 不要把左右搞错了 OK fuck
            sum += Math.max(Math.min(leftMax[i-1], rightMax[i+1]) - height[i], 0);
            System.out.print("sum: " + sum + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(height[i]+" ");
        }
        System.out.println();
        return sum;
    }
}
