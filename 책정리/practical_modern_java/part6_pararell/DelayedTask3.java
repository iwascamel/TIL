package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.14
 * page: 190
 */

public class DelayedTask3 {
    public static void main(String[] args) {
        ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();
   
        // TimeUnit은 시간단위
        // execService.schedule(()->System.out.println("Thread 1"), 1, TimeUnit.SECONDS);
        // execService.schedule(()->System.out.println("Thread 2"), 2, TimeUnit.SECONDS);
        // execService.schedule(()->System.out.println("Thread 3"), 3, TimeUnit.SECONDS);

        // initialDelay만큼 대기했다가 실행, 다음부터는 delay 주기로 무한실행
        // 이전 작업 종료 후 + delay 시간 이후 다음 작업이 실행
        execService.scheduleWithFixedDelay(()->System.out.println("Thread 4"), 2,1 ,TimeUnit.SECONDS);
        // 이전 작업의 종료 여부와 상관없이 처음 initialDelay 이후 delay 간격으로 진행
        execService.scheduleAtFixedRate(()->System.out.println("Thread 5"), 2,1 ,TimeUnit.SECONDS);
    }
}
