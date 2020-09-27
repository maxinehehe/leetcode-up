package june.code.byhehe.Review.JianZhiOffer;

public class OfferJZ1 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 7;
        int[] arr = {4,7,10,13};
        JZ1Solution jz1 = new JZ1Solution();
        System.out.println(jz1.Find(target, nums));
//        System.out.println(jz1.binarySearch(arr, 7));
    }
}

class JZ1Solution{
    public boolean Find(int target, int [][] array) {
        int n = array.length;
        if(array == null || n == 0)
            return false;
        int m = array[0].length;
        for(int i = 0; i < n; i++){
            // 进行二分查找

            if(target > array[i][m-1])
                continue;
            else{
//                System.out.println(i+" - "+array[i][0]+" - "+array[i][m-1]);
                if(binarySearch(array[i], target)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target){

        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target)   // ????????  mid == target?????
                return true;
            else if(target>nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}