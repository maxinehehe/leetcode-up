package june.code.byhehe.book.GoldBook.chapter_string;

import java.util.Scanner;

public class CM2StrReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StrReverse sr = new StrReverse();
        String iniString = sc.nextLine();
        while (sc.hasNext()){
            System.out.println(sr.reverseString(iniString));
        }
    }
}

class StrReverse{
    // 方法一、 使用 StringBuilder 进行翻转
    public String reverseString(String iniString) {
        // write code here
        StringBuilder sb = new StringBuilder(iniString);
        return sb.reverse().toString();
    }

    // 方法二、使用 char 数组 进行翻转
    public String reverseString2(String iniString) {
        char[] chars = iniString.toCharArray();
        int left = 0, right = chars.length-1;
        while (left < right){
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return chars.toString();
    }
    // 使用 二分法 进行反转  不断二分直至 最小
    public String reverseString3(String s) {
        int length = s.length();
        if(length <= 1)
            return s;
        // 分割成两部分
        String left = s.substring(0, length/2);
        String right = s.substring(length/2, length);
        // 顺序不能颠倒 右 + 左
        return reverseString3(right) + reverseString3(left);
    }

}
