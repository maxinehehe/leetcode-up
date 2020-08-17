package june.code.byhehe.utils;




import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Integer i01 = -128;
        int i02 = -128;
        Integer i03 = Integer.valueOf(-128);
        Integer i04 = new Integer(-128);
        System.out.println(i04 == i03);
        System.out.println(i01 == i02);
        System.out.println(i04 == i02);

//        System.out.println(2|4);
//        LinkedHashMap s;
//        TreeMap l;
//        "".substring()
//        @param      beginIndex   the beginning index, inclusive
//        seven();
//        eight();
//        nine();
////        ArrayList<Integer> arraysList = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.nextLine();
//            String[] strArr = str.trim().split(" ");
//            int sum = 0;
//            for (int i = 0; i <strArr.length; i++) {
//                sum += Integer.valueOf(strArr[i]);
//            }
//            System.out.println(sum);
//        }
    }
    public static void seven(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = sc.next();
        }


        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i==n-1?strArr[i]:strArr[i]+" ");
        }
        System.out.println(sb.toString());
    }

    public static void eight(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] sa = sc.nextLine().split(" ");
            Arrays.sort(sa, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

//            String str = StringUtils.join(Arrays.asList(sa), " ");
            StringBuilder sb = new StringBuilder();
            for(String str:sa){
                sb.append(str+" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
    public static void nine() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] sa = sc.nextLine().trim().split(",");
            Arrays.sort(sa, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

//            String str = StringUtils.join(Arrays.asList(sa), " ");
            StringBuilder sb = new StringBuilder();
            for (String str : sa) {
                sb.append(str + ",");
            }
            sb = sb.replace(sb.length()-1, sb.length(),"");
            System.out.println(sb.toString().trim());
        }

    }


}
