package june.code.byhehe.forOffer.meituan;

import java.util.Scanner;
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            if(isvalid(s))
                System.out.println("Accept");
            else
                System.out.println("Wrong");
        }
    }
    public static boolean isvalid(String s){
        char[] chars = s.toCharArray();
        if(chars.length < 2 || !isChar(chars[0]))
            return false;
        int digitCount = 0;
        int charCount = 0;
//        System.out.println("--");
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(isChar(c))
                charCount++;
            else if(isDigit(c))
                digitCount++;
            else
                return false;
        }
        if(digitCount == 0 || charCount == 0)
            return false;
        else
            return true;
    }
    public static boolean isChar(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    public static boolean isDigit(char ch){
        return (ch >= '0' && ch <= '9');
    }
}