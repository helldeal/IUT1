package iut.collections

class Cellule<E>(valeur : E, suivant : Cellule<E>? = null) {

    private var valeur : E
    private var suivant : Cellule<E>?

    init {
        this.valeur = valeur
        this.suivant = suivant
    }

    fun valeur() = valeur

    fun suivant() = suivant

    fun modifieSuivant(nouveauSuivant : Cellule<E>?)  {
        suivant = nouveauSuivant
    }
}