package june.code.byhehe.forOffer.star2020;

import java.util.*;
public class ThreeSum {
}

class ThreeSumHelper{
    public static class Test{
        public static void main(String[] args) {
            ThreeSumHelper tsh = new ThreeSumHelper();
            int [] nums = {-1, 0, 1, 2, -1, -4};
            System.out.println(tsh.threeSum(nums));
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // 两重循环 第三重 直接并列解决
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0)
            return res;
//        int first = 0;
        // 写在这里不对
        // 每一次 first 改变 third 都要重新从后面开始
//        int third = n-1;
        // 记住先排序！！！
        Arrays.sort(nums);
        for(int first=0; first < n; first++){
            // 判断一下 题目要求值不重复
            // 剪
            if(first > 0 && nums[first-1] == nums[first])
                continue;
            // target 用于 后面 first + second + third 处理
            int third = n-1;
            int target = -nums[first];
            for(int second = first+1; second < n; ++second){
                // 同样判断 second 是否和first 一样
//                if(second>first && nums[second]==nums[first])
//                    continue;
                // 需要和上一次不同
                if(second>first+1 && nums[second]==nums[second-1])
                    continue;
                // 再判断 三数的情况
                while (third>second && nums[second]+nums[third] > target)
                    third--;
                // 如果 第二个数 和 第三个数 相等 那么 不可能在有结果了 直接break
//                if(nums[second] == nums[third])
//                    break;
                // 如果 second 和 third 重合 就说明 需要break了
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                // 如果相等
                if(second == third)
                    break;
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }

            }
        }

        return res;
    }
}
