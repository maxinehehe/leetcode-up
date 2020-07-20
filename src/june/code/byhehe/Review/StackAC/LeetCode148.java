package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

public class LeetCode148 {
    public static void main(String[] args) {

    }

    // 同样考虑快慢指针 采用递归法 分拆
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 现在是指的 后半部分的开头的前一个节点
        // 比如 4 -> 2 -> 1 -> 3
        ListNode temp = slow.next;   // 现在 temp 就是 后半部分头结点
        slow.next = null;  // 断开

        // 递归去到 单个元素
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        // 标记新的头结点
        ListNode h = new ListNode(0);
        ListNode p = h;

        while (left!=null && right!=null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        // 封尾
        p.next = left !=null?left:right;
        return h.next;

    }
}
