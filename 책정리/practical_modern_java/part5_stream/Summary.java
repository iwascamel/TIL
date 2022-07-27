package 책정리.practical_modern_java.part5_stream;

import java.util.*;
import java.util.stream.Collectors;

public class Summary {
    public static void main(String[] args) {
        
        System.out.println("1. Map에서의 순회");
        Map<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.forEach((key,value) -> System.out.println("key = " + key + " value = " + value)); 

        System.out.println("2. stream filter to collection");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> newList = list.stream().filter(n->n%2==0).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(newList);

        System.out.println("3. reduce");
        int sum1 = list.stream().reduce(0, Integer::sum);
        int sum2 = list.stream().reduce(0, (x,y) -> x+y);
        int max = list.stream().reduce(0, Integer::max);
        int min = list.stream().reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println("Integer::sum = " + sum1);
        System.out.println("(x,y) -> x+y " + sum2);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
