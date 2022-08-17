package 강좌정리.코틀린입문.codes.section4

fun handleCountry(country: Country){
    when(country){
        Country.KOREA -> println("KOREA")
        Country.AMERICA -> println("US")
    }
}

enum class Country(
    private val code: String
){
    KOREA("KO"),
    AMERICA("US"),
}


fun handleCountryV2(country: CountryV2){
    when(country){
        CountryV2.KOREA -> println("KOREA")
        CountryV2.AMERICA -> println("US")
    }
}

enum class CountryV2(
        private val code: String
){
    KOREA("KO"),
    AMERICA("US"),
    A("A")
}


