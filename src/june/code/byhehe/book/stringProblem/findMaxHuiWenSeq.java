package june.code.byhehe.book.stringProblem;

/**
 * 判断最长回文串
 */
public class findMaxHuiWenSeq {
    public static void main(String[] args) {
        String s = "aca";
        int len = s.length();
        String res="";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length()?res:s1;
            res = res.length() > s2.length()?res:s2;

        }
        System.out.println(res);
    }
    public static String palindrome(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        System.out.println(l+" "+r);
        return r-l ==1?s.substring(l,r): s.substring(l+1, r);
    }

}
