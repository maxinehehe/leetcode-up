package june.code.byhehe.book.GoldBook.chapter_string;

public class CM5Compressor {
    public static void main(String[] args) {
        CM5 cm5 = new CM5();
        String s = "welcometonowcoderrrrr";
        String s2 = "w1e1l1c1o1m1e1t1o1n1o1w1c1o1d1e1r5";
        System.out.println(cm5.zipString(s));
    }
}


class CM5{
    // 使用双指针 一个指向 一个计数
    public String zipString(String iniString) {
        // write code here
        if(iniString == null || iniString.length() == 0)
            return iniString;
        int ptr = 0;
        int pCount = 0;
        int length = iniString.length();
        StringBuilder sb = new StringBuilder();
        while (ptr < length){
            char c = iniString.charAt(ptr);
            if(sb.length() == 0){
                sb.append(c);
                pCount += 1;
            }else if(sb.length()!=0 && sb.charAt(sb.length()-1)!=c){
                sb.append(pCount);
                sb.append(c);
                pCount = 1;
            }else {
                pCount += 1;
            }
            ptr++;
            if(ptr == length)
                sb.append(pCount);
        }
        if(sb.length() >= length)
            return iniString;
        else
            return sb.toString();
    }
}