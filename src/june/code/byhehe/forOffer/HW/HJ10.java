package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(getRes(s));
        }

    }
    public static int getRes(String s){
        char[] map = new char[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] = 1;
        }
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            sum += map[i];
        }
        return sum;
    }
}
