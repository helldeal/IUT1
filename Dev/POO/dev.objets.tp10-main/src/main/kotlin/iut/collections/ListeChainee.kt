package iut.collections

class ListeChainee<E>():Liste<E>, PileChainee<E>() {

    override fun index(element: E): Int {
        var cpt =0
        return cpt
    }

    override fun consulter(index: Int): E {
        if (index>this.taille())throw IndexOutOfBoundsException()
        return this.consulter()
        if (taille()==1)consulterEnTete()
        else{
            var c=debut
            for (i in 0 until index){
                c = debut!!.suivant()
            }

        }
    }

    override fun inserer(index: Int, element: E) {
        if (index>this.taille())throw IndexOutOfBoundsException()
        if (this.estVide())insererEnTete(element)
        else{
            var c=debut
            for (i in 0 until index-1){
                c = debut!!.suivant()
            }
            c?.modifieSuivant(Cellule(element,c?.suivant()))
        }
    }

    override fun supprimer(index: Int) {
        if (index>this.taille())throw IndexOutOfBoundsException()
        if (taille()==1)this.depiler()
        else{
            var c=debut
            for (i in 0 until index-1){
                c = debut!!.suivant()
            }
            c?.modifieSuivant(c?.suivant()?.suivant())
        }
    }

    override fun consulterEnQueue(): E {
        if (taille()<1)throw NoSuchElementException()
        return consulter(taille()-1)
    }

    override fun supprimerEnQueue() {
        if (taille()<1)throw NoSuchElementException()
        supprimer(taille()-1)
    }

    override fun insererEnQueue(element: E) {
        inserer(taille()-1,element)
    }

    override fun insererEnTete(element: E) {
        super.insererEnTete(element)
    }

    override fun supprimerEnTete() {
        super.supprimerEnTete()
    }

    override fun consulterEnTete(): E {
        return super.consulterEnTete()
    }
}