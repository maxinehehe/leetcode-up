#### [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)

难度中等512

在 *O*(*n* log *n*) 时间复杂度和常数级空间复杂度下，对链表进行排序。

**示例 1:**

```
输入: 4->2->1->3
输出: 1->2->3->4
```

**示例 2:**

```
输入: -1->5->3->4->0
输出: -1->0->3->4->5
```







## 思路

```
使用归并排序
递归版本 则需要 O(n)空间
非递归版本 则需要O(1) 空间
```

## 代码 非递归版本

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getListLen(head);
        int itrv = 1;
        while(itrv < len) {
            ListNode pre = dummy;
            ListNode h = dummy.next;
            // 找到合并链表的h1和h2头节点
            while(h!=null) {
                int i = itrv;
                ListNode h1 = h;
                for(; h != null && i > 0; i--) {
                    h = h.next;
                }
                // i>0说明没有链表2直接返回
                if(i > 0) break;
                ListNode h2 = h;
                i = itrv;
                for(; h != null && i > 0; i--) {
                    h = h.next;
                }
                // 求出两个链表的长度
                int c1 = itrv;
                int c2 = itrv - i;
                
                //合并
                while(c1 > 0 && c2 > 0) {
                    if(h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    }else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while(c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            itrv*=2;
        }
        return dummy.next;
    }

    private int getListLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
```

## 代码 递归版本

```java
class Solution {
    public ListNode sortList(ListNode head) {
        // 采用 归并排序 由于 归并排序过程中 使用的 空间
        // 先判断链表空不空
        if(head == null || head.next == null) return head;
        // 然后找到 分界点 使用双指针 即快慢指针寻找
        // 快慢指针 快指针 先指向 head.next 慢指针指向 head 快指针每次比慢指针多走两步 知道末位
        // 慢指针指的就是 后半部分的前一个节点  1->2->3->4  slow = 2
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        // 断开两部分
        slow.next = null;
        // 进行分别排序
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        // 最后进行处理比如
        ListNode h = new ListNode(0);  // 一个辅助节点 装头
        ListNode res = h;
        while (left!=null && right!=null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left !=null? left:right;
        return res.next;
    }
}

```

