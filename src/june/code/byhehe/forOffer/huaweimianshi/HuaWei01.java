package june.code.byhehe.forOffer.huaweimianshi;

import java.util.Arrays;

public class HuaWei01 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] lastOrder = {9,15,7,20,3};
        BuildTree bt = new BuildTree();
        TreeNode root = bt.build(inorder, lastOrder);
        bt.dfs(root);

    }
}
class BuildTree{
    public TreeNode build(int[] inOrder, int[] lastOrder){
        // 先找到 重合值
        if(inOrder == null || lastOrder == null || inOrder.length == 0 || lastOrder.length == 0)
            return null;

        int key = lastOrder[lastOrder.length-1];
        TreeNode root = new TreeNode(key);
        // 分界
        int i;
        for (i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == key)
                break;
        }
        root.left = build(Arrays.copyOfRange(inOrder, 0, i), Arrays.copyOfRange(lastOrder,0, i));
        root.right = build(Arrays.copyOfRange(inOrder, i+1, inOrder.length), Arrays.copyOfRange(lastOrder,i, lastOrder.length-1));

        return root;

    }

    public void dfs(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        if(root.left!=null)
            dfs(root.left);
        if(root.right!=null)
            dfs(root.right);
    }

}

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int val){
        this.val = val;
    }
}
