package june.code.byhehe.forOffer.huaweimianshi;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HuaWei02 {
    //[-1,2,3,-1,4,2]
    // [-1,2,3,4]
    public static void main(String[] args) {
        Test t = new Test();
        int[] nums = {-1,2,2,2,3,4};
        Arrays.sort(nums);
        int res = t.removeNum(nums);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i]);
        }
//        System.out.println(res);

    }
}

class Test{
    // n
    public int removeNum(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;

        int p = 0, q = 1;
        while (q < nums.length){
            if(nums[p] != nums[q]){
                nums[p+1]  = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}



