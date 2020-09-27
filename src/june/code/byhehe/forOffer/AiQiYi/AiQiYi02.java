package june.code.byhehe.forOffer.AiQiYi;

import june.code.byhehe.utils.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

public class AiQiYi02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splits = sc.nextLine().split(" ");
        int[] nums = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
//            System.out.print(splits[i]+" ");
            nums[i] = Integer.valueOf(splits[i]);
        }
        AiQi02 aq02 = new AiQi02();
        System.out.println(aq02.getRes(nums));
    }
}

class AiQi02{
    public int getRes(int[] nums){
        int n = nums.length;
        if(nums == null || n == 0)
            return 0;
        Arrays.sort(nums);
        return nums[n/2];
    }
}

class JQXinLang{
//    public Map<>

}