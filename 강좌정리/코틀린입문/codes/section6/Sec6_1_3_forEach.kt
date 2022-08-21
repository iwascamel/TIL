package 강좌정리.코틀린입문.codes.section5

fun main(){
    val numbers = listOf(1,2,3)

    // it 을 사용하는 것보다 parameter 명시가 권장된다.
    numbers.map{number -> number+1}
            .forEach{number -> println(number)}

    for(number in numbers){
        if(number == 2){
            break
        }
    }

    numbers.forEach{number->
        if(number == 2){
            // 에러!
//             break
        }
    }

    numbers.forEach{number->
        run{
            if(number == 2){
                return@run
            }
        }
    }

    // continue
    numbers.forEach{number->
        if(number == 2){
            return@forEach
        }
    }
}