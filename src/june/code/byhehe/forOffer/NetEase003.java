package june.code.byhehe.forOffer;

import java.util.HashMap;
import java.util.Scanner;

public class NetEase003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();



        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            NESlo nes = new NESlo();
            nes.steps = 0;
            for (int j = 0; j < m; j++) {
                int[] nums = new int[2];
                nums[0] = sc.nextInt();
                nums[1] = sc.nextInt();
                if(nums[1] == -1)
                    continue;
                nes.move(nums);
            }
            System.out.println(nes.steps);
        }
    }
}
class NESlo{
    public int steps;
    public HashMap<Integer, Integer> map;
    public NESlo(){
        this.steps = 0;
        this.map  = new HashMap<Integer, Integer>();
            map.put(0,0); // 上
            map.put(1,0);  // 下
            map.put(2,0);
            map.put(3,0);
    }
    public void move(int[] nums){
        if(nums.length == 0)
            return ;
        switch (nums[0]){
            case 0:
                if(map.get(1).intValue() == 0){
                    steps++;
                    map.put(0,map.get(0) + 1);
                }else {
                    map.put(1, map.get(1) - 1);
                    steps--;
                }
            case 1:
                if(map.get(0).intValue() == 0){
                    steps++;
                    map.put(1,map.get(1)+1);
                }else {
                    map.put(0, map.get(0) - 1);
                    steps--;
                }
            case 2:
                if(map.get(3).intValue() == 0){
                    steps++;
                    map.put(2,map.get(2) + 1);
                }else {
                    map.put(3, map.get(3) - 1);
                    steps--;
                }
            case 3:
                if(map.get(2).intValue() == 0){
                    steps++;
                    map.put(3,map.get(3) + 1);
                }else {
                    map.put(2, map.get(2) - 1);
                    steps--;
                }
            default:;
        }
        System.out.println("steps: "+steps);
    }
}
