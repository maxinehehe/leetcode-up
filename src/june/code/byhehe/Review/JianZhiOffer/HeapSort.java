package june.code.byhehe.Review.JianZhiOffer;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {4,3,5,1,8,9,3,7};
        HeapSortHelper heapSortHelper = new HeapSortHelper();
        heapSortHelper.heapSort(nums);
        for(int ele:nums)
            System.out.print(ele+" ");
    }
}

class HeapSortHelper{
    // 堆排序 建堆 与 排序
    public void heapSort(int[] nums){
        int n = nums.length;
        if(nums == null || n == 0)
            return;
        // 建堆
        for (int i = n/2-1; i >= 0; i--) {
            verifyHeap(nums, i, n);
        }

        // 排序
        for (int j = n-1; j>=0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;

            // 然后调整
            verifyHeap(nums, 0, j);
        }

    }
    // 建堆
    public void verifyHeap(int[] nums, int l, int length){
        // 首先先标记当前这个值
//        int k = l;
        int temp = nums[l];
        // 去看 左子树 2*l+1  因为下标从 0 开始 需要 2*i+1 才是左孩子
        for(int i = 2*l+1; i < length; i=2*i+1){
            if(i+1 < length && nums[i]<nums[i+1])
                i++;
            // 这里不能用 nums[l] <= nums[i]   因为 如果要和 nums[l] 比 就要采用 交换法
            // 不然 就是用 temp 保存暂存的原始值 不断往下走 正好是待比较的值
            if(temp <= nums[i]){
//                temp = nums[i];
                nums[l] = nums[i];
                l = i;
            }else {
                break;
            }

        }
        nums[l] = temp;
    }
}
