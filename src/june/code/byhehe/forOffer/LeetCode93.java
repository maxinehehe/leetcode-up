package june.code.byhehe.forOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
    public static ArrayList<String> restoreIpAddresses(String s){
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        // 先判断 len 必须符合的长度范围  3 < len < 13
        if(len <= 3 || len >= 13)
            return res;
//        System.out.println("-------");
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }
    // 先写主要的判断函数

    /**
     *
     * @param s  表示 要进行拆分地字符串
     * @param len 表示 字符串 s 的长度
     * @param restLocs 表示 剩余位置次数   ip 总共 四个 坑位 用一个减少一个
     * @param path deque 用于 保存 我们要处理的当前长度的字符串 进行回退处理
     * @param list  用于保管 分组的字符串
     */
    public static void dfs(String s, int len, int begin, int restLocs, Deque<String> path, ArrayList<String> list){
        // 表示 begin 走到了最后 说明 找到了一个符合条件的
        if(begin == len){
            if(restLocs == 0){
                list.add(String.join(".", path));
            }

            return;  // 结束一个 循环
        }

        for (int i = begin; i < begin + 3; i++) {
            // 因为 一个 字符串 包含最多的 3 个 即 每一个位置的 至少是 1 位数 最多是 3 位数
            // 首先进行剪枝 判断 不合法的
            if( i >= len)  // 绝对不能超过 s 的总长度  后面的不用再去判断 现在都超过 len 更不用说后面的了
                break;

            // 这次不行 即 比如 2.5.5 25511135 此时 resLocs = 2 i == 3时， 2 * 3 = 6 < 11(len) - 3 = 8
            // 意思就是 说 剩下的 一个坑里只能放3 ， 然后 你看一下 你还剩多少数
            // 为什么是 continue 再举个栗子 255.255.1.1135  1 * 3 = 3 < 11 - 7 = 4,
            // 但是 如果下一次 i 再后移一位 255.255.11.135 结果就符合了 也就是说 还有拯救的余地
            if(restLocs * 3 < len - i)
                continue;
            // 判断 当前截取的是否符合 0<= () <= 255
            // 先按住起点 重点是可变的 但不超过 i- begin
            if(judgeIsRange(s, begin, i)){
                // 如果符合的话  即 当前这个数的范围是 0<= <=255
                String splitIpSegement = s.substring(begin, i+1);  // 包括左边不包括右边
                path.addLast(splitIpSegement);

                // 这里写错了 i 是动量
               // dfs(s, len, begin+1, restLocs - 1, path, list);
                dfs(s,len, i+1, restLocs-1, path, list);

                // 回溯
                path.removeLast();

            }

        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        System.out.println(s.substring(left, right+1));
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    public static boolean judgeIsRange(String s, int begin, int i){
        int len = i - begin + 1;
//        if(begin > i)
//            return false;

        // 这个点也必须判断
        if (len > 1 && s.charAt(begin) == '0') {  // 以 0 开头 说明有问题11.023....
            return false;
        }

        int res = Integer.valueOf(s.substring(begin, i+1));
        System.out.println(s.substring(begin, i+1));
//        int res = 0;
//        while (begin<=i){
//            // 下面这个公式写错了
////            res += res * 10 + s.charAt(begin) - '0';
//            res = res * 10 + s.charAt(begin) - '0';
//            begin++;
//        }

        return res >= 0 && res <= 255;
    }
}
