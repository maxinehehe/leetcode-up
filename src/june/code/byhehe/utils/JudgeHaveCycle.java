package june.code.byhehe.utils;

import java.util.*;

public class JudgeHaveCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] line = input.replace("[","")
                .replace("]","")
                .split(",");

        int start = Integer.valueOf(line[0]);
        int n = 0;
        for (int i = 0; i < line.length; i++) {
            int u = Integer.valueOf(line[i]);

            n = Math.max(n,u);
        }

        JudHaveCycle jhc = new JudHaveCycle(n);

        // 构建
        for (int i = 0; i < line.length-1; i+=2) {
            int u = Integer.valueOf(line[i]);
            int v = Integer.valueOf(line[i+1]);
//            System.out.println("u: "+u+" v: "+v);
            jhc.buildGraph(u,v);
        }

        if(jhc.isCycle(start)){
            System.out.println("N");
        }else {
            System.out.println("Y");
        }

    }

}
//[[1,2],[2,3],[3,4],[4,5],[2,5]]

class JudHaveCycle{
    public List<Integer>[] graph;
    int[] arrived;
    public JudHaveCycle(int m){
        this.graph = new LinkedList[m+1];
        // 需要进行创建并初始化
        for (int i = 0; i < m + 1; i++) {
            this.graph[i] = new LinkedList<>();
        }
        this.arrived = new int[m+1];
        Arrays.fill(arrived, Integer.MAX_VALUE);
    }

    public void buildGraph(int u, int v){
        graph[u].add(v);
//        graph[v].add(u);

    }

    public boolean isCycle(int start){
        Deque<Integer> deque = new LinkedList<>();
        deque.push(start);
        while (!deque.isEmpty()){
            int poll = deque.poll();
            arrived[poll] = 0;  // 表示已到达
            for(int v:graph[poll]){
                if(arrived[v] == Integer.MAX_VALUE){
                    deque.push(v);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
