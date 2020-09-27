package june.code.byhehe.utils;

public class HaiLaoTest {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("JO");
    }
    static void pong(){
        System.out.println("YY");
    }
}
