package june.code.byhehe.Review.StackAC;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class JZ23 {
    public static void main(String[] args) {

    }

    public boolean verifyIsBinSearch(int[] sequence){
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int start, int end){
        // 本质上 是通过二叉搜索树的性质判断的    左节点 < 根节点 < 右节点

        // 判断 如果一直走到了结尾 表明结果正确
        if(start >= end) return true;
        int i,j;
        int key = sequence[end];    // 结尾就是 树的根节点
        // 先从头开始找 找到 左右子树
        for(i = start; i < end; i++){
            if(sequence[i] > key)
                break;
        }
        // 现在 i 的位置 就是 右子树的最左子节点
        // 现在 根据性质判断 看是否有不符合
        for (j = i; j < end; j++) {
            if(sequence[j] <= key)    // -------------------------------------------- <=   -> <
                return false;   // 在这里如果还有差错 那就说明 不符合
        }

        // 然后再递归去判断 左右子树  只有左右子树结果都正确 结果才正确
        // 注意判断 右边序列为右子树时 注意序列最后一个数字已经用作根节点了 在判断 就去根据下一个节点判断
        return helper(sequence, start, i-1) && helper(sequence, i, end-1); // -------------------------- end -> end -1

    }


}
