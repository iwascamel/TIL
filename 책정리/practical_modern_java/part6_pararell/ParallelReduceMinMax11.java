package 책정리.practical_modern_java.part6_pararell;

/*
 * date: 22.06.27
 * page: 212
 */

 import java.util.*;

public class ParallelReduceMinMax11 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);

        int max = intList.parallelStream().reduce(Integer.MIN_VALUE,Integer::max);

        System.out.println("max = " + max);
    }
}
