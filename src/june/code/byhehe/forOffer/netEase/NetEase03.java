package june.code.byhehe.forOffer.netEase;

import java.util.Arrays;
import java.util.Scanner;

public class NetEase03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyNE003 myNE003 = new MyNE003();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");

            long[] nums = new long[s2.length];
            for (int i = 0; i < s2.length; i++) {
                nums[i] = Long.valueOf(s2[i]);
//                System.out.print(nums[i]+" ");
            }
            System.out.println(myNE003.getRes(nums));
        }
    }
}

class MyNE003{
    public long getRes(long[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
//        System.out.println(sum);
        for (int i = 0; i < n; i++) {
            if(sum % 7 == 0 && sum != 0 && i!= 0)
                return sum;
            else
                sum -= nums[i];
//            System.out.println(sum);
        }

        return -1;
    }
}
