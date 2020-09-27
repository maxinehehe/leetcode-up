package june.code.byhehe.utils;

import java.util.HashSet;

public class NewTest002 {
    public static void main(String[] args) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode node1 = new ListNode(1);
        hashSet.add(node1);
        ListNode node2 = new ListNode(1);
        System.out.println(hashSet.contains(node2));
    }
}
