package june.code.byhehe.forOffer.AiQiYi;

import java.util.Scanner;

public class AiQiYi001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AiQi01 aq = new AiQi01();
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(aq.getRes(s));
        }
    }
}

class AiQi01{
    public int getRes(String s){
        int n = s.length();
        if(s == null || n == 0)
            return 0;
        // 使用字符进行判断
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        // 初始化 默认全是 -1 即没有出现过
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int pre = -1;  // 表示序列前一个
        int curLen = 0;
        int maxLen = 0;
        for (int i = 0; i != n; i++) {
            pre = Math.max(pre, map[chars[i]]);
            curLen = i - pre;
            maxLen = Math.max(curLen, maxLen);
            map[chars[i]] = i;  // 更新上一个 字符出现位置
        }
        return maxLen;
    }
}

