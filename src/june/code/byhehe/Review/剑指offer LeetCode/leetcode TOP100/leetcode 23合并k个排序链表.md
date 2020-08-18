# leetcode 23 合并k个排序链表

#### [23. 合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

难度困难545

合并 *k* 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

**示例:**

```
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
```



## 思路：

```
第一种 暴力法：
A.使用数组保存 所有节点的 值（int类型）  time:O(n)  space:O(n)
B.进行排序 O(log_n)
C.遍历进行连接所有节点 
note:只在一处创建节点就行了

第二种 优先队列法
A. 遍历保存 每个链表的头结点【如果是int型会默认按从小到大排序，可以重写Comparator】
B.使用完一个头结点出队后链入链表，就判断该头结点下一个元素是否为空，不空的话则继续入队参与排队。
```

### 代码 1 暴力法

```java
public ListNode mergeKLists2(ListNode[] lists) {
        // 暴力方法 使用数组存储 然后再进行恢复 空间与时间都会花费
        // 时间 遍历一遍数组 O(n) 排序O(log_n) 再次遍历连接上 O(n) 总共 O(nlog_n)
        // 空间 存储所有节点 O(n)
        List<ListNode> vals = new ArrayList<>();
        ListNode head,point;
        head = point = new ListNode(0);
        for(ListNode list:lists){
            while(list!=null){
                ListNode node = new ListNode(list.val);
                vals.add(node);
                list = list.next;
            }
        }
        // 开始排序
        Collections.sort(vals, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 开始链接
        Iterator it = vals.iterator();
        while (it.hasNext()){
            point.next = (ListNode) it.next();
            point = point.next;
        }
        return head.next;
    }
```

### 代码 2 优先队列法

```java
public ListNode mergeKLists(ListNode[] lists) {
    // 使用优先队列 进行操作  如果保存的是节点就进行重写值
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode list:lists){
            if(list!=null){
                priorityQueue.add(list);  // 添加头结点
            }
        }
        // 开始构建
        ListNode head, point;
        head = point = new ListNode(0);
        while(!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            point.next = new ListNode(node.val);
            point = point.next;
            node = node.next;
            if(node != null)
                priorityQueue.add(node);
        }
        return head.next;
    }
```

