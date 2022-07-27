package 책정리.practical_modern_java.part5_stream;

import java.util.Arrays;
import java.util.List;

import javax.print.attribute.SupportedValuesAttribute;

/*
 * date: 22.06.13
 * page: 173
 */

public class Reduce {
    static int debug(int x, int y){
        System.out.println("x = " + x + " y = " + y);
        return x+y;
    }
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1,2,3,4,5,6,7);

        Integer reduce = asList.stream().reduce(0,Reduce::debug);
        System.out.println("final sum = " + reduce);

        int max = asList.stream().reduce(0,Integer::max);
        int min = asList.stream().reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println(max);
        System.out.println(min);
    }
}
