package june.code.byhehe.book.GoldBook.chapter_string;

import java.util.Arrays;
import java.util.Comparator;

public class CM3MakeSure {
    public static void main(String[] args) {
        CM3 cm3 = new CM3();
        String a = "This is nowcoder";
        String b = "is This nowcoder";
        System.out.println(cm3.checkSam(a, b));
        System.out.println(cm3.checkSam2(a,b));
        System.out.println(cm3.checkSam3(a,b));
    }
}

class CM3{
    // 考虑使用 256 长度进行判断 或者使用 map 进行判断
    // 空间：O(n)   时间：O(n)
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        // 考虑判断长度
        if(stringA.length() != stringB.length())
            return false;

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < stringA.length(); i++) {
            char c = stringA.charAt(i);
            char c2 = stringB.charAt(i);
            map1[c]++;
            map2[c2]++;
        }

        for (int i = 0; i < 256; i++) {
            if(map1[i]!=map2[i])
                return false;
        }
        return true;
    }
    // 重排单词 进行比较
    // 空间：O(n)   时间：O(nlogn)
    public boolean checkSam2(String stringA, String stringB) {
        String[] splitA = stringA.split(" ");
        String[] splitB = stringB.split(" ");
        if(splitA.length!=splitB.length)
            return false;

        Arrays.sort(splitA, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(splitB, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < splitA.length; i++) {
            if(!splitA[i].equals(splitB[i]))
                return false;
        }
        return true;
    }

    // 还有一种方法 基于上面的重排单词 ， 由于题目并未严格要求 以单词为基准， 所以我们可以重排所有字符进行比较
    // 空间：O(n)  时间：O(n)
    public boolean checkSam3(String stringA, String stringB) {
        // 需要借助 char 数组
        if(stringA.length()!=stringB.length())
            return false;

        char[] chars1 = stringA.toCharArray();
        char[] chars2 = stringB.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        // 直接调用 Arrays.equals 方法来进行比较
        return Arrays.equals(chars1, chars2);

        /*
        // 没必要 再写 其实 Arrays 里面源码就是这样写的
        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;
         */
    }
}
