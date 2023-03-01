package iut.math

fun main() {

    // usage toString()
    var r23 = Rational(2,3)
    var r12 = Rational(1,2)
    var r43 = Rational(4,3)
    println(r23)     // 2/3
    println(r12)     // 1/2
    println(r43)     // 4/3
    println(Rational(3))      // 3/1
    println(Rational(0,6))     // 0/6
    println(Rational(2,2))     // 2/2



    // usage "+"
    println("#####   +")
    var result : Rational
    result = r23 + r12  // on peut utiliser le + car il ya la fonction plus()
    println(result) // 7/6
    result = r23 + r43
    println(result) // 18/9 ou (mieux) 6/3



    // usage "+ (entier)"
    println("#####   + int")
    result = r43 + 2
    println(result) // 10/3
    result = r43 + 0
    println(result) // 4/3

    //opposite
    println("#####   opp")
    println(r23.opposite()) // -2/3

    // usage -
    println("#####    -")
    println(r23 - r12) // 1/6

    //reduce
    println("#####   reduce")
    println(Rational(21,3).reduce()) // 7/1

    //opérateur
    println("#####   equal")
    var r36 = Rational(3,6)
    println(r23  == r12)   // false
    println(r23 != r12 )   // true
    println(r12 == r36 )   // true


    println("#####    compare")
    println(r23  > r12)   // true
    println(r23 <= r12 )   // false
    println(r12 <= r36 )   // true


    //usage *
    println("#####    *")
    println(r23  * r12)   // 1/3
    println(r23 * r36 )   // 1/3
    println(r12 * r36 )   // 1/4

    //usage inv
    println("#####    inverse")
    println(r23.inverse())   // 3/2

    //usage /
    println("#####      /")
    println(r23  / r12)   // 4/3
    println(r23 / r36 )   // 4/3
    println(r12 / r36 )   // 1
}
