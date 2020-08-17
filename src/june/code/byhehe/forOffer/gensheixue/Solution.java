package june.code.byhehe.forOffer.gensheixue;

import java.util.Stack;

class Node{
    int data;
    Node next;
}
public class Solution {
    public static void main(String[] args) {
        String s1  = "(u(love)i)";

        System.out.println(reverseParentheses(s1));
    }
    // 思路 ： 使用栈
    public static String reverseParentheses(String s){
//        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        // 一直入栈 直到碰到 ) 就出战 并进行反转 然后再将反转后的数据入栈
        //
        Stack<Integer> stack = new Stack<>();
        char[] tmp = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(tmp[i] == '('){
                stack.push(i);
            }else if(tmp[i]==')'){
                reverString(tmp, stack.pop()+1, i-1);  // 反转
            }
        }
        for(char c:tmp){
            if(c!='('&&c!=')'){
                res.append(c);

            }
        }
        return res.toString();
    }

    public static void reverString(char[] arr, int l, int r){
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

        // 或者

    }

    public Node mergeTwoLists(Node n1, Node n2){
        if(n1==null){
            return n2;
        }
        if(n2==null){
            return n1;
        }
        Node newHead = new Node();
        Node cur = newHead;
        while (n1 != null && n2 != null){
            if(n1.data < n2.data){
                cur.next = n1;
                n1 = n1.next;
            }else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;

        }
        if(n1!=null){
            cur.next = n1;
        }
        if(n2!=null){
            cur.next = n2;
        }

        return newHead.next;
    }

}
