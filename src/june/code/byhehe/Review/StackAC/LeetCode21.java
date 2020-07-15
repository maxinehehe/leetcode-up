package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

public class LeetCode21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;

            }
            p = p.next;
        }
        if(l1!=null)
            p.next = l1;
        if(l2!=null)
            p.next = l2;

        return newHead.next;
    }
}
