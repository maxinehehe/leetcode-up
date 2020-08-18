## 练习 复习

#### [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)

难度简单288

给定一个整数数组，你需要寻找一个**连续的子数组**，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是**最短**的，请输出它的长度。

**示例 1:**

```
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
```

**说明 :**

1. 输入的数组长度范围在 [1, 10,000]。
2. 输入的数组可能包含**重复**元素 ，所以**升序**的意思是**<=。**



```java
// 在 有序数组中 升序数组中 找最小的一段降序数组  
// 方法： 采用 找到两侧的 minIndex 和 maxIndex

public int find unionSortSubarray(int[] nums, int k){
    // 先判断 特殊情况
    if(nums == null || nums.length == 0) return 0;
    // 下面定义 左边最小的值 右边最大的值 
    int minIndex = -1, maxIndex = -1;
    int min = nums[nums.length - 1];
    for(int i = nums.length - 2; i != -1; i--){
        if(nums[i] > min){
            minIndex = i;
        }else{
            min = Math.min(min, nums[i]);
        }
    }
    if(minIndex == -1)
        return 0;
    int max = nums[0];
    for(int i = 1; i != nums.length; i++){
        if(nums[i] < max){
            maxIndex = i;
        }else{
            max = Math.min(max, nums[i]);
        }
    }
    return maxIndex - minIndex + 1;
}
```

