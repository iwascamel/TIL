package 강좌정리.코틀린입문.codes.section4

fun isDirectory(path: String): Boolean{
    return path.endsWith("/")
}