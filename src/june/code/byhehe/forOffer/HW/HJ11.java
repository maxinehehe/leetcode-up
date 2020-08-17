package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        s.trim();
        StringBuilder sb = new StringBuilder(s.trim());
        System.out.println(sb.reverse());
    }
}
