package 책정리.practical_modern_java.part5_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("이서연", 22));
        personList.add(new Person("이종원", 23));
        personList.add(new Person("조남준", 24));

        List<Person> collect = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
