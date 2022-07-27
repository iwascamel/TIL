package 책정리.practical_modern_java.part5_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * date: 22.06.12
 * page: 147p
 */

public class StreamSortedExample2 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("이종원", 23));
        personList.add(new Person("임얼쑤", 29));
        personList.add(new Person("이서연", 22));
        personList.add(new Person("조남준", 24));

        personList.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);;
        
    }
}
