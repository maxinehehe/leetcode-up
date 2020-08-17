package june.code.byhehe.forOffer;

import java.util.*;

public class Dijkstra {
    private Queue visited;
    int[] distance;

    public Dijkstra(int len) {
        // TODO Auto-generated constructor stub
        visited = new LinkedList();
        distance = new int[len];

    }

    private int getIndex(Queue q, int[] dis) {
        int k = -1;
        int min_num = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            if (!q.contains(i)) {
                if (dis[i] < min_num) {
                    min_num = dis[i];
                    k = i;
                }
            }
        }
        return k;
    }

    public void dijkstra(int[][] weight, Object[] str, int v) {
        HashMap path;
        path = new HashMap();
        for (int i = 0; i < str.length; i++)
            path.put(i, "");

        //初始化路径长度数组distance
        for (int i = 0; i < str.length; i++) {
            path.put(i, path.get(i) + "" + str[v]);
            if (i == v)
                distance[i] = 0;
            else if (weight[v][i] != -1) {
                distance[i] = weight[v][i];
                path.put(i, path.get(i) + "-->" + str[i]);
            } else
                distance[i] = Integer.MAX_VALUE;
        }
        visited.add(v);
        while (visited.size() < str.length) {
            int k = getIndex(visited, distance);//获取未访问点中距离源点最近的点
            visited.add(k);
            if (k != -1) {

                for (int j = 0; j < str.length; j++) {
                    if (weight[k][j] != -1)//判断k点能够直接到达的点
                    {
                        //通过遍历各点，比较是否有比当前更短的路径，有的话，则更新distance，并更新path。
                        if (distance[j] > distance[k] + weight[k][j]) {
                            distance[j] = distance[k] + weight[k][j];
                            path.put(j, path.get(k) + "-->" + str[j]);
                        }
                    }

                }
            }
        }

        for(int h=0;h<str.length;h++)
        {
            System.out.printf(str[v]+"-->"+str[h]+":"+distance[h]+" ");
            if(distance[h]==Integer.MAX_VALUE)
                System.out.print(str[v]+"-->"+str[h]+"之间没有可通行路径");
            else
                System.out.print(str[v]+"-"+str[h]+"之间有最短路径，具体路径为："+path.get(h).toString());
            System.out.println();
        }
        visited.clear();

    }

    public static void main(String[] args) {
        int[][] weight = {
                {0, 15, -1, 50},
                {-1, 0, 15, 30},
                {-1, -1, 0, 10},
                {-1, -1, -1, 0}
        };
        String[] str={"V0", "V1", "V2","v3"};
        int len=str.length;
        Dijkstra dijkstra=new Dijkstra(len);
        //依次让各点当源点，并调用dijkstra函数
        dijkstra.dijkstra(weight, str, 0);
        System.out.println("测试结果：");
        System.out.println(dijkstra.distance[3]);
        System.out.println("所有结果：\n\n");
        for(int i=0;i<str.length;i++)
        {
            dijkstra.dijkstra(weight, str, i);
        }
//        for(int i=0;i<str.length;i++)
    /*
        int N, P;  // N 表示 有多少点 P 表示通道数
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = sc.nextInt();
        int[][] weight = new int[N][N];
        // 初始化 为 -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                weight[i][j] = -1;
                if (i == j)
                    weight[i][j] = 0;

            }
        }
        int a, b, v;
        for (int i = 0; i < P; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            v = sc.nextInt();
            weight[a][b] = v;
        }
        int dest = sc.nextInt();
        String[] str = new String[N]; // {"V0", "V1", "V2","v3"};
        Dijkstra dijkstra = new Dijkstra(N);
//        //拿 0 当源点，并调用dijkstra函数
        dijkstra.dijkstra(weight, str, 0);
        System.out.println(dijkstra.distance[3]);
*/
    }
}

//        int[][] weight = {
//                {0, 15, -1, 50},
//                {-1, 0, 15, 30},
//                {-1, -1, 0, 10},
//                {-1, -1, -1, 0}
//        };
//        String[] str={"V0", "V1", "V2","v3"};
//        int len=str.length;
//        Dijkstra dijkstra=new Dijkstra(len);
//        //拿 0 当源点，并调用dijkstra函数
//        dijkstra.dijkstra(weight, str, 0);
//        // 其中 3 为 要的终点
//        System.out.println(dijkstra.distance[3]);
        // 计算所有  让各个点 当原点 到所有点的距离
//        for(int i=0;i<str.length;i++)
//        {
//            dijkstra.dijkstra(weight, str, i);
//        }
//    }

//}
