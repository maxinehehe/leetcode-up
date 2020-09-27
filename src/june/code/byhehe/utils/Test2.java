package june.code.byhehe.utils;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

    public static void main(String[] args)  {
        String s = "a good   example";
        char[] chars = {'0','0','3'};
        System.out.println(Integer.valueOf(String.valueOf(chars)));
//        System.out.println(s.length());
//        System.out.println(reverseWords(s));
    }

    public static int compareVersion(String s1, String s2){
        if(s1==null && s2 == null)
            return 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int i = 0, j = 0;
        while (i < chars1.length || j < chars2.length){
            // 找到一个起点 然后往后找一段
            int x = i, y = j;
            while (x < chars1.length && chars1[x]!='.') x++;
            while (y < chars2.length && chars2[y]!='.') y++;
            // 比较
            int a = i == x ? 0 : Integer.valueOf(s1.substring(i, x));
            int b = j == y ? 0 : Integer.valueOf(s2.substring(j, y));

            if(a > b) return 1;
            if(a < b) return -1;
            // 更新 i,j  此时 x 和 y 是 '.'
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }



    public static String reverseWords(String s) {
        int k = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){
            // 空格
            while(i < chars.length && chars[i]==' ') i++;
            if(i == chars.length) break;
            int j = i;
            while(j < chars.length && chars[j] != ' ') j++;
            reverse(chars, i, j-1);
            // 加空格
            if(k!=0) chars[k++] = ' ';
            while(i<j)chars[k++] = chars[i++];
        }
        // 擦除 k 后面空格
        chars = Arrays.copyOf(chars, k);
        reverse(chars, 0, k-1);

        return String.valueOf(chars);
    }

    public  static void reverse(char[] chars, int i, int j){
//        System.out.println("i: "+i+" j: "+j);
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }



    public static ArrayList<String> getRes(String s){
        if(s == null || s.length() == 0)
            return null;
        ArrayList<String> list = new ArrayList<>();
        String T = "";
        char[] chars = s.toCharArray();
        int l = 0;
        while (l < chars.length) {
            if ('0' <= chars[l] && chars[l] <= '9') {
                T += chars[l];
            } else {
                if (!"".equals(T) && T.length() == 4) {
                    list.add(T);
                }
                T = "";
            }
            if(l == chars.length - 1 && !"".equals(T) && T.length() == 4){
                list.add(T);
                T = "";
            }

            l++;
        }
        return list;
    }
}
