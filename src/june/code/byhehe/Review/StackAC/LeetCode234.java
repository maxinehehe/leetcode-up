package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class LeetCode234 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head){
        // 找到半路断开
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 前半部分的头结点
        fast = head;
        // 后半部分的头结点
        ListNode newHead = slow.next;
        slow.next = null;
        slow = reverseList(newHead);

        while(fast!=null && slow!=null){
            if(slow.val!=fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;


    }

    public ListNode reverseList(ListNode head){
        // 最简单的方法采用头插法
        ListNode newHead = new ListNode(0);
        ListNode p = null;
        while (head!=null){
            p = head;
            head = head.next;

            // 开始交换
            p.next = newHead.next;
            newHead.next = p;

        }
        return newHead.next;
    }
}
