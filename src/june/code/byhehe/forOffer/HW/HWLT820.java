package june.code.byhehe.forOffer.HW;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

示例：

输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 
提示：

1 <= words.length <= 2000
1 <= words[i].length <= 7
每个单词都是小写字母 。

 */
public class HWLT820 {
    public static void main(String[] args) {
        String[] words = {"time","time", "me","bell"};
        System.out.println("time".substring(1));
        System.out.println(minimumLengthEncoding(words));
//        System.out.println(set.remove("a")); // 不存在 返回false

    }
    public static int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for(String word:words){
            // time , ime, me 后面两个都可以由 time 压缩存储
            // 有个大坑 注意这里 不能 i = 0 开始 这样 "time".substring(0) 还是 time
            // 就会移除， 因此从 第二个字符开始进行移除
            // 最后你可能会说 如果有两个单词完全一样呢？？？
            // 我们把它 转成 set 不就是为了处理这种情况吗？
            // set 里不允许存储重复的元素  秒吧
            for (int i = 1; i < word.length(); i++) {
                // 比如 time  当截取到 后缀 me 时 那么就可以 移除掉 me 减少压缩
                set.remove(word.substring(i));
            }
        }
        int count = 0;
        for(String word:set){
            count += word.length() + 1;
        }
        return count;
    }
}


