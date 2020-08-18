#### [78. 子集](https://leetcode-cn.com/problems/subsets/)

难度中等496

给定一组**不含重复元素**的整数数组 *nums*，返回该数组所有可能的子集（幂集）。

**说明：**解集不能包含重复的子集。

**示例:**

```
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

## 这里采用 回溯算法

```java
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();     
        if(nums.length>0)
            backTracking(nums, 0, res, list);
        return res;
    }
    public void backTracking(int []nums, int pos,List<List<Integer>> res, LinkedList<Integer> list){
        if(!res.contains(list)){  // 这里可以不做判断是因为 下面的for循环里复制做了越界限制
            // 判断终止条件
            res.add(new LinkedList(list));  // 这里采用 开辟新的空间 数据副本放入 
        }
        //if(pos==nums.length)  // 这里也是进行辅助判断
        //    return;
        // 进行选择
        for(int i = pos; i < nums.length ; i++){
            if(list.contains(nums[i]))  // 去重 
                continue;
            
                list.add(nums[i]);  // 如果没有出现过 则作为答案添加进去
                backTracking(nums, i+1, res, list);  
                // 解释 这里 是重点
            	// backTracking(nums, i+1, res, list);  最开始这里才用的是 这样
            	// 会出现[3,2]这样的值 但是 每出现一个值 规定 只能向后找 
           		// 比如[2]  -- [2,3] 是对的 [2,1]就是错误的。
                list.removeLast();
            
        }
        
    }
}
```

### 链表换成 ArrayList

```java
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // for(int ele:nums)
        //     list.add(ele);
        if(nums.length>0)
            backTracking(nums, 0, res, list);
        return res;
    }
    public void backTracking(int []nums, int pos,List<List<Integer>> res, List<Integer> list){
        if(!res.contains(list)){
            // 判断终止条件
            res.add(new ArrayList(list));
            
        }
        // if(pos==nums.length)
        //     return;
        // 进行选择
        for(int i = pos; i < nums.length ; i++){
            if(list.contains(nums[i]))
                continue;
            
                list.add(0,nums[i]);
                backTracking(nums, i+1, res, list);  
                // 解释 这里
                list.remove(0);
            
        }
        
    }
}
```

