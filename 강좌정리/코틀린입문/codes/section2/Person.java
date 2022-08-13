package 강좌정리.코틀린입문.codes.section2;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    // @Nullable
    public String getName() {
        return name;
    }
}
