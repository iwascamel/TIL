package 책정리.practical_modern_java.part5_stream;

import java.util.Arrays;
import java.util.List;

/*
 * date: 22.06.13
 * page: 165 
 */

public class Match {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,8);
        
        System.out.println("모두 10보다 작은가");
        System.out.println(list.stream().allMatch(num -> num<10));

        System.out.println("3의 배수가 하나라도 포함돼있나");
        System.out.println(list.stream().anyMatch(num -> num%3 == 0));

        System.out.println("양수가 없나");
        System.out.println(list.stream().noneMatch(num -> num>0));
    }
}
