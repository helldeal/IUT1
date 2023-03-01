package ihm.td1.figures

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color


class Cercle(centre: Point, rayon: Double, couleur: Color=Color.RED): Figure(couleur, centre) {

    private var  rayon: Double

    init{
        this.rayon = rayon
    }

    override fun périmètre(): Double {
        return 2 * this.rayon * Math.PI
    }

   override fun etiquette(): String {
        return "Cercle"
    }

    override fun dessiner(g: GraphicsContext) {
        g.stroke=couleur
        g.strokeOval(centre.x-rayon,centre.y-rayon,rayon*2,rayon*2)
        g.strokeText(toString(),centre.x+rayon,centre.y+rayon)
        centre.dessiner(g)
    }
}

