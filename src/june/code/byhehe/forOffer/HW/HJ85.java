package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

/**
 * 华为HJ85
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * （注意：记得加上while处理多个测试用例）
 */
public class HJ85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine().trim();
            // 以 i 和 i+1 为中心扩展
            String res="";
            for (int i = 0; i < s.length(); i++) {
                String s1 = getHuiWen(s, i, i);
                String s2 = getHuiWen(s, i, i+1);
                res = res.length()>s1.length()?res:s1;
                res = res.length()>s2.length()?res:s2;

            }
            System.out.println(res.length());
        }
    }

    public static String getHuiWen(String s, int l, int r){
        while (l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return (r-l) == 1?s.substring(l,r):s.substring(l+1, r);
    }
}
