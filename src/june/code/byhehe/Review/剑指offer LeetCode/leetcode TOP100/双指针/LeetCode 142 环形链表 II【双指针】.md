#### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

难度中等451

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 `null`。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**说明：**不允许修改给定的链表。

 

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

 

**进阶：**
你是否可以不用额外空间解决此题？

## 思路

```
这一题使用双指针法 先找到环， 然后再将其中一个（如：fast） 置为 head 头结点， 再一步一步走，slow = slow.next, fast = fast.next; 知道 slow == fast , 这时候二者相遇节点就是环的入口。
以上面的 [3,2,0,-4] 其中 -4 -> 2
最开始 slow = fast = 3 , 然后开始走， slow 每次走一步， fast 每次走两步。
slow -> 2,  fast -> 0
slow -> 0,  fast -> 2
slow -> -4, fast -> -4  此时 相遇在环中的 -4 
将 fast = head 放到头结点， 即 fast -> 3, 然后开始走 slow和 fast都每次走一步 知道再次相遇
slow -> -4, fast -> 3
slow -> 2， fast -> 2   相遇 返回 fast即是答案

时间复杂度度 O(m + n)  m 表示链表的长度， n 表示 到相遇节点的长度 整体而言 O(n)
空间复杂度 O(1)
```



## 代码

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
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
```

