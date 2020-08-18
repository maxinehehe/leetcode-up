#### [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)

难度中等502

给定一个包含 *n* + 1 个整数的数组 *nums*，其数字都在 1 到 *n* 之间（包括 1 和 *n*），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

**示例 1:**

```
输入: [1,3,4,2,2]
输出: 2
```

**示例 2:**

```
输入: [3,1,3,4,2]
输出: 3
```

**说明：**

1. **不能**更改原数组（假设数组是只读的）。
2. 只能使用额外的 *O*(1) 的空间。
3. 时间复杂度小于 *O*(*n*2) 。
4. 数组中只有一个重复的数字，但它可能不止重复出现一次。



# 第一种思路

```
由于 数字长度是 N+1 而且其中所有的数字 都是介于 1~n 包括1和n ，只有一个重复的，那么 +1 就是这个重复的。
因此可以使用各回各坑 ，即 索引对应的下标的就回到 自己应该待在的索引位置，如果当前索引位置和自己一样就说明找到了重复值。

```

# 代码实现

```java
public static int findDuplicate(int[] nums) {
        /**
         思路： 由于数字都是 1~n 之间 那么 n+1 长度 这个 +1 就一定是多出来的 采用调位置的方法
         */
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(i+1 != nums[i]){
                if(nums[i] == nums[nums[i]-1])
                    return nums[i];
                else{
                    int temp = nums[i];
                    int index = nums[i]-1;
                    nums[i] = nums[nums[i]-1];
                    nums[index] = temp;
                }
            }
        }
        return -1;

    }
```



# 第二种·思路

```
根据题意可以发现 比如给定下面的数
value: [1 3 4 2 3]
index:  0 1 2 3 4
上面是数组,下面是对应的索引
其实可以看成是链表，1 -> 3 -> 2 -> 4 -> 3(成环步骤)
其中这里不再是使用next指向下一个 而是使用 当前数作为下一步的 指针
nums[nums[curr]] , 定义两个快慢指针。
```

# 第二种思路代码实现

```java
public static int findDuplicate2(int[] nums) {
        // 官方第二种解法
        // Find the intersection point of the two runners.
    	// 定义两个快慢指针 初始指向nums[0]
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            // 慢指针 每次只走一个 下标位 一次下标往后走一位
            tortoise = nums[tortoise]; 
            // 快指针 每次走两步 咋走呢？就是通过下标的下标 走两步
            hare = nums[nums[hare]];
            // 当走到 两个指针相遇 就表示 已经在环中相遇
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
       // 相遇之后呢， 可以让其中一个回到 nums[0] 相当于链表的头部，
       // 另一个呢 则保持在相遇的位置，只要找到环的入口 就相当于找到了 这个唯一重复的元素
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
// 很巧妙的一题 巧用 链表中有环的 思想
```

# 其他方法

```
一. 可以进行排序进行查找 
Arrays.sort(nums);
然后判断 nums[i] == nums[i-1] 不。
时间复杂度：O(logn)  空间复杂度 O(1) 当然使用其他空间的话 可能是 O(n)
二. 使用集合 set
set可以保证元素不重复
那么可以直接使用set进行判断，当前元素若不存在于 set 中，就添加进去，如果存在就 返回该值，此元素正式要找的。
```

