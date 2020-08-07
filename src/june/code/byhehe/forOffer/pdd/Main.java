package june.code.byhehe.forOffer.pdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        helper();
    }

    public static void helper(){
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();   // 表示还差多少距离
        int N = sc.nextInt();   // 表示掷骰子次数
//        if(K==0||N==0)
//            System.out.println();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // 从头到尾开始
        int back_counts = 0;
        int dist = K;
        for (int i = 0; i < nums.length; i++) {
            if(dist - nums[i] >= 0){
                dist -= nums[i];



            }else {
                back_counts++;
            }
            System.out.println("-> "+dist);
            if(dist == 0){

                    if(i == N-1){
                        System.out.println(dist+" "+back_counts);
                    }else {
                        System.out.println("paradox");
                    }
                    break;
                }


        }
        if(dist!=0)
            System.out.println(dist+" "+back_counts);
    }

}
