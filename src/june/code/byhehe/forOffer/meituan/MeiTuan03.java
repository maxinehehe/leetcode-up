package june.code.byhehe.forOffer.meituan;
import java.util.*;
public class MeiTuan03 {
    public static void main(String[] args) {
        Sum1ToN2 stn = new Sum1ToN2();
        int res = stn.getRes(5,3,2);
        System.out.println(res);
    }
}

class Sum1ToN2 {
    private int count = 0;
    public int getRes(int n, int k, int d){
        List<Integer> list = new ArrayList<Integer>();
        f(n, list, 1, k, d);
        return count;
    }
    private void print(List<Integer> list) {
        for (Integer k : list) {
            System.out.print(k + "+");
        }
    }

    private void f(int n, List<Integer> list, int start,int k, int d) {
        if (n == 1) {
            print(list);
            System.out.println(1);
        } else {
            for (int i = start; i <=n / 2; i++) {
                if(i <= k && i>=1)
                    list.add(i);
                f(n - i, list, i, k, d);
                list.remove(list.size() -1);
            }
            Collections.sort(list);

            if(list.size()!=0 && list.get(list.size()-1)>=d)
                count++;
            print(list);
            System.out.println(n);

        }
    }

//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
////        new Sum1ToN().f(9,list, 1);
//    }

}

class Sum1ToN {

    private void print(List<Integer> list) {
        for (Integer k : list) {
            System.out.print(k + "+");
        }
    }

    private void f(int n, List<Integer> list, int start) {
        if (n == 1) {
            print(list);
            System.out.println(1);
        } else {
            for (int i = start; i <=n / 2; i++) {
                list.add(i);
                f(n - i, list, i);
                list.remove(list.size() -1);
            }
            print(list);
            System.out.println(n);

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        new Sum1ToN().f(5,list, 1);
    }

}
