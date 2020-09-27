package june.code.byhehe.utils;
public class Test07{
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(s1));
        System.out.println(s1.toLowerCase());
        System.out.println(s.isPalindrome("amanaplanacanalpanama"));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if((ch<='0' && ch>='9') || (ch >='a' && ch <= 'z') ||(ch >='A' && ch <= 'Z'))
                sb.append(ch);
        }
        //System.out.println(sb.toString());
        int len = sb.length();  // 这个要用罪孽处理后的结果
//        System.out.println("len: "+len);
        if(len % 2 == 0){
            return jdugePalind(sb.toString(), len/2-1, len/2 );
        }else{
            return jdugePalind(sb.toString(), len/2, len/2);
        }

    }

    public boolean jdugePalind(String s, int left, int right){
        while(left>=0&&right <s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right++;
        }
        return left < 0?true:false;
    }
}
