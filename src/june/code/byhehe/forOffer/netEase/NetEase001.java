package june.code.byhehe.forOffer.netEase;

import java.util.HashMap;
import java.util.Scanner;

public class NetEase001 {
    public static void main(String[] args) {
        // 构建树
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 总节点数
        int m = Integer.valueOf(line.split(" ")[0]);
        // 总边数
        int n = Integer.valueOf(line.split(" ")[1]);
        TreeNode root = null;
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int a = Integer.valueOf(s.split(" ")[0]);
            String leftOrright = s.split(" ")[1];
            int b = Integer.valueOf(s.split(" ")[2]);

            if(!map.containsKey(a)){
                TreeNode nodea = new TreeNode(a);
                map.put(a, nodea);
            }
            if(!map.containsKey(b)){
                TreeNode nodeb = new TreeNode(b);
                map.put(b, nodeb);
            }
            if("left".equals(leftOrright)){
                map.get(a).left = map.get(b);
            }else if("right".equals(leftOrright)){
                map.get(a).right = map.get(b);
            }
        }
        // 构建结束
        MyNE001 myNE001 = new MyNE001();
        int res = myNE001.getRes(map.get(1));
        System.out.println(res);
    }
}

class MyNE001{
    public int count = 0;
    public int getRes(TreeNode root){
        dfs(root);
        return count;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        if(root != null){

            if(root.left != null && root.left.left == null && root.left.right == null
                    && root.right!= null && root.right.left == null && root.right.right == null )
                count++;
        }
        if(root.left != null)
            dfs(root.left);
        if(root.right != null)
            dfs(root.right);
    }
}

class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }

}
