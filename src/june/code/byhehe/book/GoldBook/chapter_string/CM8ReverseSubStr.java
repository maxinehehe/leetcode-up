package june.code.byhehe.book.GoldBook.chapter_string;

public class CM8ReverseSubStr {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        CM8 cm8 = new CM8();
        System.out.println(cm8.checkReverseEqual(s1, s2));
        System.out.println(cm8.checkReverseEqual2(s1, s2));
    }
}
class CM8{
    // 方法 s = s1+s1   ,判断 s1是否包含s2
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        // 首先判断长度
        if(s1.length()!=s2.length())
            return false;

        String s = s1+s1;
        // 使用 子串 判断

        int length = s2.length();
        for (int i = 0; i < s.length() - length; i++) {
//            System.out.println(s.substring(i,i+length)+" "+s2);
            if(s.substring(i, i+length).equals(s2))
                return true;
        }

        return false;
    }

    public boolean checkReverseEqual2(String s1, String s2) {
        // write code here
        // 首先判断长度
        if(s1.length()!=s2.length())
            return false;
        s2 = "^.*"+s2+".*$";
        String s = s1+s1;
        // 使用 子串 判断

        int length = s2.length();
        if(s.matches(s2)){
//            System.out.println("匹配");
            return true;
        }
        return false;
    }
}
