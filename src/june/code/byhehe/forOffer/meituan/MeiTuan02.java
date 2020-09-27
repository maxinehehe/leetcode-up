package june.code.byhehe.forOffer.meituan;

import java.util.Scanner;

public class MeiTuan02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            MeiTuan002 mt = new MeiTuan002();
//            k = (k!=1)?(k-1):k;
            int res = mt.getRes(nums, n, m, k);
            System.out.println(res);
        }
    }
}

/*
8 2 5
5 5 5 4 5 5 5 5
5
4 1 6
7 8 2 6
 */
class MeiTuan002{
    public int getRes(int[] nums, int n, int m, int k){
        // 先暴力
        int len = nums.length;
        if(nums == null || len == 0 || m > n)
            return 0;
        int count = 0;
        for (int i = 0; i <= len - m; i++) {
            if(isOk(nums, i, i+m-1, k))
                count++;
        }
        return count;
    }
    public boolean isOk(int[] nums, int l, int r, int k){
        if(l>r)
            return false;
        for (int i = l; i <= r; i++) {
            if(nums[i] < k)
                return false;
        }
        return true;
    }
}

