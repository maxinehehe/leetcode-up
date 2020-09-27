package june.code.byhehe.forOffer.HW;

public class HW03 {
    public static void main(String[] args) {
        int[] nums = {11,1,2,3,4,5};
        int s = 11;
        System.out.println(minSubArrayLen(11, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 0;
            boolean flag = true;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] == s) {
                    flag = false;
                    continue;

                }

                sum += nums[j];
                count++;
                System.out.println(nums[j] +" -  "+sum+" - "+count);
                if(sum >= s)
                    break;


            }
            System.out.println("比较的 "+ minValue+" - "+count);
            if(flag && sum >= s)
                minValue = Math.min(minValue, count);

        }
        return minValue;

    }
}
