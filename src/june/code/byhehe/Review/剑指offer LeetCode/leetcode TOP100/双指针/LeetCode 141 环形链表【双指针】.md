#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

难度简单573

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

 

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

 

**进阶：**

你能用 *O(1)*（即，常量）内存解决此问题吗？



## 思路

```
这是一道 经典的 双指针法，使用快慢指针解决问题。
1. 首先定义一个快指针，和慢指针
2. 快指针每次走两步，慢指针每次走一步。
3. 如果链表中有环，那快慢指针一定会相遇， 否则 会停止在 快指针 为 null 或者快指针.next 为null。

时间复杂度 O(m)  m为链表长度
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
    // 这里进行判断 fast 和 slow 不在同一起点 可以先判断再走判断 
    public boolean hasCycle2(ListNode head) {
        // 使用双指针法 又叫做 快慢指针
        if(head==null)return false;
        if(head.next == head) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            if(fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    
    // 这里进行判断 fast 和 slow 同一起点 需要先走再判断 不然 刚开始就判断 肯定失效
    public boolean hasCycle(ListNode head) {
        // 使用双指针法 又叫做 快慢指针
        if(head==null)return false;
        if(head.next == head) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
```

