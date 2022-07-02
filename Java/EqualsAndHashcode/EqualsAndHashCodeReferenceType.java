package Java.EqualsAndHashcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * date: 22.07.02
 * 만약 int[] 배열이 주어졌을 경우? 혹은 참조형?
 */

public class EqualsAndHashCodeReferenceType {
    // map + int
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

    // int[] + int 
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
    // int[] + int + map(collection)
    static class C{
        int[] a;
        int b;
        Map<Integer,Integer> map;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            C c = (C) o;
            return b == c.b && Arrays.equals(a, c.a) && Objects.equals(map, c.map);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(b, map);
            result = 31 * result + Arrays.hashCode(a);
            return result;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,3};

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);

        Map<Integer,Integer> mapV2 = new HashMap<>();
        mapV2.put(1,2);

        // true
        System.out.println(Arrays.equals(a, b));
        // false
        System.out.println(Objects.equals(a, b));
        // true
        System.out.println(Objects.equals(map,mapV2));
    }
}
