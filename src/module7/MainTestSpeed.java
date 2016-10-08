package module7;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainTestSpeed {

    private static void CheckTimeList(List<Integer> intList, int count, String comment) {
        System.out.println(comment);
        System.out.println("add");
        Random random = new Random();
        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            intList.add(random.nextInt(count));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("set");
        start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            intList.set(i,random.nextInt(count));
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("get");
        start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            intList.get(i);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("remove");
        start = System.currentTimeMillis();
        while(intList.size() > 0)
            intList.remove(intList.size()-1);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    private static String randomString(final int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }

    private static void CheckTimeList4String(List<String> strList, int count, String comment) {
        System.out.println(comment);
        System.out.println("add");
        String str = randomString(10);
        System.out.println(str);

        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            strList.add(str);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("set");
        start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            strList.set(i,str);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("get");
        start = System.currentTimeMillis();
        for(int i=0; i<count; i++)
            strList.get(i);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        System.out.println("remove");
        start = System.currentTimeMillis();
        while(strList.size() > 0)
            strList.remove(strList.size()-1);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    public static void main(String[] args) {
        CheckTimeList(new ArrayList<>(), 1000, "ArrayList 1000");
        CheckTimeList(new LinkedList<>(), 1000, "LinkedList 1000");
        CheckTimeList(new ArrayList<>(), 10000, "ArrayList 10000");
        CheckTimeList(new LinkedList<>(), 10000, "LinkedList 10000");

        CheckTimeList4String(new ArrayList<>(), 1000, "String ArrayList 1000");
        CheckTimeList4String(new LinkedList<>(), 1000, "String LinkedList 1000");
        CheckTimeList4String(new ArrayList<>(), 10000, "String ArrayList 10000");
        CheckTimeList4String(new LinkedList<>(), 10000, "String LinkedList 10000");
    }
}
