package june.code.byhehe.forOffer.HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TT01 {
    public static void main(String[] args) {
        Map<String , List<String>> graph = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("ok");
        graph.put("abc", list);
    }
}
