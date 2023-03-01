package po2.td5
var numincr=0
class Livre(titre: String, auteur: Auteur) : Comparable<Livre> {

    private val numero : Int
    //  le numero du livre, pour chaque nouveau livre, doit être différent
    // pour cela, declarer une variable en dehors de la classe
    // et incrementer là, à chaque initialisation
    private val titre: String
    private val auteur: Auteur
    private val editions: MutableList<Edition>

    init {
        this.numero = numincr
        numincr++
        this.titre = titre
        this.auteur = auteur
        this.editions = mutableListOf()
    }

    /**
     * Ajoute une nouvelle édition au livre
     *
     * @param nouvelle l'édition à ajouter
     * @throws LivreException si cette édition est déjà présente
     * OU si l'année de l'édition ajouté est supérieure à celle courante
     */
    fun ajouteEdition(nouvelle: Edition) {
        if (nouvelle in editions)throw LivreException("Edition deja présente")
        editions.add(nouvelle)
    }

    /**
     * @return une liste de toutes les éditions, triée par année.
     */
    fun editionsTriParAn(): List<Edition> {
        var ed =editions
        ed.sortBy { it.donneAnnee() }
        return ed
    }

    /**
     * @return une chaîne de caractères représentant le livre
     */
    override fun toString(): String {
        return "$numero $titre $auteur $editions"
    }

    /**
     * L'ordre naturel est donné par le nombre d'édition
     * puis (en cas d'égalité) par l'ordre de création des livres.
     *
     * @param autre le second livre
     * @return  return un entier < 0, =0 ou > 0 si le livre courant est plus petite,
     * égal ou plus grand que l'autre livre
     */
    override fun compareTo(other: Livre): Int {
        if (this.editions.size>other.editions.size)return 1
        if (this.editions.size==other.editions.size && this.numero<other.numero)return 1
        if (this.editions.size==other.editions.size && this.numero==other.numero)return 0
        return -1
    }
    fun donneAuteur():Auteur{
        return auteur
    }

    fun donneTitre():String{
        return titre
    }
}