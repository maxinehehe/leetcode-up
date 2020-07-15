package june.code.byhehe.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LeetCode128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        // 使用 哈希表 hashset
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums)
            numSet.add(num);

        int longsetVal = 0;
        // 在 set 里面走 不要在 nums 中走 因为 遍历操作目标变了
        for(int num:numSet){
            // 我们考虑从小的往上判断， 比如 4 3 2 1 这样 在 4 3 2 的时候只需要跳过就好了
            if(!numSet.contains(num - 1)){
                // 如果不包含 才开始向上判断 从 1 开始
                int curNum = num;
                int curVal = 1;
                while(numSet.contains(curNum+1)){
                    curNum += 1;
                    curVal += 1;
                }
                longsetVal = Math.max(longsetVal, curVal);
            }

        }
        return longsetVal;
    }
}
