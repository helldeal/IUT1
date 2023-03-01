package ihm.td1.figures

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color


abstract class Figure(couleur: Color, centre: Point): FormeGeo(couleur){
    protected var centre: Point

    init{
        this.centre = centre
        this.centre.colorer(couleur)
    }

    override fun dessiner(g: GraphicsContext) {
        // TODO
    }

    abstract fun périmètre():Double

    abstract fun etiquette():String

    override fun toString(): String {
        return etiquette() + " (" + périmètre() + ")"
    }
}
