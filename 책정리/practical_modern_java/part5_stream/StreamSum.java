package 책정리.practical_modern_java.part5_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * date: 22.06.13
 * page: 168
 */

public class StreamSum {
    public static void main(String[] args) {
        // final로 선언돼있지 않다면 컴파일 오류 발생
        // final이어도 수정할 수 있는 int[] 배열로 선언해서 더하기
        System.out.println("배열을 이용하는 방법 (자연스럽지는 않다)");
        int sum[] = {0};
        List<Integer> list = Arrays.asList(1,3,5,6,7);
        list.stream().forEach(v -> sum[0] += v);
        System.out.println(sum[0]);

        System.out.println("mapToInt를 이용하는 방법");
        int res = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(res);

        System.out.println("collect 이용");
        int sum2 = list.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum2);

        System.out.println("reduce 이용");
        int sum3 = list.stream().reduce(0,Integer::sum);
        System.out.println(sum3);

        System.out.println("reduce lambda 이용");
        int sum4 = list.stream().reduce(0, (x,y) -> x+y);
        System.out.println(sum4);
    }
}
