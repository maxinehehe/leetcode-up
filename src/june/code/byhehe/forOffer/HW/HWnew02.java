package june.code.byhehe.forOffer.HW;

import java.util.*;

public class HWnew02 {
    public static void main(String[] args) {
        String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 3));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            lhm.put(s, lhm.getOrDefault(s, 0)+1);
        }
        // 这是一种初始化方式
//        List<Map.Entry<String, Integer>> list = new LinkedList<>();
//        Set<Map.Entry<String, Integer>> set = lhm.entrySet();
//        for(Map.Entry<String, Integer> next :set)
//            list.add(next);

        // 但这种更爽
        List<Map.Entry<String, Integer>> list = new LinkedList<>(lhm.entrySet());
        // 其实map.Entry 就是相等当与 把 map 拆成了一个一个 的 map 对象

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                if(o1.getValue().intValue() == o2.getValue().intValue())
                    return  (o1.getKey().compareTo(o2.getKey()));
                else
                    return -(o1.getValue().intValue() - o2.getValue().intValue());
            }
        });

        System.out.println(list);
        List<String> res = new LinkedList<>();

        Iterator it = list.iterator();
        while (k!=0 && it.hasNext()){
            Map.Entry<String, Integer> obj  = (Map.Entry<String, Integer>) it.next();
            String s = String.valueOf(obj.getKey());
//            System.out.println(s+ " --");
            res.add(s);
            k--;
        }

        return res;

    }
}
