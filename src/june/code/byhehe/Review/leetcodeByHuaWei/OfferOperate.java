package june.code.byhehe.Review.leetcodeByHuaWei;

import java.util.*;
//public class OfferOperate
// package june.code.byhehe.forOffer.HW;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;

// 3+2*{1+2*[-4/(8-6)+7]}
// 中缀转后缀
//具体转换方式:
// 1.从左到右进行遍历
// 2.运算数,直接输出.
// 3.左括号,直接压入堆栈,(括号是最高优先级,无需比较)(入栈后优先级降到最低,确保其他符号正常入栈)
// 4.右括号,(意味着括号已结束)不断弹出栈顶运算符并输出直到遇到左括号(弹出但不输出)
// 5.运算符,将该运算符与栈顶运算符进行比较,
// 如果优先级高于栈顶运算符则压入堆栈(该部分运算还不能进行),
// 如果优先级低于等于栈顶运算符则将栈顶运算符弹出并输出,然后比较新的栈顶运算符.
// (低于弹出意味着前面部分可以运算,先输出的一定是高优先级运算符,等于弹出是因为同等优先级,从左到右运算)
// 直到优先级大于栈顶运算符或者栈空,再将该运算符入栈.
// 6.如果对象处理完毕,则按顺序弹出并输出栈中所有运算符.
/*
3+2*{1+2*[4/(8-6)+7]}
3+2*(1+2*(4/(8-6)+7))
[3, 2, 1, 2, 4, 8, 6, -, /, 7, +, *, +, *, +]
41
 */
public class OfferOperate{

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String line = "";
        while(sc.hasNext())
        {
            line = sc.nextLine();
            line = line.replace('{','(').replace('}',')')
                    .replace('[','(').replace(']',')');

            System.out.println(line);
            // 存储括号字符'(', ')'
            Stack<Character> stack = new Stack<Character>();
            // 存储 数字和运算符
            List<Object> list = new ArrayList<Object>();

            //利用中缀表达式构建后缀表达式
            for(int i=0;i<line.length();++i)
            {
                // 定义一个 字符串 专门用于存储 数字
                String T = "";
                // 如果当前 字符 是数字 就放入 T 中， 直到 遇到非数字 字符
                while(i<line.length() && line.charAt(i)>='0'&&line.charAt(i)<='9')
                    T = T + line.charAt(i++);
                // 到这里说明遇到 非数字字符了， 那么就 将 T 保存的数字字符进行防盗 list 中
                if(!T.equals("")){  //T不等于""，说明T是一个数字字符串
                    // 之所以敢转换是因为 不可能一直都是 的 比如 4+8 这种类型的
                    list.add(new Integer(T));  //转为一个Integer对象
                    --i; // 这里 i--， 是因为 当前判断的是非数字字符， 不会到 else 逻辑， 上面还有一个i++,会跳过当前字符的
                }
                else  // T等于空说明当前的charAt(i)不是数字 ,是操作符号
                {   // 如果是 '('
                    if(line.charAt(i)=='(')//如果是（ 则先入栈 【专门保存符号， 运算符的】
                        stack.push(line.charAt(i));
                    else if(line.charAt(i)=='+'||line.charAt(i)=='-'||line.charAt(i)=='*'||line.charAt(i)=='/') /*是符号 并且优先级大于*/
                    {
                        if(stack.isEmpty())//若果栈是空的，直接加入第一个符号
                            stack.push(line.charAt(i));
                        else if(isUpperPro(line.charAt(i), stack.peek()))//新符号优先级大于栈顶
                            stack.push(line.charAt(i));
                        else{//新符号优先级低于栈顶
                            while(!stack.isEmpty() && stack.peek()!='(' && !isUpperPro(line.charAt(i),stack.peek()))
                                list.add(stack.pop());
                            stack.push(line.charAt(i));
                        }
                    }
                    else if(line.charAt(i)==')'){
                        while(stack.peek()!='(')
                            list.add(stack.pop());
                        stack.pop();  // '(' 出栈
                    }
                }
            }
            while(!stack.isEmpty())
                list.add(stack.pop());

//          Iterator<Object> iter = list.iterator();
//          while(iter.hasNext())
//              System.out.print(iter.next());
            System.out.println(list);
            //利用后缀表达式求值
            Stack<Integer> pStack = new Stack<Integer>();
            Iterator<Object> it= list.iterator();
            while(it.hasNext())
            {
                Object temp = it.next();
                if(temp instanceof Integer)  // 表示 temp 是 Integer 的实例 或者 子类
                    pStack.push((Integer)temp);
                else if(temp instanceof Character){
                    int temp2 = pStack.pop();   //要注意出栈进栈的顺序，使得操作数也不一样
                    int temp1 = pStack.pop();
                    int res = getOP(temp1,temp2,(char)temp);
                    pStack.push(res);
                }
            }
            System.out.println(pStack.pop());
        }
    }


    private static int getOP(int temp1, int temp2, char charAt){
        if(charAt == '+') return temp1+temp2;
        if(charAt == '-') return temp1-temp2;
        if(charAt == '*') return temp1*temp2;
        if(charAt == '/') return temp1/temp2;
        return 0;
    }


    private static boolean isUpperPro(char charAt, char peek){
        if(peek=='(')  //如果栈顶元素是（,那么新字符优先级大于栈顶的（
            return true;
        if((charAt=='+'||charAt=='-')&&(peek=='*'||peek=='/'))
            return false;
        if((charAt=='*'||charAt=='/')&&(peek=='-'||peek=='+'))
            return true;
        if((charAt=='+'||charAt=='-')&&(peek=='+'||peek=='-'))
            return false;
        if((charAt=='*'||charAt=='/')&&(peek=='*'||peek=='/'))
            return false;

        return false;
    }
}