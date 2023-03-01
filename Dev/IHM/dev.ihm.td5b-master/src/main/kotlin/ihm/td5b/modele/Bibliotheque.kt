package ihm.td5b

import ihm.td5b.librairie.Auteur
import ihm.td5b.librairie.Livre


/**
 * La bibliothèque est une classe qui combine un index de livres et un index
 * d'auteurs
 *
 * @author lanoix-a
 * @version 2019
 * réécrit par jacquin-c en kotlin en 2022
 */

class Bibliotheque {


    val  livres: MutableList<Livre>
    var courant: Int
    var dernier: Int
    private  var auteurs : MutableSet<Auteur>


    /* créer une bibliotheque de livres
    */
    init {
        livres = ArrayList<Livre>()
        courant = 0
        dernier = -1
        auteurs = HashSet<Auteur>()
    }

    /**
     * supprime le livre courant de la bibliothèques de livres ;
     * se repositionne sur le 1er livre de la bibliotèque
     */
    fun suppressionLivre() {

        livres.removeAt(courant)
        courant = 0
        dernier--

    }

    /**modifie le livre courant de la bibliothèques de livres ;
     *@param livre livre pour remplacer celui situé en courant
     */
    fun modifierLivre(livre: Livre) {
        livres[courant]=livre

    }


/*
Teste si la liste de livres est vide

 */

    fun estVide(): Boolean{
        if (this.courant<0){
            return true}
        else{
            return false
        }
    }


    /**
     * ajoute le livre à la bibliothèque de livres ; ajoute également l'auteur
     * du livres à l'index des auteurs
     *
     * @param livre livre à ajouter à la bibliothèque
     */
    fun ajoutLivre(livre: Livre) {
        if (dernier < livres.size) {
            this.livres.add(livre)
            dernier++
        }
        ajoutAuteur(livre.auteur)
    }

    /**
     * @param auteur auteur à ajouter à l'index des auteurs
     * @return vrai si l'ajout a bien eu lieu
     */
    fun ajoutAuteur(auteur: Auteur): Boolean {
        return this.auteurs.add(auteur)
    }

    /**
     * @return le livre actuellement consulté
     */
    fun donneLivre(): Livre {
        return livres[this.courant]
    }



    /**
     * @return vrai s'il y a encore un livre après le livre courant dans l'index
     * des livres
     */
    fun livreSuivantPossible(): Boolean {
        return (this.courant < this.dernier)
    }

    /**
     * change le livre courant par son sucesseur
     *
     * @throws Exception si le livre courant n'a pas de sucesseur
     */
    fun livreSuivant()  {
        if (livreSuivantPossible())
            this.courant++
        else
            throw Exception()
    }

    /**
     * @return vrai s'il y a un livre avant le livre courant dans l'index des
     * livres
     */
    fun livrePrecedentPossible(): Boolean {
        return this.courant > 0
    }

    /**
     * change le livre courant par son prédécésseur
     *
     * @throws Exception si le livre courant n'a pas de prédécesseur
     */
    @Throws(java.lang.Exception::class)
    fun passeAulivrePrecedent() {
        if (ilYaLivrePrecedent()) courant--
        else throw java.lang.Exception()
    }

    /**
     * @return vrai s'il y a un livre avant le livre courant dans l'index des
     * livres
     */
    fun ilYaLivrePrecedent(): Boolean {
        return courant > 0
    }

    /**
     * @return vrai s'il y a encore un livre après le livre courant dans l'index
     * des livres
     */
    fun ilYaLivreSuivant(): Boolean {
        return courant < livres.size - 1
    }

    /**
     * change le livre courant par son prédécésseur
     *
     * @throws Exception si le livre courant n'a pas de prédécesseur
     */
    fun livrePrecedent()  {
        if (livrePrecedentPossible())
            this.courant--
        else
            throw Exception()
    }

    /**
     * @return l'index des auteurs disponibles dans la bibliothèque
     */
    fun donneTousLesAuteurs(): ArrayList<Auteur> {
        return ArrayList<Auteur>(this.auteurs)
    }

    /**
     * donne l'auteur correspondant à la chaine de caractères
     *
     * @param str une chaine de caractère
     * @return l'auteur correspondant à la chaine de caractères
     * @throws Exception si la chaine de caractères ne correspond à aucun auteur dans
     *                   l'index des auteurs
     */
    fun donneAuteur(str: String): Auteur? {
        val i = auteurs.iterator()
        var trouve = false
        var auteurCherche: Auteur? = null
        while (i.hasNext() && !trouve) {
            auteurCherche = i.next()
            if (str.equals(auteurCherche.toString())) {
                trouve = true
            }
        }
        if (trouve) {
            return auteurCherche
        } else
            throw Exception()
    }

    /**
     * rempli la bibliothèque avec des données de tests
     */
    fun preremplir() {
        ajoutLivre(Livre("L'Appel de Cthulhu", Livre.HORROR, Auteur("Lovecraft", "Howard Phillips")))
        ajoutLivre(Livre("Les lames du Cardinal", Livre.FANTASY, Auteur("Pevel", "Pierre")))
        val pratchett = Auteur("Pratchett", "Terry")
        ajoutLivre(Livre("Mortimer", Livre.FANTASY, pratchett))
        ajoutLivre(Livre("Procrastination", Livre.FANTASY, pratchett))
        ajoutLivre(Livre("Les ch'tits hommes libres", Livre.FANTASY, pratchett))
        ajoutLivre(Livre("La longue terre", Livre.SF, pratchett))
        val simmons = Auteur("Simmons", "Dan")
        ajoutLivre(Livre("Hyperion", Livre.SF, simmons))
        ajoutLivre(Livre("L'echiquier du mal", Livre.HORROR, simmons))
        ajoutLivre(Livre("Gagner la guerre", Livre.FANTASY, Auteur("Jaworski", "Jean-Philippe")))
    }

}
