package exo3

import exo3.pile.Pile
import exo3.pile.PileException
import kotlin.IllegalArgumentException

fun main() {
    try {
        val taille:Int=4
        val pile =  Pile(taille)

        println(pile)
        pile.empiler(42)
        pile.empiler(-4)
        pile.empiler(2)
        println(pile)
        println(pile.depiler())
        println(pile.depiler())
        println(pile)
        pile.empiler(2)
        pile.empiler(-42)
        pile.empiler(4)
        println(pile)
        println(pile.depiler())
        println(pile.depiler())
        println(pile.depiler())
        println(pile)
    }
    catch (e:IllegalArgumentException){
        println("Taille de la pile incorrect")
    }
    catch (e:PileException){
        println(e)
    }


}