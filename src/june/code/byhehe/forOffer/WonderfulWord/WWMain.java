package june.code.byhehe.forOffer.WonderfulWord;

public class WWMain {
    public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");

        if(s1 == s2){
            System.out.println("s1 == s2");
        }else {
            System.out.println("s1 != s2");
        }

        if(s1.equals(s2)){
            System.out.println("s1 equals s2");
        }else {
            System.out.println("s1 not equals s2");
        }

    }

}
