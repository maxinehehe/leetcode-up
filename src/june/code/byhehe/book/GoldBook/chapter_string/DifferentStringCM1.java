package june.code.byhehe.book.GoldBook.chapter_string;

public class DifferentStringCM1 {
    public static void main(String[] args) {
        Different different = new Different();
        String s = "aeiou";
        String s2 = "BarackObama";
//        System.out.println(different.checkDifferent(s));
        System.out.println(different.checkDifferent2(s));
        System.out.println(different.checkDifferent3(s));
    }
}

class Different {
    public boolean checkDifferent(String iniString) {
        // write code here
        // 暴力法
        if(iniString == null || iniString.length() == 0)
            return false;
        for (int i = 0; i < iniString.length(); i++) {
            for (int j = i+1; j < iniString.length(); j++) {
                if(iniString.charAt(i) == iniString.charAt(j))
                    return false;
            }
        }
        return true;
    }
    // 这里考察这样的一种情况 使用字符数组存储
    public boolean checkDifferent2(String iniString) {
        char[] chars = iniString.toCharArray();

        return heapSortWithChars(chars);
    }
    public boolean heapSortWithChars(char[] chars){
        if(chars == null || chars.length == 0)
            return false;
        // 构建堆
        int length = chars.length;
        // 下面逻辑错误 是从 length/2-1 开始向上调整 而不是 再向下了
//        for (int i = length/2 - 1; i <length; i++) {
//            buildHeap(chars, i, length);
//        }
        for(int i = length/2-1; i >= 0; i--){
            buildHeap(chars, i, length);
        }


        for (int j = length-1; j >= 0 ; j--) {
            char temp = chars[j];
            chars[j] = chars[0];
            chars[0] = temp;
            if(j < length-1 && chars[j] == chars[j+1]){
                return false;
            }
            buildHeap(chars, 0, j);

        }
//        for(char temp:chars)
//            System.out.print(temp+" ");
//        System.out.println();
        return true;
    }

    public void buildHeap(char[] chars, int i, int length){
        char temp = chars[i];  // 先暂存当前元素
//        System.out.println("chars["+i+"] :"+chars[i]);
        for(int k = 2*i+1; k < length; k=2*k+1){
            // 先判断 左右谁大
            if(k+1 < length && chars[k] < chars[k+1]){
                k++;
            }
            if(chars[k] > temp){
                chars[i] = chars[k];
                i = k;
            }else {
                break;
            }
        }
        chars[i] = temp;

    }


    // 使用 不重复的最长字符串
    public boolean checkDifferent3(String s){
        if(s == null || s.length() == 0)
            return false;

        char[] chars = s.toCharArray();
        int[] map = new int[256];
        // map[i] 表示 i 最近出现的位置
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        // pre 指向 非重复串的前一个位置   比如 aabc pre 指向第一个 a
        int pre = -1;
        int len = 0;

        for (int i = 0; i < chars.length; i++) {
            // 取pre 或者map[chars[i]] 作为最新的起始点
            pre = Math.max(pre, map[chars[i]]);
            // 获取 当前长度值
            int curLen = i - pre;
            // 查看是否是最长的长度值
            len = Math.max(len, curLen);
            map[chars[i]] = i;
            // 提前剪枝
            if(pre != -1)
                return false;
        }
        return true;
    }
}
