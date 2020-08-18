#### [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

难度困难323

给定一个数组 *nums*，有一个大小为 *k* 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 *k* 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

**进阶：**

你能在线性时间复杂度内解决此题吗？

 

**示例:**

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

 

**提示：**

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`

## 思路

```java
使用 双指针 + 优先级队列 【优先级队列 采用降序排序】
    窗口不断往后走， 每一次只判断 排在队头的元素都是当前窗口最大的。
 即 设置对列长度为 k [窗口大小]， 窗口向后滑动。
 时间复杂度： O(n) * 2*O(logn) = O(n^2)   优先级队列 出队 入队 复杂度都是 O(logn)
```

## 代码

```java
import java.util.*;
class Solution {
    // 使用滑动窗口 + 优先级队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;  // 降序排列 即 使用 poll 会 出队列 4 3 2 1这样子
            }
        }); // 长度 k
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0;
        int resIdx = 0;
        while (right <= k - 1){
            priQueue.add(nums[right++]);
        }
        //priQueue.add(nums[right]);
        while (right < nums.length){
            // 向右移动一 那么 队列中的数字需要排出
            // 首先现将结果放入结果数组中
            res[resIdx++] = priQueue.peek().intValue();
            priQueue.remove(nums[left++]);
            priQueue.add(nums[right++]);
        }
        res[resIdx] = priQueue.peek().intValue();
        return res;
    }
}
```



## 双向队列的做法

```

```

