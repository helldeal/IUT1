package exo3.pile

class Pile(taille : Int = 10) {

    private val valeurs : Array<Int?>
    private var sommet : Int

    init {
        if (taille<1)throw IllegalArgumentException()
        valeurs = arrayOfNulls(taille)
        sommet = -1
    }

    private fun estVide() =
        (sommet == -1)

    private fun estPleine() =
        (sommet == valeurs.size-1)

    fun empiler(elt : Int) {
        if (this.estPleine())throw PileException("Deja plein")
        valeurs[++sommet] = elt
    }

    fun depiler() : Int {
        if (this.estVide())throw PileException("Deja vide")
        return valeurs[sommet--]!!
    }

    override fun toString(): String {
        var str = "["
        for (i in 0 .. sommet)
            str += "> ${valeurs[i]} "
        return str + "]"
    }
}