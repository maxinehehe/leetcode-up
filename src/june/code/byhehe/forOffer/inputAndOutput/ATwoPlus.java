package june.code.byhehe.forOffer.inputAndOutput;

import java.util.Scanner;

public class ATwoPlus {
    public static void main(String[] args) {
        int a = 0, b = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
