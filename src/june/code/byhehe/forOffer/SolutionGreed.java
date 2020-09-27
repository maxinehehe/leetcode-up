package june.code.byhehe.forOffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 贪心算法 问题
/*
可用于解决 区间调度问题， 比如 最典型的就是 今天有好几个活动，每个活动用区间 [start, end]表示的闭区间。
请问今天最多能参加几个活动？（也就是 这些区间中最多有几个互不相交的区间）
这一类问题的解决思路：
1. 从区间集合中intvs中选择一个区间 x , 这个 x 是 在当前所有区间中 结束最早的 （end最小）；
2. 把所有与 x 区间相交的区间从集合 intvs中删除。
3. 重复步骤 1 和步骤 2， 直到 intvs 为空为止。 之前选出的哪些 x 就是最大不相交的子集。
 */
public class SolutionGreed {
    public static void main(String[] args) {
        // 思路：尽量选择尽可能早结束的区间
        // 将这些区间 依照 end 进行排序， 然后 看相交吗
        // 测试
        int[][] intvs = new int[][]{
                {1, 4},
                {2, 5},
                {4, 9},
                {12, 22},
        };
//        System.out.println("贪心算法调度区间："+intervalScheduler(intvs));
        System.out.println(intervalScheduler(intvs));
    }
    public static int intervalScheduler(int[][] intvs){
        // Collections是针对 集合进行操作的  晕 没注意看
//        Collections.sort(intvs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                return a[1] - b[1];
//            }
//        });
        if(intvs.length == 0) return 0;
        int count = 1; // 默认等于 1 因为至少会有一个子集（区间）
        // 这里使用 Arrays 这个专门操作数组的家伙
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1]; // 等价于 使用 end 进行比较排序
                // a[1] > b[1] 进行升序排序
            }
        });
        // 开始进行查看找不相交的
        int cur_end = intvs[0][1];  // 当前end 排序后 第一个数组的 end
        for(int[] interval:intvs){
            int start = interval[0]; // 拿到start
            if(start >= cur_end){
                // 这时候找到一个区间 那么可以继续往下找
                count++;
                // 更新 当前end
                cur_end = interval[1]; // [start, end] 注意 interval[1]才是 end 不要用start更新
            }
        }
        return intvs.length - count;
    }
}

