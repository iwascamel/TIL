package 책정리.practical_modern_java.part5_stream;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.*;
/*
 * date: 22.06.12
 * page: 139p
 */

public class StreamDistinctExample2 {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("이서연", 22));
        personList.add(new Person("이종원", 23));
        personList.add(new Person("조남준", 24));

        personList.stream().filter(distinctByKey(b -> (b.name + b.age))).forEach(System.out::println);
    }
}