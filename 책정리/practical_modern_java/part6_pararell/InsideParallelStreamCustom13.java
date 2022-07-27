package 책정리.practical_modern_java.part6_pararell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * date: 22.06.27
 * page: 213
 */

 import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class InsideParallelStreamCustom13 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // 이 부분 추가
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
        System.out.println("thread pool size = " + ForkJoinPool.getCommonPoolParallelism());

        intList.parallelStream().forEach((value)->{
            String threadName= Thread.currentThread().getName();

            LocalDateTime currentTime = LocalDateTime.now();
            System.out.println(currentTime.format(formatter) + " thread name = " + threadName + "stream value = " +value );
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(Exception e){

            }
        });
    }
}
