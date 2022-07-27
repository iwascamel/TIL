package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.Executor;

/*
 * date: 22.06.14
 * page: 184
 */

 /*
  * Executor실행 방법
  * 제공되는게 얼마 없으므로 잘 사용되지 않는다.
  */

public class Executor1 implements Executor{

    @Override
    public void execute(Runnable command) {
        // 1번 방법
        command.run();

        // 2번 방법
        new Thread(command).start();
    }

    public static void main(String[] args) {
        Executor1 excecutor = new Executor1();
        excecutor.execute(()->System.out.println("run"));
    }
}
