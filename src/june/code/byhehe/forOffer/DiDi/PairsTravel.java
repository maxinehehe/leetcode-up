package june.code.byhehe.forOffer.DiDi;
import java.util.*;
/*
滴滴 第二题 巴黎旅行

 */
public class PairsTravel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<int[]>[] ways = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                ways[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                // 构造带权无向图 互相添加
                int cost = sc.nextInt();
                int[] lr = {r, cost};
                ways[l].add(lr);
                int[] rl = {l, cost};
                ways[r].add(rl);
            }
            // 输入形式 1 4 7.9/8  学到了 使用 nextInt 和 next进行接收
            int start = sc.nextInt();
            int tar = sc.nextInt();
            String time = sc.next();

            // 标记是否已经到过
            int[] arrived = new int[n + 1];
            // 初始化 最开始都是没有到达过 相当于不可达
            Arrays.fill(arrived, Integer.MAX_VALUE);
            Deque<int[]> list = new LinkedList<>();
            list.add(new int[]{start, 0});
            while (!list.isEmpty()) {
                int[] cur = list.poll();
                int pos = cur[0]; // 当前位置
                int cost = cur[1]; // 花费代价
                // 看是否 到达这个位置的代价更小 如果更小 则进行更新
                if (cost < arrived[pos]) {
                    arrived[pos] = cost;
                    for (int[] arr : ways[pos]) {
                        /* 下面一句表示 比如 当前点是 A 他能到达 B, C
                            他表示 A 到达 B 之后 从起点算起 那么经过 A 到达 B 的花费 cost1 是否小于 目前 B 自身拥有的代价值
                            如果小于 则进行更新 代价， 同样 A 到达 C 也是一样。
                            这一题 需要注意的是 由于 我们需要找到 花费代价最小路径， 因此 就需要 BFS 遍历所有路径，即从起点开始 走过的所有路径
                            找到其中一条能够到达 重点（E）的路径， 并取出其最小代价， 因为 我们针对每个点 算的都是 最小花费代价路径。
                         */
                        if (arr[1] + cost < arrived[arr[0]]) {
                            list.add(new int[]{arr[0], arr[1] + cost});
                        }
                    }
                }
            }
            // 取出 重点的最小化费代价
            int res = arrived[tar];
            // 根据代价 和 当前时间进行计算 转换后的日期。
            String out = help(res, time);
            System.out.println(out);
            System.out.println(res);
        }
    }
    // 0~13 其中 1~12 表示 1~12个月
    static int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String help(int res, String time) {
        // time   =  "7.9/10"
        String[] temp = time.split("\\.");
        int month = Integer.parseInt(temp[0]);
        temp = temp[1].split("/");
        int day = Integer.parseInt(temp[0]);
        int hour = Integer.parseInt(temp[1]);

        hour += res;
        if (hour >= 24) {
            day += hour / 24;
            hour = hour % 24;
        }
        while (day > months[month]) {
            day -= months[month];
            month++;
        }
        StringBuilder arrive = new StringBuilder();
        arrive.append(month).append(".")
                .append(day).append("/").append(hour);

        return arrive.toString();
    }
}



