package june.code.byhehe.forOffer;

import java.util.Scanner;

public class hwT01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int K = 3;
//        int[] A_i = {1,2,3};
//        int[] B_i = {3,2,1};
//        int N = 6;
//        int[] C_i = {1,2,3,3,2,1};
//        int[] D_i = {3,2,1,1,2,3};
//
//        int res = getRes(K,A_i, B_i, N, C_i, D_i);
//        System.out.println(res);
        while (sc.hasNextInt()){
            int K = sc.nextInt();
            // 注意 是` 连续的
            // 外观价值
            int[] A_i = new int[K];
            // 价格值
            int[] B_i = new int[K];
            for (int i = 0; i < K; i++) {
                A_i[i] = sc.nextInt();
            }
            for (int i = 0; i < K; i++) {
                B_i[i] = sc.nextInt();
            }
            int N = sc.nextInt();
            // 玩具店
            int[] C_i = new int[N];
            int[] D_i = new int[N];

            for (int i = 0; i < N; i++) {
                C_i[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                D_i[i] = sc.nextInt();
            }

            // 输入结束
            // 要求连续的序列都要对上
            re(K, N, A_i, B_i, C_i, D_i);


        }
    }

    // 考虑使用字符串
    public static void re(int K, int N, int[]n1, int[]n2, int[]m1,int[]m2){
        // 加一个这个判断 排除 一些出错的定义
        if(K >= N){
            System.out.println(0);
            return;
        }

        StringBuilder sbn1 = new StringBuilder(); // 完美 1
        StringBuilder sbn2 = new StringBuilder(); // 完美 2
        StringBuilder sbm1 = new StringBuilder(); // 原始 3
        StringBuilder sbm2 = new StringBuilder(); // 原始 4

        for (int i = 0; i < n1.length; i++) {
            sbn1.append(n1[i]);
            sbn2.append(n2[i]);
        }
        for (int i = 0; i < m1.length; i++) {
            sbm1.append(m1[i]);
            sbm2.append(m2[i]);
        }
        // 添加结束
        String strn1 = sbn1.toString();
        String strn2 = sbn2.toString();
        String strm1 = sbm1.toString();
        String strm2 = sbm2.toString();

        int len = n1.length;
        // 需要判断边界条件
        for (int i = 0; i < strm1.length()-len; i++) {
            if(strm1.substring(i,i+len).equals(strn1)){
                // 进一步判断
                if(strm2.substring(i,i+len).equals(strn2)){
                    System.out.println(i+1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}

