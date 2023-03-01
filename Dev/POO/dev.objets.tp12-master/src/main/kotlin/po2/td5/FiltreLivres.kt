package po2.td5

/**
 * Interface proposant des méthodes pour filtrer les livres
 */
interface FiltreLivres {
    /**
     * Filtre l'ensemble des Livre et retourne
     * un sous-ensemble de Livre ayant un nom de candidat  correspondant à celui indiqué
     *
     * @param titre le titre du livre à rechercher
     * @return tous les livres ayant comme titre le titre passé en paramètre
     */
    fun livresParTitre(titre: String): Livres

    /**
     * Filtre l'ensemble des Livre et retourne
     * un sous-ensemble des Livre ayant comme auteur, l'auteur indiqué
     *
     * @param auteur l'auteur à rechercher
     * @return tous les livres ayant comme auteur, l'auteur indiqué
     */
    fun livresParAuteur(auteur: Auteur): Livres
}