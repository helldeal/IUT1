import kotlin.random.Random

fun main() {
    val tableau = tableauAleatoireDistinct(10)
    print("[")
    for (v in tableau)
        print("$v-")
    println("]")
}

fun  tableauAleatoireDistinct(n : Int) : Array<Int> {
    var resultat = Array<Int>(n, {i -> 0})
    // tableau de taille n initialisé à 0
    TODO()
    return resultat
}