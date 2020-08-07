package june.code.byhehe.book;

import june.code.byhehe.utils.ListNode;

public class TraverseList {
    public ListNode reverseSingleList(ListNode head){
        if(head == null)
            return head;
        ListNode pre = null;    // 保存上一个 节点 作为被指向的下一个节点
        ListNode next = null;   // 下一个节点 保存的部分 不断后移
        while (head != null){
            // 首先记录 当前节点的后面部分
            next = head.next;
            // 然后进行操作 反转
            head.next = pre;   // 更改指向 指向上一个节点
            pre = head ;   //  然后自己再变为上一个节点 参与到下次操作中
            head = next;   // head 继续往后走
        }
        return head;
    }

}
