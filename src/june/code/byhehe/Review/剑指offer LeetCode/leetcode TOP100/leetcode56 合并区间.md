# LeetCode 56 合并区间

#### [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)

难度中等401

给出一个区间的集合，请合并所有重叠的区间。

**示例 1:**

```
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```

**示例 2:**

```
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
```



## 思路：

```
和贪心算法区间调度有异曲同工之妙处
这是这个不太一样了，需要考虑的问题也更多些。
1. 首先把区间进行排序
2. 然后根据每一个数组中的第一数进行排序（如果相同则根据第二个数进行排序）。
3. 之后 第一个的 结尾 end 和 第二个数组的 首位 start 进行比较， 如果 end <= start 
   说明有重叠，进行处理, 比较他们第一个数取最小的，比较他们第二个数，区最大的，构成一个新的数组
   ，存到列表中去。【可以使用列表】
   【列表 从末位插入， 比较也从末尾取出，这样保证 插入删除都是同样的序， 每次都取出数组，然后和笑一个数组作比较，就是上面的比较规则】
```



## 代码

```java
import java.util.*;
class Solution {
    // 使用贪心算法
    /*
    按每个数组中的第一个数进行排序
    然后 将数组和 当前 排序列表中最后一个数组进行比较，若最开始为空则直接放入。
    否则进行比较， 列表中 最后一个数组 比如叫做 temp, 当前数组叫做 curArr
    比较 如果 temp[1] >= curArr[0],比如：[1,3] 和 [2,6] 就可以进行合并。
   3 >= 2
   合并结果：[1, 6]
    */
    public int[][] merge(int[][] intervals) {
        return greedyMerge(intervals);
    }
    public int[][] greedyMerge(int[][] arr){
        // 使用贪心算法区间问题
        if(arr.length <= 1) return arr;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {  
                return o1[0] - o2[0];//o1[0] == o2[0]?(o1[1] - o2[1]):(o1[0] - o2[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int[] temp = list.get(list.size()-1);
            int end = temp[1]; // 当前已排序列表中的最后一个数组的 右端点值 如 [1,3] 这里取 3
            int start = arr[i][0];  // 当前 遍历到的 值得开始节点 比如 [2,6] 这里取 2
            if(start <= end){  // 
                list.remove(list.size()-1); // 说明需要合并 将最后面的值先移除合并后 再重新添加
                temp[1] = Math.max(arr[i][1],temp[1]);
                list.add(temp);
                continue;
            }
            list.add(arr[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
```

