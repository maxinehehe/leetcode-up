package june.code.byhehe.utils;

public class BinFind {

}

class findBinSplit{
    public int findIndex(int []nums, int l,int r){
        // 找到旋转中的分界点
        if(nums[l] < nums[r]) return 0;
        int mid;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }else{
                if(nums[mid] < nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return l;
    }
}
