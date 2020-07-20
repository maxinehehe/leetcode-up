package june.code.byhehe.Review.StackAC;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode76 {
    public static void main(String[] args) {
        System.out.println(minStringOver("ADOBECODEBANC", "ABC"));
    }
    public static String minStringOver(String s, String t){
        if(s == null || s.equals("") || t.equals(""))
            return null;
        // 假如 s = "SAHUHBNACDJ" t = "ABC"  结果是 BNAC 长度 为 3
        // need 表示 对应的 t , window 则表示 当前窗口出现的相应字符串
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char curChar = t.charAt(i);  // 这里翻了个大错   t 里面掺入 s ??? 搞笑
            need.put(curChar, need.getOrDefault(curChar, 0) + 1);
        }
        int left = 0, right = 0;
        int count = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char curChar = s.charAt(right);
            right++;
            if(need.containsKey(curChar)){
                window.put(curChar, window.getOrDefault(curChar, 0)+1);
                if(window.get(curChar) == need.get(curChar))
                    count++;

            }

            while (count == need.size()){
                // 记录 start and len
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                // 左移窗口
                left++;
                if(need.containsKey(d)){
                    if(window.get(d) == need.get(d))
                        count--;
                    window.put(d, window.get(d)-1);
                }

            }

        }
        return len == Integer.MAX_VALUE?"":s.substring(start, start+len);

    }
}
