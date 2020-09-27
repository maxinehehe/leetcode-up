package june.code.byhehe.Review.leetcodeByHuaWei;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class OfferOprate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //注意使用nextLine方法来接收可能的空格
        String line = sc.nextLine();
        line = line.replace('{','(').replace('}',')')
                .replace('[','(').replace(']',')');
        char s[] = line.toCharArray();
		/*for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}*/
        long res = solve(s);
        System.out.println(res);
        sc.close();
    }

    private static long solve(char[] s) {
        Stack<Character> stack = new Stack<Character>();
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < s.length;){
            if(s[i] == ' ') {
                i++;
                continue;
            }
            else if(s[i] >= '0' && s[i] <= '9'){
                int sum = 0;
                //特别要注意i < s.length这个条件
                while(i < s.length && s[i] >= '0' && s[i] <= '9'){
                    sum = sum * 10 + s[i] - '0';
                    i++;
                    /*System.out.println("i = " + i);*/
                }
                queue.add(Integer.toString(sum));
            }else if(s[i] == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    queue.add(stack.pop() + "");
                }
                stack.pop();
                i++;
            }else{
                while(!stack.isEmpty() && compare(stack.peek(), s[i]) < 0){
                    queue.add(stack.pop() + "");
                }
                stack.add(s[i]);
                i++;
            }
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop() + "");
        }
        //必须要使用.equals方法才正确使用 == 不正确
        Stack<Integer> res = new Stack<Integer>();
        while(!queue.isEmpty()){
            String t = queue.poll();
            if(t.equals("+")  || t.equals("-") || t.equals("*") || t.equals("/")){
                int a = res.pop();
                int b = res.pop();
                int result = cal(b, a, t);
                res.push(result);
            }else{
                res.add(Integer.parseInt(t));
            }
        }
        return res.pop();
    }

    private static int cal(int a, int b, String t) {
        //计算
        if(t.equals("+")){
            return a + b;
        }else if(t.equals("-")){
            return a - b;
        }else if(t.equals("*")){
            return a * b;
        }else{
            return a / b;
        }
    }

    private static int compare(char peek, char c) {
        if(peek == '(' || c == '(') return 1;
        if(c == '+' || c == '-') return -1;
        if(c == '*' && (peek == '*' || peek == '/'))return -1;
        if(c == '/' && (peek == '*' || peek == '/'))return -1;
        return 1;
    }
}