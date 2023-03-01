package ihm.td1.figures

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Point(x:Double, y:Double, couleur:Color=Color.BLACK):FormeGeo(couleur) {
   var x:Double
   private set
   var y: Double
   private set

    init{
        this.x = x
        this.y = y
    }


    override fun toString():String {
        return "[" + this.x + "," + this.y + "]"
    }

    override fun dessiner(g: GraphicsContext) {
        g.setStroke(couleur)
        g.strokeText("$this",x+10.0,y+10.0)
        g.strokeLine(x,y-5.0,x,y+5.0)
        g.strokeLine(x-5.0,y,x+5.0,y)
    }
}
