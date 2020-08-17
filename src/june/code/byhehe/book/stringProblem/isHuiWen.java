package june.code.byhehe.book.stringProblem;

import java.util.Scanner;

/**
 * 判断是否是回文字符串
 */
public class isHuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(judgeHuiWen2(str));
    }

    // 使用DP判断
    public static boolean judgeHuiWen(String str){
        // 从后向前判断
        char[] chars = str.toCharArray();
        int len = chars.length;

        // dp[i][j] 表示 str[i...j]是否为回文字符串
        boolean[][] dp = new boolean[len][len];

        /**
         * 由于：状态转移方程：
         * p[i][j] 为true的三种情况：
         * 1、str[i...j] 由 1 个字符组成
         * 2、str[i..j] 由两个字符组成， 且两个字符相等。
         * 3、str[i+1...j-1是回文串，即 p[i+1][j-1] = true
         * 且str[i] == str[j] 即 str[i...j]收首尾两个字符相等
         */
        // 从后向前判断
        for (int i = len - 1; i >= 0; i--) {
            // i 控制整体从后往前走
            // 即控制从 i 到 len 这段范围 从前往后走
            for (int j = i; j < len; j++) {
                if(chars[i] == chars[j] &&
                        (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
//        System.out.println(dp[0][len-1]+" - "+dp[len-1][len-1]);

        return dp[0][len-1];
    }

    public static boolean judgeHuiWen2(String str){
        int len = str.length();
        for (int i = 0; i < len; i++) {
            // 从 0 开始的 如果不 -1  刚开始就是 charAt(len) 直接越界
//            System.out.println(str.charAt(i)+" - "+str.charAt(len-i-1));
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
