package 강좌정리.코틀린입문.codes.section4

fun main(){
    PersonV6.Companion.newBaby("hi")
    PersonV7.newBaby("hihi")
    PersonV8.newBaby("hihihi")
}

class PersonV6 private constructor(
        var name: String,
        var age: Int
){
    companion object{
        private const val MIN_AGE = 1
        fun newBaby(name: String) : PersonV6 {
            return PersonV6(name, MIN_AGE)
        }
    }
}

class PersonV7 private constructor(
        var name: String,
        var age: Int
){
    companion object{
        private const val MIN_AGE = 1
        @JvmStatic
        fun newBaby(name: String) : PersonV7 {
            return PersonV7(name, MIN_AGE)
        }
    }
}

class PersonV8 private constructor(
        var name: String,
        var age: Int
){
    companion object GotName{
        private const val MIN_AGE = 1
        fun newBaby(name: String) : PersonV8 {
            return PersonV8(name, MIN_AGE)
        }
    }
}