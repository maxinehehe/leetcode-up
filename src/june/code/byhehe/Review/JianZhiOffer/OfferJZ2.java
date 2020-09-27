package june.code.byhehe.Review.JianZhiOffer;

public class OfferJZ2 {
    public static void main(String[] args) {
        JZ2 jz = new JZ2();
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println(jz.replaceSpace(s));

    }
}

class JZ2{
    public String replaceSpace(StringBuffer str) {
        if(str==null || str.length() == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
