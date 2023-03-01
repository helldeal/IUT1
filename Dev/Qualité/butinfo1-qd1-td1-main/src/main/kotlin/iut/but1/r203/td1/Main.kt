package iut.but1.r203.td1

fun main(args: Array<String>) {
    val op = Operations()
    val a = 1
    val b = 2
    val c: Int = op.additionner(arrayOf<Int>(a, b))
    println("Le resultat de l addition entre a=$a et b=$b est c=$c")

    println(op.additionner(arrayOf<Int>(1,2,3)))
    println(op.soustraire(arrayOf<Int>(1,2,3)))
    println(op.multiplier(arrayOf<Int>(1,2,3)))
}