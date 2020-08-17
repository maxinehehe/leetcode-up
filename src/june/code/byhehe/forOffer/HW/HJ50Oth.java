package june.code.byhehe.forOffer.HW;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class HJ50Oth {
    private static Stack<Character> stack = new Stack<>();
    private static StringBuilder postFix = new StringBuilder();
    private static ArrayList<Integer> digitCnt = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String postFix = trans(str);
            int res = cal(postFix);
            System.out.println(res);
        }
    }
    //中缀表达式转成后缀表达式
    static String  trans(String inFix){
        String newInFix = inFix.replace('{', '(') //都换成小括号
                .replace('}', ')')
                .replace(']', ')')
                .replace('[', '(');
        char[] chars = newInFix.toCharArray();
        for (int i = 0; i < chars.length; ++i){
            // Character 自带 数字判别符号
            if (Character.isDigit(chars[i])){
                int temp = 0;
                //加上i < chars.length,否则数组越界
                while (i < chars.length && Character.isDigit(chars[i])) {
                    postFix.append(chars[i]);
                    ++i;
                    ++temp;
                }
                --i;
                digitCnt.add(temp);
            }else if (chars[i] == '('){
                stack.push(chars[i]);
            }else if (chars[i] == '+' || chars[i] == '-'){
                if (chars[i] == '-' && chars[i - 1] == '('){
                    postFix.append('0');
                    digitCnt.add(1);
                }
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')){
                    postFix.append(stack.peek());
                    stack.pop();
                }
                stack.push(chars[i]);
            }else if (chars[i] == '*' || chars[i] == '/'){
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    postFix.append(stack.peek());
                    stack.pop();
                }
                stack.push(chars[i]);
            }else {
                while (!stack.isEmpty() && stack.peek() != '('){
                    postFix.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            postFix.append( stack.pop());
        }
        return postFix.toString();
    }
    //计算后缀表达式的值
    static int cal(String postFix){
        int index = 0;
        Stack<Integer> stack1 = new Stack<>();
        char[] chas = postFix.toCharArray();
        for (int i = 0; i < chas.length; i++) {
            if (Character.isDigit(chas[i])){
                int total = 0;
                int cnt = digitCnt.get(index);
                while (cnt-- > 0){
                    total = 10 * total + (chas[i++] - '0');
                }
                --i;
                stack1.push(total);
                ++index;
            }else {
                int num1 = stack1.peek();
                stack1.pop();
                int num2 = stack1.peek();
                stack1.pop();
                if (chas[i] == '+'){
                    stack1.push(num1 + num2);
                }else if (chas[i] == '-'){
                    stack1.push(num2 - num1);
                }else if (chas[i] == '*'){
                    stack1.push(num1 * num2);
                }else {
                    stack1.push(num2 / num1);
                }
            }
        }
        return stack1.peek();
    }

}
