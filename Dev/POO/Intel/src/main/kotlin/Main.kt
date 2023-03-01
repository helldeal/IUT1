fun main(args: Array<String>) {
    val xx = 3
    val yy = 5
    var resultat = sum(xx, yy)
    println(resultat)
    resultat = product(xx, yy)
    println(resultat)
    val arnaud = Personne("Arnaud", "Lanoix")
    arnaud.changerDeNom("Lanoix Brauer")
    println(arnaud.donnerNomComplet())
}
