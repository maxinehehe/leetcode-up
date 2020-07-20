package june.code.byhehe.utils;

public class BubleSort {
    public static void main(String[] args){
        int[] nums = new int[]{4,1,9,2,6,3};
//        sortBuble(nums);
//        heapSort(nums);
//        quickSort(nums,0, nums.length-1);
        mergeSort(nums, 0, nums.length-1);
        for(int ele:nums)
            System.out.print(ele+" ");
    }

    // 冒泡排序
    public static void sortBuble(int[] nums){
        int length = nums.length;
        // length - 1 是因为 最后一个不需要再比较
        for(int i = 0; i < length - 1; i++){
            // n - i - 1 因为 每一趟都会不断减少比较的数 之前比较排到后面的数就不需要在比较了
            for(int j = 0; j < length - i - 1 ; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

    }

    // 堆排序
    // 分为 排序和调整两个步骤
    public static void heapSort(int[] nums){
        // 先调整  从 length / 2 -1 开始
        for(int i = nums.length/2 ; i>=0; i--){
            verify(nums, i, nums.length);
        }
        // 进行排序 从末尾开始
        for(int j = nums.length-1; j>=0; j--){
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;

            verify(nums, 0, j);
        }

    }
    // 大根堆 处理 升序排序
    public static void verify(int[] nums, int i, int length){
        int temp = nums[i];
        // 下标 是从 0 开始的 所以需要 2*i+1
        // 关键步骤 2*i+1 出错
        for(int k = 2*i+1; k < length; k = k*2+1){
            if(k+1 < length && nums[k] < nums[k+1])
                k++;
            if(i<length && nums[k] > temp){
                nums[i] = nums[k];
                i = k;  // 记录位置
            }else {
                break;
            }
        }
        nums[i] = temp;
    }


    /**
     * 快排
     */
    public static void quickSort(int[] nums, int left, int right){
        int l = left;
        int r = right;

        if(l < r){
            int temp = nums[l];
            while(l < r){
                while(l<r && nums[r] >= temp)  // ------------
                    r--;
                if(l<r ){
                    nums[l] = nums[r];
                    l++;
                }
                while(l<r && nums[l] < temp)
                    l++;
                if(l<r){
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = temp;

            // 分两半进行 同样快排   -------------
            quickSort(nums, left ,l-1);  // 记住 枢纽 已经参与运算了 -1 +1
            quickSort(nums, l+1, right);
        }
    }

    // 归并排序
    public static void mergeSort(int[] nums, int l, int r){
        // 没有退出条件   ？？？？？？？？？
        if(l==r)
            return;
        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, r, mid);
    }

    public static void merge(int[] nums, int l, int r, int mid){
        int[] temp = new int[r-l+1];
        int p1 = l, p2 = mid+1;
        int index = 0;
        while (p1<=mid && p2<=r){
            temp[index++] = nums[p1] < nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1<=mid)
            temp[index++] = nums[p1++];
        while (p2<=r)
            temp[index++] = nums[p2++];

        System.arraycopy(temp, 0, nums, l, temp.length);
    }

}
