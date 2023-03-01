
/*    modifier UNIQUEMENT la ligne suivante, le reste du code doit rester inchangé   */
fun foo(name: String, number: Int, toUpperCase: Boolean) : String 
{
    val resultat = if (toUpperCase) name.uppercase() else name
    // uppercase() transforme la chaine considérée en majuscule
    return resultat + number
}

fun main() {
    println(if (foo("a") == "a42") "OK" else "ko")
    println(if (foo("b", number = 1) == "b1") "OK"  else "ko")
    println(if (foo("c", toUpperCase = true) == "C42") "OK"  else "ko")
    println(if (foo(name = "d", number = 2, toUpperCase = true) == "D2") "OK" else "ko" )
}



