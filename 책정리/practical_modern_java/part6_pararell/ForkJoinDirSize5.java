package 책정리.practical_modern_java.part6_pararell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import javax.sound.sampled.SourceDataLine;

/*
 * date: 22.06.18
 * page: 198
 */

public class ForkJoinDirSize5 extends RecursiveTask<Long>{
    
    private final Path path;

    public ForkJoinDirSize5(Path path){
        this.path = path;
    }

    @Override
    protected Long compute() {
        long fileSize = 0;

        if(Files.isDirectory(path)){
            try {
                List<Path> fileList = Files.list(path).collect(Collectors.toList());
                List<ForkJoinDirSize5> subTaskList = new ArrayList<>();

                for(Path file : fileList){
                    ForkJoinDirSize5 subTask = new ForkJoinDirSize5(file);
                    subTask.fork();
                    subTaskList.add(subTask);
                }

                Long subSize = 0L;

                for(ForkJoinDirSize5 subTask : subTaskList){
                    subSize += subTask.join();
                }
                return subSize;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try{
                fileSize = Files.size(path);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return fileSize;
    }

    public static void main(String[] args) {
        Path rootPath = Paths.get("./java_collection/practical_모던자바/");
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("병렬 처리 크기 = " + pool.getParallelism());
        System.out.println(pool.invoke(new ForkJoinDirSize5(rootPath)));
    }
}
