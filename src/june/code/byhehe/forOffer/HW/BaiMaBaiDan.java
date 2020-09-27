package june.code.byhehe.forOffer.HW;

public class BaiMaBaiDan {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;
        // 切记 小马只能是偶数 不能一个一个加
        for (z = 68; z <= 80; z+=2) {
            x = (z>>1)*3 - 100;
            y = 200 - (z>>1)*5;
            System.out.println("大马: "+x + " 中马： "+y+" 小马： "+z);
        }
    }
}


