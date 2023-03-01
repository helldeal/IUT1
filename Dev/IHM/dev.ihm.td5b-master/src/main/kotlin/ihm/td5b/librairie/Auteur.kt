package ihm.td5b.librairie

/**
 * @author lanoix-a
 * @version 2019
 * réécrit par jacquin-c en Kotlin en 2022
 */

class Auteur(nom: String, prenom:String) {

    private var nom: String
    private var prenom: String

    /**
     * créer un nouvel auteur
     *
     *
     */
    init {
        this.nom = nom
        this.prenom = prenom
    }

    /**
     * @return l'auteur courant sous forme d'une chaine de caractères
     */
   override fun toString(): String {
        return "${this.prenom} ${this.nom}"
    }

    /**
     * @return valeur numérique unique correspondant à l'auteur courant
     */
    override fun hashCode():Int {
        var  result = nom.hashCode()
        result = result * prenom.hashCode()
        return result
    }

    /**
     * @param other un objet à comparer
     * @return vrai si l'objet est égal à l'auteur courant
     */

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Auteur || (this.nom != other.nom) || (this.prenom!=other.prenom)) return false
        return true
    }


}
