package june.code.byhehe.book.stringProblem;

import java.util.Scanner;

/**
 * 判断是否互为 旋转词   比如
 * 123
 * 和
 * 231、312、132都互为旋转词
 *  思路：
 *  如果 a b长度不等 一定不是互为旋转词
 *  如果长度相等，
 *  那么 b 一定包含在 String aa = a+a 中，
 */
public class isXuanZhuanCi {
    public static void main(String[] args) {
//        System.out.println("abcdedf".contains("cde"));
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
//        sc.nextLine()
        String s1 = sc.next();
        String s2 = sc.next();
        if(isXuanZhuanCi(s1, s2)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
    public static boolean isXuanZhuanCi(String a, String b){
        if(a == null || b == null || a.length() != b.length() ){
            return false;
        }
        String aa = a + a;
        if(aa.contains(b))
            return true;
        else
            return false;
    }

    // 判断 b 是否在 a 中
    public static boolean isContain(String aa, String b){
        char[] chars1 = aa.toCharArray();
        char[] chars2 = b.toCharArray();

        for (int i = 0; i < chars1.length; i++) {

        }
        return false;
    }
}
