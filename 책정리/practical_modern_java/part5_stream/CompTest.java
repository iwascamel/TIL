package 책정리.practical_modern_java.part5_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * date: 22.06.14
 * ref: https://broduck.tistory.com/5
 */

public class CompTest {

    static class A{
        int a;
        int b;

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {

        Comparator<A> comp = (o1, o2) -> {
            if(o1.a == o2.a){
                return Integer.compare(o2.b,o1.b);
            }else{
                return Integer.compare(o1.a,o2.a);
            }
        };

        PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparing(Person::getAge));
        
    }
}
