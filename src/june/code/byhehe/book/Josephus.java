package june.code.byhehe.book;

import june.code.byhehe.utils.ListNode;

/**
 * 约瑟夫环
 * N 个人站成一圈， 进行报数， 每当报到 m 的人就退出，然后从他后面的那个重新`从 1 开始报数
 * 知道剩下最后一个人 就是 活着的那个。
 * （最后 找到这个活着的 让他自己成一个环。）
 */
public class Josephus {
    public ListNode josephusKill2(ListNode head, int m){
        // 判断异常条件
        if(head == null || head.next == head || m < 1) {
            return head;
        }

        ListNode cur = head.next;
        int tmp = 1;  // tmp -> list size
        // 开始统计链表的长度 时间复杂度 O(n)
        while(cur != null){
            tmp++;
            cur = cur.next;
        }
        // 计算第几个节点活着
//        tmp =
        // 然后 找到这个节点
        while(--tmp != 0){
            head = head.next;
        }
        // 找到后 让他自己成环
        head = head.next;
        return head;
    }

    /**
     *
     * @param i 表示当前这个数的编号 1 2 3 4 5....
     * @param m 表示报到这个数 要自杀 。 比如 3
     * @return 活着的编号 即 最开始 排成一圈 时的老编号 不断使用新编号进行计算
     */
    public int getLive(int i, int m){
        // 当 只剩下一个人的时候 他自己编号就是 1
        // 注意 老编号 是不断利用新编号进行计算的 老编号 就是我们最后要求的
        // 公式 老编号 = （新编号 + m-1） % i + 1  这里的 i 为节点数
        if(i == 1){
            return 1;
        }

        return (getLive(i-1, m) + m - 1) % i + 1;
    }
}
