package june.code.byhehe.utils;


public class Test {
    public static void main(String[] args) {
        MySloutionForAWei mySloutionForAWei = new MySloutionForAWei();
        int res = mySloutionForAWei.getRes("abcbxbstyxz");//"abcbxbstyxz");
        System.out.println(res);
    }
}

class MySloutionForAWei{
    public int getRes(String s){
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length+1];
        // 初始化
        for (int i = 0; i <= chars.length; i++) {
            dp[i] = i+1;
        }

        for (int i = 1; i < chars.length; i++) {
            for (int j = 1; j < i; j++) {
                if(chars[i] == chars[j]){
                    dp[i] = dp[j-1]+1;
//                            Math.min(
//                            dp[j-1]+1,
//                            dp[i-1]+1
//                    );
                    break;
                }else {
                    dp[i] = Math.min(dp[i-1]+1,dp[i]);
                }
            }
        }

        return dp[chars.length-1];
    }
}