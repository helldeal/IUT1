package ihm.td6.exo2.modele

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import kotlin.math.pow

class Cercle {
    fun périmètre(cercle: Circle): Double {
        return 2 * cercle.radius * Math.PI
    }
    fun surface(cercle: Circle): Double {
        return cercle.radius.pow(2.0) * Math.PI
    }

}