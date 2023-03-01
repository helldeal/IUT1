open class Rectangle(xx : Int, yy : Int,hauteur : Int, largeur : Int): FormeGeo(xx,yy,hauteur, largeur){
    override fun dessiner(): String {
        return "[X=$xx,Y=$yy,H=$hauteur,L=$largeur]"
    }
}