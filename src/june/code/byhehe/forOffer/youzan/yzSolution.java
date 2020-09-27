package june.code.byhehe.forOffer.youzan;

import java.util.*;

public class yzSolution{

}

class MySolution {


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
//        int [] nums = new int[operators.length];
        myLRU myLRU = new myLRU(k);
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] nums:operators){
            if(nums[0] == 1){
                myLRU.put(nums[1], nums[2]);
            }else if(nums[0] == 2){
                list.add(myLRU.get(nums[1]));
            }
        }
        int [] res = new int[list.size()];

        for (int ele: list){
            res[count] = ele;
            count++;
        }
        return res;
    }

}
class myLRU extends LinkedHashMap{
    public int capacity;
    public myLRU(){}
    public myLRU(int capacity){
        super(capacity,0.75f, true);
        this.capacity = capacity;
    }

//    @Override
//    public Object get(Object key) {
//        return super.get(key);
//    }

    public int get(int key){
        return (int)super.getOrDefault(key, -1);
    }
    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }


}