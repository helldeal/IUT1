package ihm.td5b.librairie


/**
 * @author lanoix-a
 * @version 2019
 * réécrit par jacquin-c en Kotlin en 2022
 */

class Livre(titre:String, categorie: String, auteur: Auteur) {
    val numero: Int
    val titre: String
    val categorie: String
    val auteur: Auteur

    // le static en kotlin
    companion object {
        val SF = "SF"
        val FANTASY = "Fantasy"
        val HORROR = "Horror"
        var compteur = 0
    }

    // le constructeur
    init {
        this.titre = titre
        this.categorie = categorie
        this.auteur = auteur
        compteur++
        this.numero = compteur
    }
    /**
     * @return une collection de toutes les catégories de livres
     */
    fun donneToutesLesCategories(): ArrayList<String> {
        val vec =   ArrayList<String>()
        vec.add(SF)
        vec.add(FANTASY)
        vec.add(HORROR)
        return vec
    }

    /**
     * @return le livre courant sous forme d'une chaine de caractères
     */
    override fun toString():String {
        return " ${this.numero} / ${titre} ( ${categorie} ) - ${auteur.toString()}"
    }

}
