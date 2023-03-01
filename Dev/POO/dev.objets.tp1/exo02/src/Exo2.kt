
const val MAX = 10_000
var x : Int = 0
var y = 12
var z : Boolean = true

fun main() {
    x = 2
    y++
    truc(y)
    z = (x == 2)
    if (inc(x) == 3)
        print("ok")
}

fun truc(a : Int) {
    println(a)
}

fun inc(a : Int) = a+1

