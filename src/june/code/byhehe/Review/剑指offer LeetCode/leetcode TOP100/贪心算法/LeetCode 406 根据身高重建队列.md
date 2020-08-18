#### [406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)

难度中等304

假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对`(h, k)`表示，其中`h`是这个人的身高，`k`是排在这个人前面且身高大于或等于`h`的人数。 编写一个算法来重建这个队列。

**注意：**
总人数少于1100人。

**示例**

```
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```



这个 在 leetcode上有非常详细的解释：[LeetCode：406 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/)

## 思路

```
这里大致说下理解：
   每个人都有 两个值 (h, k), 其中 h 表示身高， k 表示前面比自己身高高 或者相等的 人 有 k 个。
   首先 矮的人是看不到前面的。 所以可以这样考虑， 高个子们也是抽上周管矮子的， 先让高个子进行排序。
   高个子 首先排序， 根据 k 值进行升序排序， 根据自己的索引插入到 对应的位置。
   然后 比高个子矮的 进行排序，过程同上。 根据自己的索引插入到 对应的位置。
   
   比如： [7,0], [7,1]  会先排序插入。
   [[7,0], [7,1]]   根据自己的 k 第二个值， 分别插入到对应的位置。 接着拍下一个
   [6,1] 则有
   [[7,0], [6,1],[7,1]]  可以看到 [6,1] 根据自己的 k (1) 插入到 下标 1 的位置。
   [5,0], [5,2] 则有
   [[7,0], [5,0], [5,2], [6,1],[7,1]] 
   ....
```



## 代码

```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 时间复杂度 O(nlog^n + n) = O(nlog^n)
        // 空间复杂度 O(n)
        // 首先对数组进行排序
        Arrays.sort(people, new Comparator<int[]>() { // 这里可以使用 lambda 表达式来写的更简洁
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?o1[1] - o2[1] : o2[0] - o1[0]; // 相等按 第二个元素 升序， 否则按第一个元素降序
            }
        });
        // 将数组放到队列中 可以放到指定位置  存的是数组
        List<int[]> queue = new LinkedList<>();
        for(int[] ele:people){
            queue.add(ele[1], ele);
        }
        return queue.toArray(people);
    }
}
```

