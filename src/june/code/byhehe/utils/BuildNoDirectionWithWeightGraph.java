package june.code.byhehe.utils;

import java.util.*;

/**
 * 在有环无向带权图中 基于 BFS 求 S 到 E 的最短代价路径。
 * 步骤   构件图   ->    计算最短路径
 */
public class BuildNoDirectionWithWeightGraph {
    public List<int[]>[] graph;   // 路径图 ways 根据顶点数
    public int m;  // 节点数目
    public int[] arrived;  // 表示到达节点的 编号 和 代价   [顶点编号， cost]
    // 由于这里是使用 BFS 来完成 搜寻最小路径 因此 需要一个队列
    public Deque<int[]> deque;

    // 开始构建有环 无向带权图
//    public BuildNoDirectionWithWeightGraph(){}
    // 初始化

    public BuildNoDirectionWithWeightGraph(int m){
        this.m = m;
        this.graph = new List[m+1];
        // 需要进行创建并初始化
        for (int i = 0; i < m + 1; i++) {
            this.graph[i] = new ArrayList<>();
        }
        this.arrived = new int[m+1];
        // 初始化 权值到达数组
        Arrays.fill(this.arrived, Integer.MAX_VALUE);
        this.deque = new LinkedList<>();
    }

    // 构建形式 根据循环输入构建 构建形式 输入 ： u v cost
    // 表示 从顶点 u 到 v 或者 v 到 u 的代价是 cost。
    public void buildGraph(int u, int v, int cost){
        // 注意是无向图 带权
        int[] uv = {v, cost};
        this.graph[u].add(uv);
        int[] vu = {u, cost};
        this.graph[v].add(vu);

    }

//    public boolean isHaveCycle(int start, Set<Integer> set){
//        Deque<Integer> deque = new LinkedList<>();
//        deque.push(start);
//        set.add(start);
//        while (!deque.isEmpty()){
//            int poll = deque.poll();
//            for(int[] uv : this.graph[poll]){
//
//            }
//        }
//
//    }

    // 这里要求算法的是最短路径 那么我们 这里通过 BFS 方法来进行计算
    public int ShortestCostRoadWithBFS(int start, int end){
        // 首先是构建队列 并将 节点 start 入 队列
        // 处理特殊情况
        if(start == end)
            return 0;
        // 先加入其实节点 此时 其花费为 0
        this.deque.push(new int[]{start, 0});
        while (!this.deque.isEmpty()){
            int[] poll = this.deque.poll();// 出队列
            // 然后 找到 当前顶点 所能关联到的 所有顶点 判断权值 并放入队列
            int curPost = poll[0];    // 当前节点
            int cost = poll[1];   // 到当前节点所花费的代价

            // 先判断 当前代价是否比 arrived[curPost] 更小
            if(cost < this.arrived[curPost]){
                // 表示目前的代价 比当前 arrived[curPost] 从其他节点到达 curPost 的累计代价更小 则进行更新
                this.arrived[curPost] = cost;   // 更新 当前代价  表示 到这个节点的 代价 从当前路径 花费更小
                // 然后 在判断当前节点所相连的节点是否都能放入 队列
                for(int[] uv : this.graph[curPost]){
                    // 首先判断当前节点 有没有被访问过 或者说 它的代价是否更小  node 形式 表示 节点 curPost 所能到的节点 和代价
                    // [v, cost]
                    if(cost + uv[1] < this.arrived[uv[0]]){   // this.arrived[curPost] 错误
                        // cost + uv[1] < this.arrived[uv[0]] 表示 从 u -> v 比 v 现在所能从其他路径到 v 花费的代价更小
                        // 也就是说 每一次 他都会选取一个更小的边（权值） 来进行 放入
                        this.deque.push(new int[]{uv[0], uv[1]+cost});
                        // 其中 uv[0] 表示 从当前curPost能到达的节点v(不止一个)， uv[1]+cost 表示 花费的代价累积
                    }
                }
            }
        }
        return this.arrived[end];
    }

    // 测试数据
    /*
input:
第一行 m,n m 表示 节点数目， n 表示 边数
接下来 n 行表示 u v cost 即 节点 u 到 v 的花费代价
最后一行 s e 表示 起点和终点
input:
4 4
1 2 5
1 3 6
2 4 8
3 4 6
1 4
output:
一个数字 表示 起点 s 到终点 e 的最小化费代价
output:
12
*/
    public static class Test{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            // 初始化图
            BuildNoDirectionWithWeightGraph bgraph = new BuildNoDirectionWithWeightGraph(m);
            for (int i = 0; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int cost = sc.nextInt();
                bgraph.buildGraph(u, v, cost);
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            int res = bgraph.ShortestCostRoadWithBFS(start, end);
            System.out.println(res);

        }
    }
}
