package po2.td5

/**
 * Classe permettant d'enregistrer des livres
 * @param listeDeLivres les livres à enregistrer
 */
class Livres(listeDeLivres: MutableList<Livre> = mutableListOf()):FiltreLivres,TriLivres {

    private val mesLivres: MutableList<Livre>

    /**
     * créé une nouvelle classe prête à enregistrer des livres.
     */
    init {
        mesLivres = listeDeLivres
    }

    /**
     * ajoute un nouveau livre
     *
     * @throws LivreException si le livre est déjà enregistré
     */
    fun ajoute(livre: Livre) {
        if (livre in mesLivres)throw LivreException("Livre deja présent")
        mesLivres.add(livre)
    }

    /**
     * @return le nombre de livres enregistrés
     */
    fun nbLivres(): Int {
        return mesLivres.size
    }

    /**
     * @return le nombre d'éditions enregistrées. Il peut y en avoir plusieurs pour un livre
     */
    fun nbEditions(): Int {
        var ed :MutableList<Edition> = mutableListOf()
        for (i in mesLivres){
            ed.addAll(i.editionsTriParAn())
        }
        return ed.size
    }

    /**
     * @return une liste de toutes les livres (on conserve l'ordre d'ajout)
     */
    fun livres(): List<Livre> {
        return mesLivres
    }

    /**
     * efface le livre des Livres enregistrées
     *
     * @param livre le livre à effacer
     * @throws LivreException si le livre à effacer n'est pas dans les livre enregistrées
     */
    fun efface(livre: Livre) {
        if (livre !in mesLivres)throw LivreException("CANT delete where not")
        mesLivres.remove(livre)
    }

    override fun toString(): String {
        return "$mesLivres"
    }

    override fun livresParAuteur(auteur: Auteur): Livres {
        var bibli =Livres()
        for (i in mesLivres){
            if(i.donneAuteur()==auteur){
                bibli.ajoute(i)
            }
        }
        return bibli
    }

    override fun livresParTitre(titre: String): Livres {
        var bibli =Livres()
        for (i in mesLivres){
            if(i.donneTitre()==titre){
                bibli.ajoute(i)
            }
        }
        return bibli
    }

    override fun livresParOrdreNaturel(): Livres {
        var bibli =Livres()
        for (i in mesLivres) {
            bibli.ajoute(i)
        }
        bibli.mesLivres.sort()
        return bibli
    }

    override fun livresParTitreAlpha(): Livres {
        var bibli =Livres()
        for (i in mesLivres) {
            bibli.ajoute(i)
        }
        bibli.mesLivres.sortBy() {it.donneTitre()}
        return bibli
    }

}