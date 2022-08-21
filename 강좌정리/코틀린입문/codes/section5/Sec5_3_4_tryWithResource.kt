package 강좌정리.코틀린입문.codes.section5

import java.io.BufferedReader
import java.io.FileReader

class FilePrinter{
    fun readFile(path: String){
        BufferedReader(FileReader(path)).use{
            reader -> println(reader.readLine())
        }
    }
}