package but1.iut.r203

/**
 * Cette classe stocke des notes et calcule des statistiques
 * @param listesDesNotes : les notes entrées en paramètre du constructeur
 * @property listesDesNotes : attributs de classe stockant les notes de l'instance de classe
 * @author mottu-jm
 */
class ListeNotes(var listeDesNotes: IntArray) {

    /**
     * Calcule la moyenne des notes
     * @return renvoie la moyenne des notes
     */
    fun moyenne(): Float {
        var somme = 0
        var index = 0
        while (index < listeDesNotes.size) {
            var somme = somme + listeDesNotes[index]
            index++
        }
        return if(listeDesNotes.size != 0)
            somme.toFloat()/listeDesNotes.size
        else
            0.0F
    }

    /**
     * Compte les occurences d'une note dans la liste des notes
     * @param elem
     * @return renvoie le nombre de notes trouvées
     * @throws IllegalArgumentException
     */
    fun nombreOccurence(elem: Int): Int {
        var compteurOccurence = 0
        if (elem > 20 || elem < 0) throw IllegalArgumentException()
        var i = 1
        while (i < listeDesNotes.size) {
            if (elem == listeDesNotes[i-1]) {
                compteurOccurence++
            }
            i++
        }
        return compteurOccurence
    }

    fun afficherListe() {
        for (i in listeDesNotes.indices) {
            print(listeDesNotes[i])
            print(" ; ")
        }
        println("Il y a " + listeDesNotes.size + " elements dans la liste.")
    }
}