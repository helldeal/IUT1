package exo2

import java.io.File
import java.util.*

class Monde {

    private val monde = mutableListOf<Pays>()

    /**
     * Retourne le nombre de pays dans le monde
     */
    fun taille(): Int {
        return monde.size
    }

    /**
     * Ajoute le pays passé en paramètre s'il n'est pas déjà présent
     * @param  p le pays à ajouter
     * @return true si le pays a bien été ajouté
     */
    fun ajouter(p: Pays): Boolean {
        if (p in monde) return false
        monde.add(p)
        return true
    }

    override fun toString(): String {
        TODO()
    }

    fun remplir(nomFichier : String) {
        val file = File(nomFichier)
        val bufferedReader = file.bufferedReader()
        val text:List<String> = bufferedReader.readLines()
        for(line in text){
            val list = line.split(";")
            val pays = Pays(list[0],list[1],list[2],list[3].toInt(),list[4].toDouble())
            ajouter(pays)
        }
    }

    /**
     * Retourne le Pays de nom passé en paramètre.
     * Méthode utilisant une boucle pour effectuer une recherche séquentielle.
     * @param  nom du pays à obtenir
     * @result le pays trouvé ou null si le pays indiqué n'est pas présent.
     */
    fun getPays(nom: String): Pays? {
        for (p in monde){
            if (p.getNom()==nom) return p
        }
        return null
    }

    /**
     * Retourne le Pays de nom passé en paramètre.
     * Méthode utilisant indexOf() et get() de List.
     * indexOf() utilise equals... qui a été redéfinie
     * Pensez à créer un faux pays, à partir du nom recherché
     * @param  nom du pays à obtenir
     * @result le pays trouvé ou null si le pays indiqué n'est pas présent.
     */
    fun getPays2(nom: String): Pays? {
        //monde.indexOf()
        return monde.get(monde.indexOf(getPays(nom)))
    }
    /**
     * Retourne une List des Pays plus peuplés que le pays passé en paramètre.
     * @param  ref le pays reference
     */
    fun plusPeuple(ref: Pays): MutableList<Pays> {
        var list = mutableListOf<Pays>()
        for (p in monde)
            if (ref<=p){
                list.add(p)
            }

        return list
    }

    /**
     * Retourne une List des Pays dont la population
     * est strictement supérieure à la limite
     */
    fun populationSuperieureA(limite : Int) : MutableList<Pays> {
        TODO()
    }

    /**
     * Retourne (une copie de) la liste des Pays du monde
     */
    fun monde(): MutableList<Pays> {
        var list = mutableListOf<Pays>()
        list.addAll(monde)
        return list
    }

    /**
     * Retourne (une copie de) la liste des Pays
     * du monde trié de manière croissante
     * selon l'ordre naturel.
     */
    fun mondeTrie(): MutableList<Pays> {
        var list = mutableListOf<Pays>()
        list.addAll(monde)
        list.sort()
        return list
    }

    /**
     * Retourne un tableau trié de manière croissante
     * des Pays du monde
     * selon l'ordre naturel.
     */
    fun mondeTrieTab(): Array<Pays> {
        var list = arrayOf<Pays>()
        for (p in monde){
            list+=p
        }
        list.sort()
        return list
    }

    /**
     * Retourne (une copie de) la liste des Pays
     * du monde trié selon la superficie des pays
     */
    fun mondeTrieSelonSuperficie(): MutableList<Pays> {
        TODO("voir explications dans README.md")
    }

}

