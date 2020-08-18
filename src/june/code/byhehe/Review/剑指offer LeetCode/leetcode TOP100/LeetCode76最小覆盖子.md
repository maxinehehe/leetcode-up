#### [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

难度困难433收藏分享切换为英文关注反馈

给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

**示例：**

```
输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
```

**说明：**

- 如果 S 中不存这样的子串，则返回空字符串 `""`。
- 如果 S 中存在这样的子串，我们保证它是唯一的答案。

## 思路

```
双指针思路问题
left 指向窗口的左边界， right 指向 窗口的右边界
有两个哈希表进行保存数据：
> needs 保存 t 中子串的个数， 比如 ABC-> needs:[A:1, B:1, C:1]
> window 也可以保存所有 符合区间的的 子串个数，也可以只保存 符合 存在于 needs 中的个数，这里选择第二种节省空间。  比如 BNAAC -> window:[B:1, A:2, C:1]  
> 其中 可以使用 match 进行计数 ， 每当 window 中的 一个 key 的 value 和 needs 中对应的 key 的 value 相等的话【注意==比较对象】，match就 加 1， 然后不断进行 right++, 知道 match = needs.size() 即 全部满足要求；
  然后进行移动 left++,如果失去的一个字符 正好是 存在于needs中的，那么 window 需要进行 操作对应 key 的 value 减 1 ，然后判断 window.get(c).intValue() < needs.get(c).intValue() 成立的话，重新从头开始，right 进行向后移。 
```

## 代码

```java
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return t;
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int right = 0, left = 0;
        int start=0, minLen = -1;
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        int match = 0;
        for(char temp:tArr){  // needs 的存进一个哈希表
            int count = needs.getOrDefault(temp, 0); 
            needs.put(temp, count + 1);
        }
        while(right < sArr.length ){
            // 首先 判断 
            char c = sArr[right];
            if(needs.containsKey(c)){
                int count = window.getOrDefault(c, 0);
                window.put(c, count + 1);
                // 这里必须使用 .intValue() 进行比较 
                // 切记 == 号 如果是地址 他比较的是 地址 如果是基本类型 他比较的才是值
                if(window.get(c).intValue() == needs.get(c).intValue()){  
                    match++;  // 有一个已经完全匹配 
                }
            }
            // 这个 
            // right++; // 先使用 right ++  后面就不用 s.substring(left, right); 直接使用 right 就行

            while(left <= right && match == needs.size()){
                char c2 = sArr[left];
                // 找到一个 
                //int len = right - left + 1;
                if(minLen == -1 || right-left+1 < minLen ){
                    start = left;
                    minLen = right - left + 1 ;
                }
                //res = res.length() < len ? res: s.substring(left, right);
                if(needs.containsKey(c2)){
                    window.put(c2, window.get(c2) - 1);
                    // 因为有可能 window 中会存储多个 符合的
                    if(window.get(c2).intValue() < needs.get(c2).intValue())
                        match--;
                }
                left++;
            }
             right++;
        }
        return minLen == -1?"":s.substring(start, start+minLen);
    }
}
```

# NOTE:

切记 == 号 如果是地址 他比较的是 地址 如果是基本类型 他比较的才是值。

由于 

```java
Map<Character, Integer> needs = new HashMap<>();
```

使用的 value 是 Integer ，那么 == 他判断的是 对象的地址是否相等， 如果是基本类型，则是判断基本类型的值是否相等。