package Java;

/*
 * date: 22.06.20
 */

import java.util.*;

public class EqualsExample{
    static class A{
        int index;

        public A(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return index == a.index;
        }
    }
    public static void main(String[] args) {
        Set<A> set = new HashSet<>();
        set.add(new A(1));
        set.add(new A(1));

        System.out.println(set.size());
    }
}