package Java.EqualsAndHashcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * 만약 int[] 배열이 주어졌을 경우? 혹은 참조형?
 */

public class EqualsAndHashCodeV2 {
    static class A{
        Map<Integer,Integer> index;
        int a;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a1 = (A) o;
            return a == a1.a && Objects.equals(index, a1.index);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, a);
        }
    }

    static class B{
        int[] index;
        int a;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            B b = (B) o;
            return a == b.a && Arrays.equals(index, b.index);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(a);
            result = 31 * result + Arrays.hashCode(index);
            return result;
        }
    }
}
