package june.code.byhehe.utils;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String s1 = new String("hello");
        map.put(s1, 500);
        String s2 = new String("hello");
        System.out.println(map.get(s2));
    }
}
