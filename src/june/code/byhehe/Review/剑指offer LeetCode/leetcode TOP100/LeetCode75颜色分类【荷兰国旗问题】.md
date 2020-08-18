#### [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors/)

难度中等397

给定一个包含红色、白色和蓝色，一共 *n* 个元素的数组，**[原地](https://baike.baidu.com/item/原地算法)**对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

**注意:**
不能使用代码库中的排序函数来解决这道题。

**示例:**

```
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
```

**进阶：**

- 一个直观的解决方案是使用计数排序的两趟扫描算法。
  首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
- 你能想出一个仅使用常数空间的一趟扫描算法吗？

## 思路：

```
比较直观的做法 直接使用 快排方法进行排序
时间复杂度： O(logn)
空间复杂度： O(1)
```

## 代码1

```java
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    // 来个快排
    public void quickSort(int[] arr, int low, int high){
        int l = low;
        int r = high;

        if(l<r){
            int temp = arr[l];
            while(l<r){
                while(l<r && temp < arr[r]){
                    r--;
                }
                if(l < r){
                    arr[l] = arr[r];
                    l++;
                }

                while(l < r && temp > arr[l]){
                    l++;
                }
                if(l < r){
                    arr[r] = arr[l];
                    r--;
                }
            }
            arr[l] = temp;
            quickSort(arr, low, l-1);  // 不要再把 arr[l] 算进去了 他已经在这次运算中 成为一个 中枢 不再参与运算
            quickSort(arr, l+1, high);
        }
    }
}
```



## 思路 2

```
使用 三个指针： 由于 只有 0 , 1, 2 三个元素【红白蓝】 
p0 指向 0 的最右边界，即每一次 p0 的位置保存 0 的值之后 就进行 p0++
p2 指向 2 的最左边界，即每一次 p2 的位置保存 2 的值之后 就进行 p2--
cur 指向当前元素 进行判断当前元素是 0 还是 1， 这样通过 只考虑 0 和 2 就可以将 1 界定于 0 和 2 之间。
时间复杂度： O(n)
空间复杂度： O(1)
```

## 代码2

```java
class Solution {
    public void sortColors(int[] nums) {
        //quickSort(nums, 0, nums.length-1);
        sortColorsDo(nums);
    }
   // 使用 每次cur进行判断是0还是2的方法 
    public void sortColorsDo(int[] nums){
        // p0 指向 0 的最右边界  p2 指向 2的最左边界
        // cur 指向当前元素 不断往后走
        int p0 = 0, cur = 0;
        int p2 = nums.length - 1;
        int tmp;
        while(cur <= p2){
            // 判断 0
            if(nums[cur] == 0){ // 比较元素
                // 和 p0 进行交换
                tmp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            }
            else if(nums[cur] == 2){
                // 和 p2 进行交换
                tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = tmp;
            }else{
                cur++;
            }
        }
    }
   
}
```

