package june.code.byhehe.forOffer.HW;

import java.util.*;

public class HJ14 {
    public static void main(String[] args) {
//        TreeMap<String, Integer> tm = new TreeMap();
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < m; i++) {
//            String s = sc.nextLine();
//            tm.put(s, 1);
//        }
//        for(String key:tm.keySet())
//            System.out.println(key);


        List<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            list.add(s.trim());
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String s:list){
            System.out.println(s);
        }

    }
//    public static List<String> getRes(List<String> list){
//
//    }
//    public static List<String> getRes()
}
