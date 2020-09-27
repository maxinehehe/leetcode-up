package june.code.byhehe.forOffer.baidu;

import java.util.Scanner;

public class B01 {
    public static int[] counts;
    public static void main(String[] args) {

    }


    // m 表示台阶数
    // n 表示最多跳多少次
    public static int mkSteps(int n, int m){
        if(m <= 0){
            return 1;
        }else if(m == 1){
            if(n >= 1){
                counts[1] = 1;
                return 1;
            }else {
                counts[1] = 0;
                return 0;
            }
        }else if( m == 2){
            if(n==1){
                counts[2] = 0;
                return 0;
            }else if(n >= 2){
                counts[2] = 1;
                return 1;
            }
        }else if(n == m){
            counts[m] = 2 * mkSteps(n, m-1);
//            if(counts[m] )
        }else {
            return 2*mkSteps(n, m-1) - mkSteps(n, m-n-1);
        }
        return -1;

    }


}
class  SolvB01{
    public int[] counts;
    // m 表示台阶数
    // n 表示最多跳多少次
    public int mkSteps(int n, int m){
        if(m <= 0){
            return 1;
        }else if(m == 1){
            if(n >= 1){
                return 1;
            }else {
                return 0;
            }
        }else if( m == 2){
            if(n < 1){
                return 0;
            }else if(n==1){
                return 1;
            }else if(n >= 2){
                return 2;
            }
        }else if(n == m){
            int curNum = 2 * mkSteps(n, m-1);
            if(curNum == mkSteps(n, m-1) || curNum == mkSteps(n, m-2))
                return -1;
            else
                return curNum;
        }else {
            return 2*mkSteps(n, m-1) - mkSteps(n, m-n-1);
        }
        return -1;

    }
}
