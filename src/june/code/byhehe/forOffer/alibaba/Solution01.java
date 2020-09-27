package june.code.byhehe.forOffer.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] num;
        int n = 0;
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(getRes(num));

        }
    }

    public static int getRes(int[] num){
        if(num.length == 1)
            return num[0];

        Arrays.sort(num);
        int carry = num[0];
        int sum = 0;
        for (int i = num.length - 1; i >= 1; i--) {
            sum += num[i];
        }
        sum += (num.length - 2)*carry;

        return sum;
    }
}

/**
 * 2
 * 4
 * 2 10 12 11
 * 4
 * 2 3 7 8
 */
