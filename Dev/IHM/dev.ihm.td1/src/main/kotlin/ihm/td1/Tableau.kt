package ihm.td1

import ihm.td1.figures.Cercle
import ihm.td1.figures.Groupe
import ihm.td1.figures.Point
import ihm.td1.figures.Rectangle
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.Pane
import javafx.scene.paint.Color


class Tableau : Pane() {

    init {
        this.style="-fx-background-color: lightgray"
    }
/*
permet de réaliser l'affichage de formes

 */
    fun peindre(g: GraphicsContext) {
        tracerQuadrillage(g)
        val rectangle = Rectangle(50.0, 200.0, Point(150.0, 150.0), Color.ORANGE)
        rectangle.dessiner(g)
        val point = Point(200.0, 200.0)
        point.dessiner(g)
        val cercle = Cercle(Point(300.0, 300.0), 30.0)
        cercle.dessiner(g)

        val groupe = Groupe(Color.BLUE)
        groupe.ajouter(Point(20.0, 30.0))
        groupe.ajouter(Rectangle (200.0, 80.0,Point(100.0, 200.0) ))
        groupe.ajouter(Cercle(Point(250.0, 80.0), 50.0, Color.BLACK))
        groupe.dessiner(g)
        
    }

    private fun tracerQuadrillage(g: GraphicsContext) {

        g.stroke=Color.LIGHTGRAY

        for( x in 1..1000 step 10) {
            g.strokeLine(x.toDouble(), 0.0, x.toDouble(), 1000.0)
        }

        for (x in 0..1000 step 10){
            g.strokeLine(0.0, x.toDouble(), 1000.0, x.toDouble())
        }



    }

}
