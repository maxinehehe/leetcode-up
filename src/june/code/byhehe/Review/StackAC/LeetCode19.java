package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？

 */
public class LeetCode19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(0);
        pre.next = slow;
        while(fast!=null && k--!=0)
            fast = fast.next;
        if(fast == null)
            return head.next;
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;
        }
        // 删除 slow.next
//        ListNode tmp = slow.next;
        pre.next = slow.next;
        return head;
    }
}
