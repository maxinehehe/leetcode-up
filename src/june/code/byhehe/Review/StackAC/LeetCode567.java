package june.code.byhehe.Review.StackAC;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {

        /**
         * 这里注意在 进行比较的时候 map的值 最好使用 需要使用 intValue 进行比较
         */
        // 使用 map 定义两个 窗口
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        // 定义初始化 窗口两端
        int left = 0, right = 0;
        // 定义计数 即判断 是否符合窗口的值
        int count = 0;

        // 开始进入 窗口进行判断
        while (right < s2.length()){
            // c 表示将 要进入窗口的字符  记住 是 先从 right 开始判断 再慢慢收缩
            char c = s2.charAt(right);
            right++; // 向右移动
            // 对窗口内的数据进行更新处理
            /**
             * 这里是处理逻辑
             */
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).intValue() == need.get(c).intValue())
                    count++;
            }

            // 这个是判断子串 而且里面不能有别的字符 所以需要 已达到 和 s 相同的长度就立刻判断
            while(right - left >= s1.length()){
                // d 表示将要移出 窗口的字符
                char d = s2.charAt(left);
                // 左移 窗口 进行收缩
                left++;
                // 进行一系列的窗口更新
                /**
                 * 更新操作逻辑
                 */
                if(count == need.size())
                    return true;

                if(need.containsKey(d)){
                    if(window.get(d).intValue() == need.get(d).intValue())
                        count--;

                    window.put(d, window.get(d)-1);
                }

            }

        }
        return false;
    }
}
