package exo4
import exo3.pile.Pile
import exo3.pile.PileException
import kotlin.random.Random

fun main() {
    val rdm = Random.nextInt(0,10)
    val pile =  Pile(rdm)
    println("q : quit / d : dépiler / nombre : empile")
    pileinteract(pile)
}
fun pileinteract(pile:Pile){
    try {
        var active = true
        while (active){
            print("Action :")
            val chaineLue = readln()
            if (chaineLue=="q")active=false
            else if (chaineLue=="d"){
                pile.depiler()
                println(pile)
            }
            else {
                pile.empiler(chaineLue.toInt())
                println(pile)
            }

        }
    }

    catch (e:PileException){
        println(e)
        pileinteract(pile)
    }
    catch (e:NumberFormatException){
        println("Nombre invalide")
        pileinteract(pile)
    }
    catch (e:IllegalArgumentException){
        println("Taille de la pile incorrect")
    }
}