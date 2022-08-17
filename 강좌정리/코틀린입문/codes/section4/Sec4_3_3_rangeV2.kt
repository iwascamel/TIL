package 강좌정리.코틀린입문.codes.section4

class Car(
    internal val name: String,
    private var owner: String,
    _price: Int
){
    // public이 생략됐기 때문에 getter는 public
    var price = _price
        // setter만 private
        private set
}