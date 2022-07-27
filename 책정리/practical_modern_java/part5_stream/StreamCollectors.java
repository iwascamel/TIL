package 책정리.practical_modern_java.part5_stream;

import java.util.*;
import java.util.stream.Collectors;

/*
 * date: 22.06.12
 * page: 156p
 */


public class StreamCollectors {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("임얼쑤", 20));
        personList.add(new Person("이서연", 22));
        personList.add(new Person("이종원", 23));
        personList.add(new Person("조남준", 24));

        System.out.println("하나로 모아서 출력하기");
        ArrayList<String> collect = personList.stream().map(Person::getName).collect(Collectors.toCollection(ArrayList::new));
        List<String> collect2 = personList.stream().map((Person p) -> p.getName()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);

        String collect3 = personList.stream().map(Person::getName).collect(Collectors.joining(", "));
        System.out.println(collect3);

        Integer total = personList.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println(total);

        personList.stream().collect(Collectors.groupingBy(Person::getName));
    }
}
