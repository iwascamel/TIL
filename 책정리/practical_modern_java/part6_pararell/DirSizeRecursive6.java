package 책정리.practical_modern_java.part6_pararell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * date: 22.06.18
 * page: 201
 */

public class DirSizeRecursive6 {

    protected static Long compute (Path path){
        long fileSize = 0;

        try{
            List<Path> fileList = Files.list(path).collect(Collectors.toCollection(ArrayList::new));

            for(Path file : fileList){
                if(Files.isDirectory(file)){
                    fileSize += compute(file);
                }else{
                    fileSize += Files.size(file);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return fileSize;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Path rootPath = Paths.get("./java_collection/practical_모던자바/");
        
        System.out.println("result = " + DirSizeRecursive6.compute(rootPath));
        long endTime = System.currentTimeMillis();

        System.out.println("처리시간 = " + (endTime - startTime));
    }
}
