package 책정리.practical_modern_java.part6_pararell;

/*
 * date: 22.06.18
 * memo: fork-join 하면서 재귀 헷갈려서 작성
 */

 /*
  * memo: 맨 끝에 가면 물맥이 끊기고 올라감
  * if n<= 1:
  *     return n
  * n - n-1관계의 점화식처럼 생각하면 좋다.
  */

public class RecurseExample {
    static int recurse(int n){
        if(n<=1) return n;
        int sum = 0;
        sum += recurse(n-1) + n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(RecurseExample.recurse(10));
    }
}
