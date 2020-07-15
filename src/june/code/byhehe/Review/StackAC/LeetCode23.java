package june.code.byhehe.Review.StackAC;

import june.code.byhehe.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class LeetCode23 {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        // 使用 优先队列priorityQueue
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        if(lists.length == 0)
            return null;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        // 将链表的头结点放入 优先队列中
        for(ListNode list:lists){
            if(list!=null)
                priorityQueue.add(list);  // 添加链表的头结点

        }

        // 然后 不断进行重复
        while (!priorityQueue.isEmpty()){
            ListNode currNode = priorityQueue.poll();
            if(currNode.next!=null)
                priorityQueue.add(currNode.next);
            newHead.next = currNode;
            newHead = newHead.next;
        }

        return newHead.next;

    }
}
