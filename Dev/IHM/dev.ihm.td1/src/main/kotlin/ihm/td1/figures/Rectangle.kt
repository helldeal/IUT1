package ihm.td1.figures

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.pow
import kotlin.math.sqrt


open class Rectangle(largeur:Double, longueur:Double, centre: Point, couleur: Color=Color.BLUE):  Figure(couleur,centre) {

  private  var largeur:Double
  private  var longueur:Double

    init{
        this.largeur = largeur
        this.longueur = longueur
    }

    override fun périmètre(): Double {
        return (this.longueur + this.largeur) * 2
    }

    override fun etiquette():String {
        return "Rectangle"
    }

    override fun dessiner(g: GraphicsContext) {
        g.setStroke(couleur)
        centre.dessiner(g)
        g.strokeText(toString(),centre.x+longueur/2+10,centre.y+largeur/2+10)
        g.strokeRect(centre.x-longueur/2,centre.y-largeur/2,longueur,largeur)
    }
}
