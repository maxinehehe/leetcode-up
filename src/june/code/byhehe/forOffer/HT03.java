package june.code.byhehe.forOffer;

import java.util.*;


public class HT03 {
    public static int res;
    public static Map<Integer, TreeNode> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][4];
            for (int i = 0; i < n; i++) {

                    int a = sc.nextInt();  // num
                    int b = sc.nextInt();  // val
                    int c = sc.nextInt();   // left
                    int d = sc.nextInt();  // right
                    // 放到hashmap中
                    hashMap.put(a, new TreeNode(a,b,c,d));

            }
            for (int i = 0; i < n; i++) {
                dfs(i+1, 0);
            }
            System.out.println(res);

        }

    }
    public static void dfs(int root, int path){
        if(root == -1)
            return;
        res = Math.max(res, path);
        path ^= hashMap.get(root).val;
        // 应该判断 dfs 左右节点
        dfs(hashMap.get(root).left, path);
        dfs(hashMap.get(root).right, path);

    }
    // tree
    public static void getRes(int[][] arr){
        int max = Integer.MAX_VALUE;
        int count = arr[0][1];
        for (int i = 0; i < arr.length; i++) {
            count = count ^ arr[i][1];
            if(count > max)
                max = count;
        }
        System.out.println(max);
    }


}

// 考虑构造
class TreeNode{
    int num;
    int val;
    int left;
    int right;

    public TreeNode(int num, int val, int left, int right) {
        this.num = num;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
