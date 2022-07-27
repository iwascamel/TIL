package 책정리.practical_modern_java.part6_pararell;

import java.util.concurrent.TimeUnit;

class MyTask implements Runnable{

    private final String id;

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("id = " + id + " current i = " + i);

            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public MyTask(String id){
        this.id = id;
    }
}