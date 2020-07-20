package june.code.byhehe.Review.StackAC;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("dfod"));
    }

    /**
     * 大致思路：使用 map
     * map : key 表示字符、value 表示这个字符最近一次出现的位置
     * pre : 表示 比如 当前位置为 i ， 那么 pre 就是 以 i-1 开始的 前一个位置
     * 比如 aabcd   当前位置 i = 3 , 那么 pre 则就是 1 的前一个位置 0
     * 相当于 未重复字符串 起始位置的前一个位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || " ".equals(s))
            return 0;
        // 转为字符串数组
        char[] chars = s.toCharArray();
        // 初始化 pre
        int pre = -1;
        // 初始化当前位置
        int cur = 0;
        int len = 0 ;
        // 初始化 map
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;  // 初始化 所有 字符默认 均没有出现过
        }

        for(int i = 0; i != s.length(); i++){
            // 首先是找到 起始位置有没有发生变化  pre 表示不重复字符串出现的前一个位置 map['字符'] 表示该字符最近出现的位置
            // 举例子 dfod 对应下标 0123  加入 当前 i = 3,遍历到 第二个 'd', 那么 此时 pre = 0， map['d'] = 3
            pre = Math.max(pre, map[chars[i]]);   // 即 看 当前的这个字符有没有出现过，如果有的话 那么它就是新的起点
            cur = i - pre;  // cur 表示 从上一个不重复的 位置开始到当前位置  i 的 最长字符串长度
            len = Math.max(cur, len);

            // 记录 并更新当前 字符 的最新位置
            map[chars[i]] = i;
        }

        return len;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || "".equals(s))
            return 0;

        Map<Character, Integer> window = new HashMap<>();
        int left=0,right=0;
        int len = s.length();
        int res = 0;
        while (right < len){
            char c = s.charAt(right);
            right++;
            // 对当前key 进行处理
            window.put(c, window.getOrDefault(c, 0)+1);
            // 判断 是否 有重复值
            while (window.get(c) > 1){
                // 表明有重复值了
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
