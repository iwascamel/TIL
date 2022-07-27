package 책정리.practical_modern_java.part6_pararell;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.23
 * page: 210
 */


public class InsuranceCalculatorExtend10 {
    public int calculatePrice(Map condition){
        int price = 10000;

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){

        }
        return price;
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();

        for(int i=0;i<5;i++){
            Future<Integer> future = service.submit(()->{
                return new InsuranceCalculatorExtend10().calculatePrice(null);
            });
            futureList.add(future);
        }

        futureList.forEach((future)->{
            try{
                // 계산 결과
                System.out.println(future.get());
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }
    public Future<Integer> calculatePriceAsync(Map condition){
        CompletableFuture<Integer> future = new CompletableFuture<>();
        
        new Thread(()->{
            int price = calculatePrice(condition);
            future.complete(price);
        }).start();
        return future;
    }
}
