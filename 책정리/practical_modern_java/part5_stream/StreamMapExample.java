package 책정리.practical_modern_java.part5_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * date: 22.06.12
 * page: 149p
 */

public class StreamMapExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("이서연", 22));
        personList.add(new Person("이종원", 23));
        personList.add(new Person("조남준", 24));

        Stream<String> map = personList.stream().map((Person p) -> p.toString());
        map.forEach(System.out::println);

        personList.stream().map(Person::toString).forEach(System.out::println);
    }
}
