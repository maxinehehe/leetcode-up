package june.code.byhehe.forOffer.helper;

import java.util.Arrays;
import java.util.List;


import java.util.Scanner;

public class ZiMuXuanZhuan {
    public static void main(String[] args) {
        MySlov ms = new MySlov();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(ms.getRes(x,y));
        }

    }
}

class MySlov{
   public int getRes(int x, int y){
        if(x == y )
            return x;
        ListNode head1 = new ListNode(0);
        ListNode p1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode p2 = head2;

        while (x!=0){
            p1.next = new ListNode(x);
            x /= 2;
            p1 = p1.next;
        }

        while (y!=0){
            p2.next = new ListNode(y);
            y /= 2;
            p2 = p2.next;
        }

        printNode(head1.next);
        printNode(head2.next);
        ListNode res = FindFirstCommonNode(head1.next, head2.next);
        return res==null?-1:res.val;
   }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
//        System.out.println("head1: "+pHead1.val+" head2: "+pHead2.val);
        while(p1.val != p2.val){  // 边走的过程还要判断是否一开始就能找到公共结点
            p1 = p1.next;
            p2 = p2.next;

            if(p1 == null)p1 = pHead2;
            if(p2 == null)p2 = pHead1;
        }
        return p1; // 此时返回 p1 或 p2都可以 公共结点
    }

    public void printNode(ListNode node){
       while (node!=null){
           System.out.print(node.val+" ");
           node = node.next;
       }
        System.out.println();
    }

}
class ListNode{
    int val;
    ListNode next=null;
    public ListNode(int val){
        this.val = val;
    }
}
