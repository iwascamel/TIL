package 책정리.practical_modern_java.part6_pararell;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
/*
 * date: 22.06.20
 */

public class FutureExample7 {

    public Callable<Long> calSquare(long value){
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long returnValue = value*value;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("value 의 제곱근 = " + returnValue);
                return returnValue;
            }
        };
    }

    public void executeTest(){
        List<Long> sampleDataList = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L);
        List<Future<Long>> futureList = new ArrayList<>();
        ExecutorService servicePool = Executors.newFixedThreadPool(4);

        for(Long sampleValue : sampleDataList){
            Future<Long> future = servicePool.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        for(Future<Long> future : futureList){
            try{
                sumValue += future.get();
            }catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("최종 합계 = " + sumValue);
        servicePool.shutdown();
    }

    public static void main(String[] args) {
        FutureExample7 future = new FutureExample7();
        future.executeTest();
    }
}
