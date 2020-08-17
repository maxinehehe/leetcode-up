package june.code.byhehe.book.stringProblem;

import java.util.Scanner;

public class isBianXingCi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        String s1 = sc.next();
        String s2 = sc.next();
        if(judge(s1,s2) == true){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

    public static boolean judge(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        //if(chars1.length != chars2.length)
        //  return false;

        int[] map = new int[256];

        for (int i = 0; i < chars1.length; i++) {
            map[chars1[i]] ++;
        }
        for (int i = 0; i < chars2.length; i++) {
            if(map[chars2[i]] -- == 0) // 或者 map[chars2[i]-- < 0]
                return false;
        }
        return true;
    }
}
