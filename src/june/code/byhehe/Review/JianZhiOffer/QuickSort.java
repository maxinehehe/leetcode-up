package june.code.byhehe.Review.JianZhiOffer;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4,3,5,1,8,9,3,7};
        QuickSortHelper quickSortHelper = new QuickSortHelper();
        quickSortHelper.quickSort(nums, 0, nums.length-1);
        for(int ele:nums)
            System.out.print(ele+" ");
    }
}
class QuickSortHelper{
    public void quickSort(int[] nums, int left, int right){
        int l = left;
        int r = right;
        if(l < r){
            // 保证 temp 中枢 右边的元素都大于 它 左边的元素都小于它
            int temp = nums[l];  // 暂存
            while (l<r){
                // 从右边开始判断
                while (l<r && nums[r]>temp){
                    r--;
                }
                if(l<r){
                    nums[l] = nums[r];
                    l++;
                }
                while (l<r && nums[l]<=temp){
                    l++;
                }
                if(l<r){
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = temp;
            // 进行 左右区间判断
            // 这里当前 l 或者 r 的位置就是 temp 中枢的位置 注意 区分开
            quickSort(nums,left, l-1);
            quickSort(nums,l+1, right);

        }
    }
}
