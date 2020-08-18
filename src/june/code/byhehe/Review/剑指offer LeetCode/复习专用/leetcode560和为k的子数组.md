## 复习

#### [560. 和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)

难度中等308

给定一个整数数组和一个整数 **k，**你需要找到该数组中和为 **k** 的连续的子数组的个数。

**示例 1 :**

```
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
```

**说明 :**

1. 数组的长度为 [1, 20,000]。
2. 数组中元素的范围是 [-1000, 1000] ，且整数 **k** 的范围是 [-1e7, 1e7]。

```java
// 这一类的题一般 先考虑 哈希表的做法 
/*
采用累积和的方法。
思路：     [3, 4, 7,  2, -3, 1]    k = 7
对应累积和  3, 7, 14, 16, 13, 14
减去k对应： -, 0, 7,  9,  6,  7
从上面的结果， 我们存储累积和， (key, value),其中 key 表示 累积和的值， value则是 累积和的出现次数。
并且对应减去 k 的值进行观察， 结果 对应的累加和存在的都符合条件。
即 上面 3 + 4 = 7，  对应的 sum - k == 7 - 7 == 0  [存在 (0,1) ]
再看 3 + 4 + 7 = 14 ， 对应的 sum - k == 7 [存在 (7,1)]  这里即 说明 7 对应的下标 1 和 14对应的 2 他俩之间的值 7 等于 k.再往下看一下。
再看 16， 16 - k == 9 这个并未发现在 哈希表中。 然后将它（9,1）放入到哈希表中。
再看 最后的 3+4+....+1 = 14  然后 sum - k == 7  7 这个累积和已经存在于哈希表中了， 所以 2（7） 到 5（1） 之间的和为 k(7) ,即 7+2-3+1 = 7
所以上面共 3 个符合条件的， 使用 count 进行计数。
*/
import java.util.*;
public int findCountAccSum(int[] nums, int k){
    if(nums.length == 0 || nums == null) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    // 首先 将 (0,1) 放入到 map 中， 初始条件
    map.put(0, 1);
    int count = 0, sum = 0;
    for(int i = 0; i < nums.length; i++){
        sum += nums[i];
        if(map.containsKey(sum-k))
            count += map.get(sum-k);
        map.put(sum, map.getOrDefault(sum,0) + 1);  // map.getOrDefault(key, 0);
    }
    return count;
}
```

