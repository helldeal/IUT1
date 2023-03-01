package iut.collections

open class PileChainee<E>():Pile<E>  {

    protected var debut : Cellule<E>? = null

    override fun estVide(): Boolean {
        if (taille()==0) return true
        return false
    }

    override fun taille(): Int {
        var courant=debut
        var cpt=0
        while (courant!=null){
            courant=courant.suivant()
            cpt++
        }
        return cpt
    }

    override fun empiler(element: E) {
        debut= Cellule(element,debut)
    }

    override fun consulter(): E {
        if (this.estVide()) throw NoSuchElementException()
        return debut?.valeur()!!
    }

    override fun depiler(): E {
        if (this.estVide()) throw NoSuchElementException()
        var dep = debut?.valeur()
        debut=debut?.suivant()
        return dep!!
    }

}