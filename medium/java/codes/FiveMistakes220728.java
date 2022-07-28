package medium.java.codes;

import java.util.Objects;

/**
 * https://medium.com/javarevisited/5-mistakes-99-java-developers-makes-2bc4b0e49ace
 */

public class FiveMistakes220728 {
    public static void main(String[] args) {
        int a = 3;
        System.out.println(a == 3);
        System.out.println(Objects.equals(a, 3));

        long b = 3L;
        System.out.println(b == 3L);
        System.out.println(Objects.equals(b, 3L));

        Long c = 3L;
        System.out.println(c == 3L);
        // 3L을 넘겨주면 true가 나오지만, 3을 넘기면 false가 나온다.
        System.out.println(Objects.equals(c, 3));
    }
}
