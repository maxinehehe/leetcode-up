# LeetCode 581 最短无序连续子数组

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

## 思路

```
这种情况 一个比较直观的想法就是， 需要找到 这样的子数组的 start索引 和 end索引
那么 先找最小的索引， 从右往左 找， 需要注意
例子：[2, 6, 4, 8, 10, 9, 15]   从右往左，
10 > 9 逆序 ， 10为最小索引（4）的值， 当前的最小值是 9， 继续往前走
8 < 10 不逆序， 此时最小索引仍是 10（4）， 但是当前最小值是 8， 继续往前走
4 < 8 不逆序， 同理。。。       10（4），                4， 继续往前走
6 > 4 逆序， 此时最小索引变更为 6（1） ， 当前最小值是 4， 继续往前走
2 < 6 不逆序， 此时最小索引为 6（1） ，当前最小值则变为 2结束。
可以看到 在逆序存在的情况下， min 最小值会在 逆序最小索引的左侧。
如果逆序索引 一直为初始值 那么就说明整体升序，直接返回0.

-----------------------------------------------------------------------------
然后 再找最大索引， 从左往右找，步骤基本同上。
。。。
```



## 代码

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
       if(nums == null || nums.length < 2) return 0;

        int minIdx = -1;
        int min = nums[nums.length - 1];
        // 记录 到最左边需要进行排序的 最小 下标
        // 也就是说 遍历过程中 右侧出现过的最小值 
        for (int i = nums.length - 2; i != -1 ; i--) {
            if(nums[i] > min){  // 5 , 4, 3    4 > 3 的就要进行变换
                minIdx = i;
            }else {  // 如果 数组整体升序 1 2 3 4 5 ， 那么 就会一直走 else 语句， 而 inIdx并不会更新
                 min = Math.min(nums[i], min);
            }
        }
        if(minIdx == -1) 
            return 0;  // 这里是整体升序 不需要再进行下面的流程了
        int max = nums[0];
        int maxIdx = -1;
        for(int i = 1; i!=nums.length; i++){
            if(nums[i]<max){
                maxIdx = i;
            }else { // 同理 如果 一直整体升序 就会一直走 else 语句 maxIdx不会更新
                max = Math.max(max, nums[i]);
            }
        }
        return maxIdx - minIdx + 1;
    }
}
```

