package po2.td5

interface TriLivres {

    /**
     * Trie l'ensemble des livres et retourne une nouvelle liste
     *
     * @return un nouvel ensemble de livre trié alphabétiquement selon les titres
     */
    fun livresParTitreAlpha(): Livres

    /**
     * Trie l'ensemble des livres et retourne une nouvelle liste
     *
     * @return un nouvel ensemble de livres triés par l'ordre naturel
     */
    fun livresParOrdreNaturel(): Livres
}