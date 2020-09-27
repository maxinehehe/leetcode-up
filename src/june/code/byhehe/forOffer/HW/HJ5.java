package june.code.byhehe.forOffer.HW;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 16 进制转 10进制
 *
 */
public class HJ5 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(){
            {
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('A', 10);
                put('B', 11);
                put('C', 12);
                put('D', 13);
                put('E', 14);
                put('F', 15);
            }
        };
        Scanner sc  = new Scanner(System.in);

        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            int sum = 0;
            for (int i = 2; i < chars.length; i++) {
                sum += map.get(chars[i])*(Math.pow(16,chars.length - i - 1));
            }
            System.out.println(sum);
        }
    }
}
