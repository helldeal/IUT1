abstract class FormeGeo(xx : Int, yy : Int,hauteur : Int, largeur : Int):ObjetPositionnable(xx,yy),Redimensionnable {
    protected var hauteur : Int
    protected var largeur : Int
    init {
        this.hauteur=hauteur
        this.largeur=largeur
    }

    override fun redimensionner(nouvelleHauteur: Int, nouvelleLargeur: Int) {
        hauteur=nouvelleHauteur
        largeur=nouvelleLargeur
    }

}