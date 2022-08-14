package 강좌정리.코틀린입문.codes.section3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(){
    readFile()
}
fun readFile(){
    val curFile = File("./강좌정리/코틀린입문/codes/section3")
    val file = File(curFile.absolutePath + "/sec3_3_2_input.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}
