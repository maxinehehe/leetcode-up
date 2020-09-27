package june.code.byhehe.utils;

public class NewTest01 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(search(nums, nums[i])+" ");
        }
        System.out.println();

    }
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l <= r){
            int mid =(l+r)/2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[l] < nums[mid]){
                // 如果[l, mid] 是否有序 如果有序就在这边查找
                // 再判断 target 是否在 有序数组中 是则在此搜索 否则在隔壁搜索
                if(nums[l] <= target && target<nums[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }else{
                // 说明 [mid+1, r] 有序 那么在这里做文章
                // 判断 target 是否在这个范围内
                if(nums[mid] < target && target <= nums[r])
                    // 写法一样? nums[mid+1] <= target && target <= nums[r]
                    // 错误 上面那个越界了 如果查找的数 不在 其中就会报错
                    l = mid+1;
                else
                    r = mid-1;
            }
        }
        return -1;
    }
}
