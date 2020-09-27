package june.code.byhehe.forOffer.XiaoHongShu;

import java.util.Arrays;

public class Testmy {
    public static void main(String[] args) {
//
        Integer i = 50000;
        Integer k = 50000;
        System.out.println((i/1000==k/1000)+","+(i==k));
    }

    public static String getLen(String s){
        int maxLen = 0;
        int len = s.length();
        String res = "";
        if(len <= 1){
            return "";
        }

        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = s.substring(i, len);
        }

        Arrays.sort(strs);

        for (int i = 0; i < len - 1; i++) {
            int temp = handle(strs[i], strs[i+1]);
            if(temp > maxLen){
                maxLen = temp;
                res = strs[i].substring(0, maxLen);
            }
        }

        return res;
    }

    public static int handle(String s1, String s2){
        if(s1.length() == 0||s2.length() == 0)
            return 0;
        int n = 0;
        while (n < s1.length() && n < s2.length() && s1.charAt(n) == s2.charAt(n))
            n++;
        return n;

    }



}

//class
