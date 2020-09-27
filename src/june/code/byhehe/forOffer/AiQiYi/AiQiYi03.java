package june.code.byhehe.forOffer.AiQiYi;

import java.util.*;
public class AiQiYi03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splits = sc.nextLine().split(" ");
        int[] nums = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
//            System.out.print(splits[i]+" ");
            nums[i] = Integer.valueOf(splits[i]);
        }

        AiQi03 aq03 = new AiQi03();
//        System.out.println(aq03.getResThreeSum(nums));
        List<List<Integer>> resThreeSum = aq03.getResThreeSum(nums);
        for(List<Integer> res:resThreeSum){
            for (int i = 0; i < res.size(); i++) {
                if(i != res.size()-1)
                    System.out.print(res.get(i)+" ");
                else
                    System.out.print(res.get(i));
            }
            System.out.println();
        }

    }
}

class AiQi03{
    public List<List<Integer>> getResThreeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(nums == null || n == 0)
            return res;
        // 排序 关键
        Arrays.sort(nums);

        for(int first = 0; first < n; ++ first){
            // 首先 不能重复
            if(first > 0 && nums[first-1] == nums[first])
                continue;
            int third = n - 1;  // 放在这里每次first 一块更新
            int target = -nums[first];
            for(int second = first+1; second < n; ++second){
                if(second>first+1 && nums[second-1] == nums[second])
                    continue;
//                if(second < third && nums[second] + nums[third] > target)
//                    continue;
                // 可能会出现 2 2 2 2 跳过
                while (second < third && nums[second] + nums[third] > target)
                    third--;
                // break
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
