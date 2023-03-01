package iut.but1.r203.td1

/**
 * @author mottu-jm (inspired from rpouiller's java code)
 */
class Operations {

    private val COURT = 0
    private val LONG = 1
    private val TRESLONG = 2

    /**
     * additionner une liste de int
     * @param nombres : int[] tableau d'entiers à additionner
     * @return somme : int
     */
    fun additionner(nombres: Array<Int>): Int {
        var retour = 0
        for (i in 0 until nombres.size) {
            retour += nombres[i]
        }
        this.afficherResultat(retour, "addition", COURT)
        return retour
    }

    /**
     * Soustraire successivement des int (requiert au moins 2 nombres)
     * @param nombres : int[] tableau d'entiers à soustraire
     * @return resultat des soustractions
     */
    fun soustraire(nombres: Array<Int>): Int {
        if (nombres.size<1) return 0
        var retour = nombres[0]
        for (i in 1 until nombres.size) {
            retour -= nombres[i]
        }
        this.afficherResultat(retour, "soustration", TRESLONG)
        return retour
    }

    /**
     * Multiplier une liste de int
     * @param nombres : int[] tableau d'entiers à multiplier
     * @return produit : int
     */
    fun multiplier(nombres: Array<Int>): Int {
        var retour = 1
        for (i in 0 until nombres.size) {
            retour *= nombres[i]
        }
        this.afficherResultat(retour, "multiplication", LONG)
        return retour
    }

    /**
     * Affiche le resultat de l'operation de differentes manieres (de COURT à TRESLONG pour le parametre de l'afficheur)
     * @param resultat : nombre à afficher
     * @param operation : opération effectuée
     * @param afficheur : constante déterminant la longueur de l'affichage
     */
    private fun afficherResultat(resultat: Int, operation: String, afficheur: Int) {
        if (afficheur == COURT) {
            println(resultat)
        } else if (afficheur == LONG) {
            println("Le résultat est $resultat")
        } else println("Le résultat de la $operation est $resultat")
    }
}