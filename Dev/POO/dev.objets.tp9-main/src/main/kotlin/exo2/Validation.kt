package exo2

fun main() {
    val d = donneDoubleSaisi()
    println("La valeur saisie est $d")
}

fun donneDoubleSaisi() : Double {
    var result = 0.0
    print("Saisir un double : ")
    val chaineLue = readln()
    try {
        result = chaineLue.toDouble()
    }
    catch (e:NumberFormatException){
        println("$e\nRecommencez :")
        result= donneDoubleSaisi()
    }
    return result
}