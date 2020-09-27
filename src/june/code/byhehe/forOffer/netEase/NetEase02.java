package june.code.byhehe.forOffer.netEase;

import java.util.Scanner;

public class NetEase02 {
    public static void main(String[] args) {
        MyNE myNE = new MyNE();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            int res = myNE.getRes2(s);
            System.out.println(res);
        }


    }
}

class MyNE{
    public int getRes2(String s){
        int n = s.length(), res = 0;
        for (int i = 0; i < 2*n-1; i++) {
            // 往外扩展i / 2
            int left = i / 2, right = i / 2 + i % 2;
            while ( left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                --left;
                ++right;
                ++res;
            }
        }

        return res-n;
    }
    public int getRes(String s){
        int count = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if(len%2 == 0){
                // 偶数
                int left = i, right = i+1;
                if(isPara(s, left, right)){
                    count++;
                }
            }else{
                int left = i, right = i;
                if(isPara(s, left, right)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isPara(String s, int l, int r){
//        int count = 0;
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return l+1 < r-1 ? true:false;
        /*
        a
     -1 0 1
     l    r
         */
    }
}
