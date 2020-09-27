package june.code.byhehe.forOffer.youzan;

import java.util.Stack;

public class yzSolution2 {
}

 class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 输入的表达式的括号是否能配对
     * @param statement string字符串
     * @return bool布尔型
     */
    public boolean isValid (String statement) {
        // write code here
        Stack<Character> stack =  new Stack<>();
        for (int i = 0; i < statement.length(); i++) {
            char c = statement.charAt(i);
            if(c == '(' || c=='[' || c == '{')
                stack.push(c);
            else if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;

            }
        }
        return stack.isEmpty(); //  (123)
    }
}
