package 책정리.다재다능코틀린프로그래밍.codes.chap8

import java.lang.RuntimeException

open class Vehicle(val year: Int, open var color: String){
    open val km = 0
    final override fun toString() = "year = $year, color = $color, km = $km"
    fun repaint(newColor: String){
        color = newColor
    }
}

open class Car(year:Int, color: String) : Vehicle(year, color){
    override var km: Int = 0
        set(value){
            if(value < 1){ 
                throw RuntimeException("에러!")
            }
            field = value
        }
    fun drive(distance: Int){
        km += distance
    }
}