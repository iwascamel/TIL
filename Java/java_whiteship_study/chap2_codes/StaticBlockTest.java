package Java.java_whiteship_study.chap2_codes;

import java.util.Arrays;

public class StaticBlockTest {
    static int[] arr;

    static{
        arr = new int[10];

        for(int i=0;i<10;i++){
            arr[i] = (int)(Math.random()*10)+1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
    }
}
