package june.code.byhehe.Review.leetcodeByHuaWei;

import java.util.Stack;

public class LeetCode739 {
}
class lc739{
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        // 使用单调栈
        // 或者从后往前走 偏暴力
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i] ){
//                res[stack.pop()] = i - stack
                res[stack.peek()] = i - stack.pop();
            }
//            stack.push()
            stack.push(i);
        }

        return res;
    }
}
