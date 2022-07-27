package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.14
 * page: 193
 */

/*
 * 아래와 같이 쓰레드 2개 제한일 때
 * 3개 쓰레드 실행 -> 2개 묶음 실행, 1개 실행, 2개 묶음 실행 -> 1개 실행...
 */

public class PeriodTask4 {
    public static void main(String[] args) {
        ScheduledExecutorService execService = Executors.newScheduledThreadPool(2);
        execService.scheduleWithFixedDelay(new MyTask("Thread 1"), 1, 2, TimeUnit.SECONDS);
        execService.scheduleAtFixedRate(new MyTask("Thread 2"), 1, 2, TimeUnit.SECONDS);
        execService.scheduleAtFixedRate(new MyTask("Thread 3"), 1, 2, TimeUnit.SECONDS);
    }
}
