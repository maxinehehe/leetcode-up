package june.code.byhehe.book;

import java.util.Stack;

/**
 * 题目：
 * 给定一个不含有 重复值的数组 arr, 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i]
 * 小的位置（即左右两边 比 i 小的值且是离他最近的，并非是最小的值 比如 1 2 3 4 ， 就 3 而言
 * 它左边最小且最近是 2， 右边则是 4）。
 *
 * 单调栈问题：
 * 首先 O(N^2) 的解法 rightWay 方法。
 *
 */
public class SingleStack {
    public static void main(String[] args) {
        int [] arr = {3, 4, 1, 5, 6, 2, 7};
        int [][] res = getNearLessNoRepeat(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[ "+res[i][0] +" "+res[i][1]+" ]");
        }
    }

    // arr = [3, 4, 1, 5, 6, 2, 7]
    public static int[][] rightWay(int[] arr){
        // 对于每个位置分别遍历一下

        int[][] res = new int[arr.length][2];
        // 第一个循环遍历寻找每个位置 i
        for (int i = 0; i < arr.length; i++) {
           int leftLessIndex = -1;
           int rightLessIndex = -1;
           int cur = i - 1;  // 初始化的时候 为 -1
           // 当前 cur 为 i - 1 即 从 当前位置 i 的左边开始 一直往左找
            // 向远方走去
           while (cur >= 0){  // 注意 cur 的变化
               // 下面不断比较 只需要和上一次保存的最小值比较看是否能找到更小的
               // 如果可以找到就进行更换 最小值
               if(arr[cur] < arr[i]){
                   leftLessIndex = cur;
                   break;
               }
               cur--;
           }
            // 当前 cur 为 i + 1 即 从 当前位置 i 的右边开始 一直往右找
           cur = i + 1;
           while (cur < arr.length){
               // 同理
               if(arr[cur] < arr[i]){
                    rightLessIndex = i;
                    break;
               }
               cur++;
           }
           res[i][0] = leftLessIndex;
           res[i][1] = rightLessIndex;
        }
        return res;
    }

    // 单调栈 无重复数组篇
    /**
     * 非重复数组
     * 重点 ： 对于 找到 当前位置 i 的 左右两边比它 小 的 值，则使用 栈 栈顶到 栈底 单调递减
     *        对于找到比 i 位置 左右两边大的值，则使用的 栈 从栈顶到栈底 单调递增
     */
    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            // 首先进行判断 栈是否为空 不为空的话（&&） 栈顶元素 是否 大于 当前要入栈的元素
            // 都成里的话则进入判断 逻辑 ，不然则直接入栈
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                // 说明不满足 则进行出栈操作
                int popIndex = stack.pop();
                // 如果 出完一个元素之后 栈空了 那么 当前比他小的左边的索引就是 -1
                // 否则 就是当前的栈顶元素 即出栈元素的下一个位置
                int leftLessIndex = stack.isEmpty() ? -1:stack.peek();
                res[popIndex][0] = leftLessIndex;
                // 那么 它右边就是 当前打破这份宁静的元素 也就是 打破 从栈顶到栈底 单调递减
                // 所以他就是 当前出栈元素的 右边离它最近且最小的值
                res[popIndex][1] = i;  // 这个 i 就是当前元素位置
            }
            stack.push(i); // 入栈 位置

//            stack.peek().get();
        }
        // 接着处理一下 遍历结束 栈不为空的情况
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()?-1:stack.peek();
            res[popIndex][0] = leftLessIndex;
            // 这里表示 当前栈中的元素 出栈完 都没有 找到打破他们 从栈顶到栈底 单调递减的情况
            // 也就是 ，左右在右边找到比他们小的值 所以他们 右边的最小且最近的值都是 -1
            res[popIndex][1] = -1;
        }
        return res;
    }
}
