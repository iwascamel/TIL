package 강좌정리.코틀린입문.codes.section3

import java.io.BufferedReader
import java.io.FileReader

fun main(){

}

fun readFile(path: String){
    BufferedReader(FileReader(path)).use{reader->{
        println(reader.readLine())
    }}
}