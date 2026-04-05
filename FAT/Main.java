import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(52309,50);
        map.put(2897560,20);
        map.put(43247,40);
        map.put(30002,30);
        map.put(119023,10);
        System.out.println(map);

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            System.out.println(e.getKey().hashCode());
        }


        // System.out.println("Hello".hashCode());
    }
}