package 책정리.practical_modern_java.part5_stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/*
 * date: 22.06.12
 * page: 152p
 */

public class MapIteratorExample {
    public static void main(String[] args) {
        Map<String,Person> map = new HashMap<>();
        map.put("1",new Person("A", 20));
        map.put("2",new Person("B", 21));
        map.put("3",new Person("C", 22));
        map.put("4",new Person("D", 23));
        map.put("5",new Person("E", 24));

        System.out.println("--1. Iterator 방식 --");
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String next = keys.next();
            System.out.println(String.format("Key : %s, Value %s", next,map.get(next)));
        }

        System.out.println("--2. Map Entry 방식 --");
        Set<Entry<String, Person>> entrySet = map.entrySet();
        for(Entry<String,Person> entry : entrySet){
            System.out.println(String.format("key = %s, value = %s", entry.getKey(),entry.getValue()));
        }

        System.out.println("--3. keyset 방식 --");
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println(String.format("key = %s, value = %s", key,map.get(key)));
        }

        System.out.println("--4. forEach 방식 --");
        map.forEach((key,value) -> System.out.println(String.format("key = %s, value = %s", key,value)));
    }
    
}
