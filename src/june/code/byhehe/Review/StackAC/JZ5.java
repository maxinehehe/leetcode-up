package june.code.byhehe.Review.StackAC;

import java.util.Stack;

public class JZ5 {
    public static void main(String[] args) {

    }

    // stack1 维持入栈操作
    Stack<Integer> stack1 = new Stack<Integer>();
    // stack2 维持出栈操作
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        // 入栈 保证 stack2 为空
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
        stack1.push(node);
    }

    public int pop() {
        // 出栈 保证 stack1 空 stack2 不空  stack2 出栈
        // 出栈 如果最开始都是空的话
        if(stack1.isEmpty() && stack2.isEmpty())
            return -1;
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }

}
