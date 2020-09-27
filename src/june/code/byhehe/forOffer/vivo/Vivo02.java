package june.code.byhehe.forOffer.vivo;

import java.util.Scanner;

public class Vivo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        MyVivo02 myVivo02 = new MyVivo02();
        System.out.println(myVivo02.getRes(s));
    }
}

class MyVivo02{
    public String getRes(String s){
        char[] chars = new char[s.length()-1];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = 0; j < s.length(); j++) {
                if(i!=j)
                    chars[count++] = s.charAt(i);
            }
            int l = 0, r = 0;
            if(chars.length % 2 == 0){
                l = chars.length%2;
                r = chars.length%2+1;
                if(isPa(chars,l,r)){
                    return chars.toString();
                }
            }else {
                l = chars.length%2;
                r = chars.length%2;
                if(isPa(chars,l,r)){
                    return chars.toString();
                }
            }

        }
        return "false";
    }

    public boolean isPa(char[] chars, int l, int r){
        while (l>=0 && r<chars.length&&chars[l] == chars[r]){
            l--;
            r++;
        }

        return l==-1?true:false;
    }
}
