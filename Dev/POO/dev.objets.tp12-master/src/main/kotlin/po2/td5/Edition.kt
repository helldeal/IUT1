package po2.td5
import java.lang.Double.parseDouble
/**
 * Classe Edition, pour mémoriser les différentes éditions d'un livre
 * @param isbn l'International Standard Book Number, identifiant l'édition d'un livre
 * @param editeur nom de l'éditeur
 * @param annee année de publication
 */

class Edition (isbn: String, editeur: String, annee: Int) {

    private var isbn: String = ""
    private var editeur: String = ""
    private var annee: Int = 0

    init {
        this.isbn = isbn
        if (isbn.length!=10 && isbn.length!=13)throw LivreException("ISBN non valide (longueur)")
1

        if (!numeric && isbn[isbn.length-1]!='X')throw LivreException("ISBN non valide (carac)")


        if (isbn.length==13){
            var cpt=1
            var res=0

            for (i in isbn){
                if (i=='X')res+=10*cpt
                else res+=i.digitToInt()*cpt
                if (cpt==1){
                    cpt=3
                } else {
                    cpt=1
                }
            }
            println(res)
            if (res%10!=0)throw LivreException("ISBN non valide (13 calc)")
        }

        if (isbn.length==10){
            var cpt=10
            var res=0
            for (i in isbn){
                if (i=='X')res+=10*cpt
                else res+=i.digitToInt()*cpt
                cpt--
            }
            println(res)
            if (res%11!=0)throw LivreException("ISBN non valide (10 calc)")
        }
        this.editeur = editeur
        this.annee = annee
    }

    fun donneAnnee():Int{
        return annee
    }

    fun donneEd():String{
        return editeur
    }

}
