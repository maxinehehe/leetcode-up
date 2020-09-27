package june.code.byhehe.forOffer.baidu;

import java.util.Scanner;

public class B02 {
    // a+b 3 ---》 ab 3
    public static void main(String[] args) {
        int x = 0,y = 5;
        int i,j,sum,sum1, k,t,n;
        int []arr = new int[1001];//  10^3
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            n = sc.nextInt();
            t = -1;
            sum =0;
            sum1 = 0;
            for (i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
                if(arr[i] == 0)
                    sum1++;
                if(sum % 9 == 0)
                    t = sum;
            }
            if(t>0 && sum1 > 0){
                k = t / 5;
                for (i = 0; i < k ; i++) {
                    System.out.print("5");

                }
                for(i = 0; i < sum1; i++){
                    System.out.print("0");
                }
                System.out.println();
            }
            else if(sum1 > 0){
                System.out.println("0");
            }else{
                System.out.println("-1");
            }

        }
    }
}
