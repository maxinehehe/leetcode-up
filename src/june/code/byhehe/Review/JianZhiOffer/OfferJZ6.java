package june.code.byhehe.Review.JianZhiOffer;

public class OfferJZ6 {
    public static void main(String[] args) {
        JZ6 jz = new JZ6();
        int[] nums = {3,4,5,1,2};
        System.out.println(jz.minNumberInRotateArray(nums));
    }
}
class JZ6{
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if(n == 0)
            return 0;
        int l = 0, r = n-1;
        // 用二分
        int target  = array[n-1];
        while (l<r){
//            System.out.println("-");
            // 顺序
            int pivot = l + (r-l)/2;
            // 这里注意 如果 pivot -1 可能会错过最小值 因此 不能进行 pivot - 1
            if(array[pivot] < array[r])
                r = pivot;  // 那么 l <= r 也要改成 l < r
            else if(array[pivot] > array[r]) // 没理解
                l = pivot+1;
            else
                r--;   // 相等 可能会有重复值
        }
        return array[l];
    }
}
