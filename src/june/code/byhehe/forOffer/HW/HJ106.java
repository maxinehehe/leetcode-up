package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            System.out.println(sb.reverse().toString());
        }
    }
}
