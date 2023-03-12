package hook_files

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class LocalDateTimeTest {
}

fun main(){
    val instant = Instant.now()
    println(instant)
    val epochMillis = instant.toEpochMilli()
    println(epochMillis)
    // cms에서 넘어온 값
    val zoneId = ZoneId.systemDefault()
    val localDateTime = LocalDateTime.ofInstant(instant, zoneId)
    println(localDateTime)
}