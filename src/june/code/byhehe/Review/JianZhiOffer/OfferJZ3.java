package june.code.byhehe.Review.JianZhiOffer;

import june.code.byhehe.utils.ListNode;

import java.util.*;
public class OfferJZ3 {
}

class JZ3{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null)
            return list;
        while (listNode!=null){
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
