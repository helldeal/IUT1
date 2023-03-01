package ihm.td1.figures


import javafx.scene.paint.Color


abstract class FormeGeo(couleur: Color) : Dessinable {
    protected var couleur:Color

    init {
        this.couleur = couleur
    }

    fun colorer(couleur: Color) {
        this.couleur = couleur
    }


}
