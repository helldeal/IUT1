package po2.td5

/**
 * classe Auteur
 */
/**
 * crée un nouvel auteur
 *
 * @param nom  nom de l'auteur
 * @param prenom prenom de l'auteur
 */

class Auteur(nom: String, prenom: String) {
    private val nom: String
    private val prenom: String

    init{
        this.nom = nom
        this.prenom = prenom
    }
}