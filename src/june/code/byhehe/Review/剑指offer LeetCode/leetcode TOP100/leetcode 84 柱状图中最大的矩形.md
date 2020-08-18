#### [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

难度困难551

给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram.png)

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 `[2,1,5,6,2,3]`。

 

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram_area.png)

图中阴影部分为所能勾勒出的最大矩形面积，其面积为 `10` 个单位。

 

**示例:**

```
输入: [2,1,5,6,2,3]
输出: 10
```



## 思路

```
使用 栈。
样例参考下图。

```



![leetcode 84 柱状图中最大的矩形2](D:\hehe\剑指offer\leetcode TOP100\leetcode 84 柱状图中最大的矩形2.jpg)



![leetcode 84 柱状图中最大的矩形](D:\hehe\剑指offer\leetcode TOP100\leetcode 84 柱状图中最大的矩形.jpg)



## 代码

```java
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 使用栈
        return largestRectangleArea1(heights);
    }

    public int largestRectangleArea1(int[] heights) {
        // 使用栈 保存下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // 以-1为底判断
        int maxArea = 0; // 当前最大面积
        for (int i = 0; i < heights.length ; i++) {
            // 判断栈底部数据是否已经全部出栈
            // 下一个数的到来的数据 是否形成 降序 如果是的话就行处理 否则直接入栈
            while (stack.peek()!=-1 && heights[stack.peek()] >= heights[i])
                // 形成降序的话 就出栈 进行计算 当前元素与栈中满足出栈条件的元素 索性成的面积大小，不断更新 maxArea
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
       		// 如果能够继续形成 升序 则直接将当前元素放入 栈 中
            stack.push(i);
        }
        // 遍历完数组后，处理栈不空的情况 从后往前处理
        while (stack.peek() != -1){
            // 再次出栈 计算栈顶元素 与栈中剩下的元素所形成的最大面积
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
```

