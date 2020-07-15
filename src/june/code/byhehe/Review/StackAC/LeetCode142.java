package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 */

/**
 * 同141类似，首先找到环，然后 快指针不动， 慢指针 从头开始，二者在此一步一步走 相遇的节点即是
 * 环的入口。
 */
public class LeetCode142 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        // 使用双指针 快慢指针 找到后 在继续走
        //if(head == null) return head;
        if(head == null || head.next == head) return head;
        // if(head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 如果使用 fast = slow = head; 就需要先走 fast slow再判断
            if(fast == slow)
                break;
        }
        // 注意 这一句 fast.next == null 至关重要 如果不存在换的话 1,2,3,4 其中 4 是最后一个 正好 ， 那么 当前 fast == 4 所以不一定就是空的。
        if(fast == null || fast.next == null) return null;

        fast = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
