package exo5
import exo3.pile.Pile
import exo3.pile.PileException
import kotlin.random.Random

fun main() {
    println(evaluation("3 2 4 * +"))
    println(evaluation("2 8 - 2 *"))
    println(evaluation("2 8 + 2 /"))
    println(evaluation("2 8 + /")) // erreur
    println(evaluation("2 8 + 2 4 /")) // erreur
}

fun evaluation(expression : String) : Int {
    var pile = Pile(10)
    var op1 : Int
    var op2: Int
    var tokens = expression.split(" ")
    for (token in tokens) {
        if (token!="*" && token!="+" && token!="-" && token!="/")
            pile.empiler(token.toInt())
        else{
            op2 = pile.depiler()
            op1 = pile.depiler()
            if (token == "+")
                pile.empiler(op1 + op2)
            if (token == "*")
                pile.empiler(op1 * op2)
            if (token == "-")
                pile.empiler(op1 - op2)
            if (token == "/")
                pile.empiler(op1 / op2)
        }
    }
    return  pile.depiler()
}