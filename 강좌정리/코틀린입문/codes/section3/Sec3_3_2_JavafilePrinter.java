package 강좌정리.코틀린입문.codes.section3;

import java.io.*;

public class Sec3_3_2_JavafilePrinter {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    static void readFile() throws IOException{
        File cur = new File("./강좌정리/코틀린입문/codes/section3");
        File file = new File(cur.getAbsolutePath() + "/sec3_3_2_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        System.out.println(br.readLine());
        br.close();
    }
}
