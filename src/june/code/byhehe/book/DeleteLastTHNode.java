package june.code.byhehe.book;

import june.code.byhehe.utils.ListNode;

/**
 * 删除单链表倒数第 k 个节点
 */
public class DeleteLastTHNode {
    public ListNode removeLastKthNode(ListNode head, int lastKth){
        // 首先判断特殊情况 null 之类的
        if(head == null || lastKth < 1)
            return head;

        ListNode cur = head;
        while (cur!=null){
            lastKth--;
            cur = cur.next;
        }
        // 下面进行判断
        if(lastKth == 0)
            return head.next;  // 说明删除的正好就是头结点
        // 至于 lastKth > 0 的情况 则是不存 直接返回 头结点即可 这个逻辑不用考虑处理
        // 会合并到最后的处理
        if(lastKth < 0){
            cur = head;
            while (++lastKth!=0)
                cur = cur.next;
            cur.next = cur.next.next;
        }

        return head;    // lastKth > 0 的情况 也能合并到这里
    }
}
