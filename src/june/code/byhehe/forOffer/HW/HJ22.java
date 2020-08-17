package june.code.byhehe.forOffer.HW;

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while ((num = sc.nextInt()) != 0){
            System.out.println(getNum(num));
            sc.nextLine();
        }
//        while (sc.hasNext()){
//            String s = sc.nextLine();
//            num = Integer.valueOf(s.trim());
//            if(num == 0)
//                break;
//            System.out.println(getNum(num));
//        }
    }

    public static  int getNum(int num){
        int rest = num;
        int a = 0, b = 0, counts = 0;
        while (rest >= 3){
            a = rest % 3;
            b = rest / 3;
            counts += b;  // 能喝多少瓶汽水
            rest = a + b;
        }
        if(rest +1 == 3)
            counts += 1;
        return counts;
    }
}
