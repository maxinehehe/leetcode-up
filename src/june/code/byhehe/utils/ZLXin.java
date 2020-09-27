package june.code.byhehe.utils;



class Test123 extends Thread{
    String name;

    public static void main(String[] args) {
        Test123 t = new Test123();
        t.execute();
    }
    Test123(){}
    Test123(String name){
        this.name = name;
    }
    public String getThreadName(){
        return name;
    }
    public void execute(){
        Test123 first = new Test123("one");
        first.start();
        Test123 second = new Test123("two");
        second.start();
    }
    public void start(){
        for (int i = 0; i < 2; i++) {
            System.out.println(this.getThreadName()+i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ZLXin {

}
