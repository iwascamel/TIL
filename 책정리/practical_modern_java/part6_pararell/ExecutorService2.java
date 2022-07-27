package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.14
 * page: 185
 */

/*
 * 기본적인 Executors 사용법
 */

public class ExecutorService2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);

        exec.execute(new MyTask("Thread 1"));
        exec.execute(new MyTask("Thread 2"));
        exec.execute(new MyTask("Thread 3"));
        exec.shutdown();
    }

}
