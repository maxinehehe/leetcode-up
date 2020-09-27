package june.code.byhehe.forOffer.GoodFuture;

public class SolutionDF01 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int target = 5;
        BinSol bs = new BinSol();
        System.out.println(bs.findBin(nums, target));
    }
}

class BinSol{
    public String findBinTwo(int[] nums, int target1, int target2){
        int res1 = findBin(nums, target1);
        int res2 = findBin(nums, target2);
        String s1 = "";
        if(res1 == -1){
            s1+="false,";
        }else{
            s1+=res1+",";
        }

        if(res2 == -1){
            s1+="false,";
        }else{
            s1+=res2+",";
        }

        return s1;

    }


    public int findBin(int[] nums ,int target){
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            else if(target < nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
