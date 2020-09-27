package june.code.byhehe.code;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class LeetCode78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res,list, 0, nums);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> list, int start, int [] num){
        if(!res.contains(list) && start<=num.length){
            // 这里不能直接添加， 因为这个 list 其他人也会用 我们考虑新开辟一个对象使用
            res.add(new ArrayList<>(list));
            // 注意 这里不能 return 不然 就是只有一个 [] 因为一开始入口就满足 所以需要移除return
            // 让他自己判断完所有条件 🙅剪枝
//            return;
        }

        for (int i = start; i < num.length; i++) {
            // 原题 审题发现 不包含重复元素
            if(list.contains(num[i]))
                continue;
            list.add(num[i]);
            dfs(res, list, i+1, num);
            list.remove(list.size()-1);
            /*
            上面 它是这样的 最开始 list = []
            然后 进来 i = 0, 此时 list = [1], 然后 带着 list = [1] 去遍历，
            走到后面 res = [[],[1]] , 然后 i = start = 1, 带入， 判断list中不存在2
            list = [1,2]
            同样的操作 带着进入dfs 下一轮操作中。
            最后 开始回溯， 即 移除元素。
            list = [1] 移除， 然后开始for 循环 的下一轮，
            此时 list = [], i == 1
            list = [2] 重复上面操作
             */
        }

    }

}
