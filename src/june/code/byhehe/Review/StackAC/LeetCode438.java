package june.code.byhehe.Review.StackAC;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 使用 map 定义两个 窗口
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        // 定义初始化 窗口两端
        int left = 0, right = 0;
        // 定义计数 即判断 是否符合窗口的值
        int count = 0;

        // 使用新元素
        List<Integer> res = new ArrayList<>();

        // 开始进入 窗口进行判断
        while (right < s.length()){
            // c 表示将 要进入窗口的字符  记住 是 先从 right 开始判断 再慢慢收缩
            char c = s.charAt(right);
            right++; // 向右移动
            // 对窗口内的数据进行更新处理
            /**
             * 这里是处理逻辑
             */
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(need.get(c).intValue() == window.get(c).intValue())
                    count++;
            }


            while(right - left >= p.length()){  // 这里不能用need size 出现重复值 就无法进行正确判断
                /**
                 * 更新操作逻辑
                 */
                if(count == need.size())
                    res.add(left);

                // d 表示将要移出 窗口的字符
                char d = s.charAt(left);
                // 左移 窗口 进行收缩
                left++;
                // 进行一系列的窗口更新
                if(need.containsKey(d)){

                    if(need.get(d).intValue() == window.get(d).intValue())
                        count--;

                    window.put(d, window.getOrDefault(d, 0)-1);
                }

            }

        }
        return res;
    }
}
