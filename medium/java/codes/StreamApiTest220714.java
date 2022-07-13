package medium.java.codes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * date: 22.07.14
 */

public class StreamApiTest220714{
    public static class Person {
        private final String name;
        private final int age;
        private final Gender gender;
        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() { return name; }
        public int getAge() { return age; }
        public Gender getGender() { return gender; }
        @Override
        public String toString() {
            return "Person [age=" + age + ", gender=" + gender + ", name=" + name + "]";
        }

    }
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    static List<Person> personList = new ArrayList<>();
    public static void main(String[] args) {
        setPersonList();

        // 1. transforming
        personList.stream().map(Person::getName).collect(Collectors.toList()).forEach(System.out::println);

        // 2. filtering
        personList.stream().filter(p -> p.getAge()<25).collect(Collectors.toList()).forEach(System.out::println);
    }
    private static void setPersonList() {
        Person p1 = new Person("a", 15, Gender.MALE);
        Person p2 = new Person("b", 20, Gender.MALE);
        Person p3 = new Person("c", 23, Gender.MALE);
        Person p4 = new Person("d", 25, Gender.MALE);
        Person p5 = new Person("e", 30, Gender.MALE);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
    }
}