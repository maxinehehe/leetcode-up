package june.code.byhehe.book.GoldBook.chapter_string.bytedance;

import java.util.HashMap;
import java.util.Map;

// LRU 实现的精髓就是 哈希表 + 双向链表
public class LRUCacheAcheive {
    // 实现双向链表
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev; // 前指针
        DLinkedNode next; // 后指针
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    // 哈希表
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 定义大小 元素增加 他也会增加
    private int size;
    // 定义容量 超出就要执行 LRU
    private int cacpacity;
    // 定义一个 首尾 这样不用再去判断 边界是否存在
    private DLinkedNode head, tail;

    // 构造函数
    public LRUCacheAcheive(int cacpacity){
        this.size = 0;
        this.cacpacity = cacpacity;
        // 使用伪头部和伪首部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // get 操作 首先去 哈希表中判断当前节点存在吗 (通过key获取value 来判断存在吗）
    public int get(int key){
        // 首先判断该节点是否存在
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        // 如果key 存在， 那么就通过哈希表定位， 再移到头部
        moveToHead(node);
        return node.value;
    }

    // put 数据
    public void put(int key, int value){
        // 查看该节点是否存在
        DLinkedNode node = cache.get(key);
        if(node == null){
            // 如果key 不存在， 创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 然后把该节点添加到双向链表头结点
            addToHead(newNode);
            // 此时尺寸要+1
            size++;    // 关键别忘了
            // 此时需要判断 如果容量超过尺寸 要进行删除 尾部元素
            if(size > cacpacity){
                // 超出容量 删除尾巴元素
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else {
            // key 存在 通过哈希表更新值 在修改value， 并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 添加节点到头部
    private void addToHead(DLinkedNode node){
        // 先处理 node 的 prev 和 next
        node.prev = head;
        node.next = head.next;
        // 再处理 head next 节点的prev 和 head.next   不能先处理 head.next 不然 head.next.prev 就无法处理了
        head.next.prev = node;
        head.next = node;
    }

    // 移除一个节点
    private void removeNode(DLinkedNode node){
        // 移除 node 直接改变 node 的 前置指针 和 后置指针
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移到头结点
    private void moveToHead(DLinkedNode node){
        // 首先移从原本位置除该节点
        removeNode(node);
        // 然后将该节点添加到头结点
        addToHead(node);
    }

    // 移除末尾元素
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        // 使用移除节点函数
        removeNode(res);
        return res;
    }



    static class Test{
        public static void main(String[] args) {
            LRUCacheAcheive cache = new LRUCacheAcheive(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1));       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            System.out.println(cache.get(2));       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            System.out.println(cache.get(1));       // 返回 -1 (未找到)
            System.out.println(cache.get(3));       // 返回 3
            System.out.println(cache.get(4));       // 返回 4

        }
    }


}











