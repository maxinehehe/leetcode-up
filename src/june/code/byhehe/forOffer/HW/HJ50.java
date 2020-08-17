package june.code.byhehe.forOffer.HW;

import java.util.Scanner;
import java.util.Stack;

/**
 * 四则运算
 * 思路： 先转为 后缀表达式 在进行计算
 * 这里由于存在 中括号 大括号 所以可以将他们统一替换为 ()
 */

public class HJ50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        String s = handle("3+2*{1+2*[-4/(8-6)+7]}");
        String str = handle(s);
//        System.out.println(s);
        System.out.println(computeResLastSuffix(str));

    }

    // 将中缀表达式转换为后缀
    public static String handle(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // 处理 符号 将 {}[] 全部替换成 ()
        String str = s.replace("{","(")
                .replace("}",")")
                .replace("[","(")
                .replace("]",")");
//        System.out.println(str);
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 判断是否是操作符
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                // 是操作符 判断栈是否为空 比较优先级
                if(stack.isEmpty() || '(' == stack.peek() || getPriority(c) >= getPriority(stack.peek())){
                    stack.push(c);
                }else {
                    while (!stack.isEmpty() && '(' != stack.peek()){
                        if(getPriority(c) <= getPriority(stack.peek()))
                            sb.append(stack.pop());
                    }
                    // 当前操作符入栈
                    stack.push(c);
                }
                // 之所以要加这一句是因为 可能会出现  3+2*{1+2*[-4/(8-6)+7]} 的表达式
//                // 即 -4/(8-6)
//                if(i>1 && (chars[i-1] == '(') && c=='-')
//                    sb.append('0');
            }else if(Character.isDigit(c)){
                // 数字
                sb.append(c);
            }else if('(' == c){
                stack.push(c);
            }else if(')' == c){
                // 是右括号
                while (!stack.isEmpty()){
                    if('(' == stack.peek()){
                        stack.pop();
                        break;
                    }else {
                        sb.append(stack.pop());
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    // 计算结果
    public static int calValue(int a, int b, char c){
        switch (c){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default : return 0;

        }
    }

    //  根据后缀表达式进行计算
    public static int computeResLastSuffix(String s){
        int res = 0;
        char[] chars = s.toCharArray();
        Stack<Integer>  stackNum = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
//            int value = Integer.valueOf(chars[i]);
            char c = chars[i];
//            System.out.println("c: "+c);
            if(c == '+' || c == '-' || c=='/'|| c=='*'){

                int a = stackNum.pop();
                int b = 0;
                if(!stackNum.isEmpty())
                    b = stackNum.pop();
//                else
//                    b = 0;
                // 注意符号
//                System.out.println(b+" "+c+" "+a);
                res = calValue(b, a, c);
                stackNum.push(res);
            }else {

                stackNum.push(Integer.valueOf(String.valueOf(c)));
                System.out.println(stackNum);
            }
        }
        return stackNum.pop();
    }


    // 获取优先级
    public static int getPriority(char c){
        if(c == ' '){
            return 0;
        }
        switch (c){
            case '(': return 1;
            case '+': ;
            case '-': return 2;  // 这里表示 + - 都返回 2
            case '*':;
            case '/': return 3;
            default: return -1;
        }
    }


}
