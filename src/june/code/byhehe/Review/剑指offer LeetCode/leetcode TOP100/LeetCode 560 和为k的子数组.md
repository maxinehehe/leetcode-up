# LeetCode 560 和为 k 的子数组

#### [560. 和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)

难度中等307

给定一个整数数组和一个整数 **k，**你需要找到该数组中和为 **k** 的连续的子数组的个数。

**示例 1 :**

```
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
```

**说明 :**

1. 数组的长度为 [1, 20,000]。
2. 数组中元素的范围是 [-1000, 1000] ，且整数 **k** 的范围是 [-1e7, 1e7]。

## 思路

```
使用累加和解决。
对于 索引 i 和 j 之间的累积和，  如果累计总和，在索引 i 和 j 处相差 k，即 sum[i] - sum[j] = k,
sum[i]−sum[j]=k，则位于索引 i 和 j 之间的元素之和是 k。

因此， 只要在遍历的过程中 sum-k 存在于哈希表中就说明 ，比如 sum - k = sum_x, 就说明 sum_x 到 sum 之间的元素 累积和为 k ,
比如 [3,4,7,2,-3,1,4,2]  后面的 1+4+2 = 7
   那么 到1索引时， 13  + 1 + 4 + 2 = 20 
   也就是说 只要后的累积和 sum_i 减去 k 能够在哈希表中找到对应的key （sum_j），那么就说明 j 到 i 之间的累积和 为 k。
```



## 代码

```java
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

