package june.code.byhehe.utils;

import java.util.*;

public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int length = (String.valueOf(n)).length();
//        int [] nums = {9,7,2,8,4};
        long[] nums = new long[length];
        for (int i = length-1; i >= 0; i--) {
            nums[i] = n % 10;
            n = n / 10;
        }
        System.out.println(permute(nums, m).size());
    }

    public static List<List<Long>> permute(long[] nums, int m) {
        List<List<Long>> allList = new ArrayList<>();
        if(nums.length == 0)return allList;
        List<Long> list = new ArrayList<>();

        for(long ele:nums)
            list.add(ele);
        backTracking(nums.length, allList, list, 0, m);

//        System.out.println(allList);
        return allList;
    }
    // 坚定地回溯法
    public static void backTracking(int n, List<List<Long>> allList,
                                    List<Long> list, int pos, int m){
        // 剪枝 前导为 0 的
        if(pos == n && list.get(0) != 0 && !allList.contains(list)){
            // 表示已经走到了界限之外
            long res = 0L;
            for (int i = 0; i < list.size(); i++) {
                res = res * 10 + list.get(i);
            }
            if(res%m != 0)
                return;
            allList.add(new ArrayList<>(list)); // 这里必须new 一个 不然他们使用的都是同一个容器
            return ;
        }
        // 下面进行判断 i pos的位置
        for(int i = pos; i < n; i++){
            // 先进行交换
            Collections.swap(list, i, pos);
            // 然后进行回溯法 即带着当前值进行 一定要有 +1 的操作 不然无法进去 更无从谈回溯
            backTracking(n, allList, list, pos+1, m);  // 向下一层
            // 开始回退 回溯法的关进步骤
            Collections.swap(list, i, pos);
        }
        return ;
    }
}
