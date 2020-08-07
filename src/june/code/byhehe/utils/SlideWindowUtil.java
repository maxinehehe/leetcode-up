package june.code.byhehe.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法框架 Java 版
 * 核心思想 先扩大窗口， 在收缩窗口
 */
public class SlideWindowUtil {
    public void slideWindow(String s, String t){
        // 使用 map 定义两个 窗口
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 定义初始化 窗口两端
        int left = 0, right = 0;
        // 定义计数 即判断 是否符合窗口的值
        int count = 0;

        // 开始进入 窗口进行判断
        while (right < s.length()){
            // c 表示将 要进入窗口的字符  记住 是 先从 right 开始判断 再慢慢收缩
            char c = s.charAt(right);
            right++; // 向右移动
            // 对窗口内的数据进行更新处理
            /**
             * 这里是处理逻辑
             */


                while("判断窗口是否需要收缩的条件".equals("")){
                    // d 表示将要移出 窗口的字符
                    char d = s.charAt(left);
                    // 左移 窗口 进行收缩
                    left++;
                    // 进行一系列的窗口更新
                    /**
                     * 更新操作逻辑
                     */


                }
        }


    }
}
