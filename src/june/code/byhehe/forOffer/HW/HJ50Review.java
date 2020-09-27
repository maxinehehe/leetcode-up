package june.code.byhehe.forOffer.HW;

import java.util.*;

/**
 * 四则运算的题 好好整理下
 * 3+2*(3+4*(-6+5*(8-6)))
 */
public class HJ50Review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(getStringRex(s));
        }
    }
    public static int getStringRex(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            // 先判断 是否是数字
            String T="";  // 用来存数字和运算符
            while (i<chars.length && chars[i] >='0' && chars[i]<='9'){
                T = T + chars[i++];
            }
            if(!"".equals(T)){
                list.add(new Integer(T)); // 这种写法 包括了 不仅 0~10的数字
                i--;  // 这里 比如 9+8-7 执行到了 - 这里，但是 T 不空， 如果不i--,就会跳过 - 而未进行处理
            }else {
                // 判断是不是 ( 括号
                if(chars[i] == '('){
                    stack.push(chars[i]);
                }else if(chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/'){
                    // 先判断站是否为空
                    if(stack.isEmpty()){
                        stack.push(chars[i]);
                        // 如果是运算符 需要进行判断优先级
                    }else if(isupper(chars[i], stack.peek())){
                        stack.push(chars[i]);
                    }else {
                        // 优先级不高  先把低优先级的出栈 注意判断 空 和 '('
                        while (!stack.isEmpty() && stack.peek() != '(' && !isupper(chars[i], stack.peek())){
                            list.add(stack.pop());
                        }
                        stack.push(chars[i]);
                    }

                }else if(chars[i] == ')'){
                    while (stack.peek()!='('){
                        list.add(stack.pop());
                    }
                    stack.pop(); // 把 '(' 出栈丢掉
                }
            }
        }
        while (!stack.isEmpty())
            list.add(stack.pop());

        // 开始计算
        Stack<Integer> stackNum = new Stack<>();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()){
            Object temp = it.next();
            if(temp instanceof Integer){
                stackNum.push((Integer)temp);
            }else if(temp instanceof Character){
                int a = stackNum.pop();
                int b = stackNum.pop();
                // 注意倒序
                int num = compute(b, a, (char)temp);
                stackNum.push(num);
            }
        }
        return stackNum.pop();
    }

    public static boolean isupper(char a, char b){
        if(b == '(')
            return true;

        if(a == '*'|| a == '/' && b == '+' || b== '-')
            return true;
        if(a == '+'|| a == '-' && b == '*' || b== '/')
            return false;
        // 如果是 平级也不行
        if(a == '+'|| a == '-' && b == '+' || b== '-')
            return false;
        if(a == '*'|| a == '/' && b == '*' || b== '/')
            return false;
        // 其他情况 返回 false
        return false;
    }
    public static int compute(int a, int b, char c){
        if(c == '*'){
            return a * b;
        }else if( c == '/'){
            return a / b;
        }else if( c == '-'){
            return a - b;
        }else if( c == '+'){
            return a + b;
        }else{
            return 0;
        }
    }
}
