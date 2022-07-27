package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.23
 * page: 207
 */

public class CompletableFuture8 {
    public static void main(String[] args) {
        Runnable mainTask = ()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("Main Task : " + Thread.currentThread().getName());
        };

        Runnable subTask = ()->{
            System.out.println("next task  = " + Thread.currentThread().getName());
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        CompletableFuture.runAsync(mainTask,executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,executor).thenRun(subTask);

    }
}
