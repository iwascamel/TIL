package 책정리.practical_modern_java.part6_pararell;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.23
 * page: 209
 */

public class InsuranceCalculatorBasic9 {
    public int calculatePrice(Map condition){
        int price = 10000;

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){

        }
        return price;
    }
    public static void main(String[] args) {
        InsuranceCalculatorBasic9 cal = new InsuranceCalculatorBasic9();

        for(int i=0;i<5;i++){
            System.out.println(cal.calculatePrice(null) + " i = " + i);
        }
    }
}
