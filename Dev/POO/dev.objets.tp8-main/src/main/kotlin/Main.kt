import iut.math.SquareMatrix

fun main() {
    var m = SquareMatrix(5)
    println("# affiche une matrice nulle d'ordre 5")
    println(m)

    m = SquareMatrix(5)
    m.setAsIdentity()
    println("# affiche une matrice identité d'ordre 5")
    println(m)

    m = SquareMatrix(5)
    m.randomize(-10, 10)
    println("# affiche une matrice remplie de valeurs aléatoire entre -10 et 10")
    println(m)
}