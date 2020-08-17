package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ37 {
//    public int[] nums
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(getRobbits(sc.nextInt()));
        }
    }

    public static int getRobbits(int month){
        if(month < 3){
            return 1;
        }
        if(month == 3)
            return 2;
        return getRobbits(month-1)+getRobbits(month-2);
    }
}
