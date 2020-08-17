package june.code.byhehe.forOffer.QiAnXin;

import java.util.ArrayList;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
//        System.out.println(CalulateMethodCount(4));
    }
//    public static int getM(int n){
//
//    }
    public List<Integer> list = new ArrayList<>();
    public static int count = 0;
    // 尝试使用dp
//    public static int CalulateMethodCount (int num_money) {
//
//
//    }

    public static int getOk(int n, int [] dp){
        if(n<3)
            return n;
        return 2*getOk(n-1,dp) +1;
    }

    public static int getRes(int n){
        if(n == 0)
            return 1;

        for (int j = 1; j <= n; j++) {
            count+= getRes(n-j);
        }
        return count;
    }
}
