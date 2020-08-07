package june.code.byhehe.book;

/**
 * 给定义个矩阵 ， 其中值只有 0 和 1， QQ其中全是 1 的所有矩形区域中，最大的举行区域为 1 的数量
 * 如：1 1 1 0
 * 其中， 最大的举行区域 有 3 个 1， 所以返回 3
 *
 * 再如：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 最大的矩形区域有 6 个 1， 所以返回 6，
 */

import java.util.Stack;

/**
 * 这里考虑使用的方法是 单调栈
 * 首先 将上面的 落成连续的 1
 * 比如 三行的
 * 3 2 3 0   表示第三行 每个位置往上 有几个连续的 1
 */
public class GetMaxRecArea {
    public static void main(String[] args) {
        int [][] map = {
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        System.out.println("最大值是："+maxRecSize(map));
    }

    public static int maxRecSize(int[][] map){
        // 首先 判断 特殊情况 为空， 或者只有一列
        if (map == null || map.length == 0 || map[0].length == 0) {

            return 0;
        }
        // 下面开始现将矩阵处理成 一个数组
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // 每一行 每一列地走
                // 每一行都要去更新   如果当前行为 0 就打破了连续 直接置为 0
                height[j] = map[i][j] == 0 ? 0 : height[j]+1;
            }
            // 每一行都会形成一个数组 因此每一行都要去判断
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;

    }

    public static int maxRecFromBottom(int[] height){
        // 单调栈的逻辑 部分修改
        if(height == null || height.length == 0)
            return 0;
        int maxArea = 0;
        // 首先定义一个栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 判断 当前 i 位置的 元素 是否小于 栈顶 元素
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();  //  当前 j 位置的元素
                int k = stack.isEmpty()? -1 : stack.peek();   // 注意这里不能这样写 因为需要考虑栈空的情况
                // 当前 j 元素 网左边判断
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            // 这是后 height.length 做最大值
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

}
