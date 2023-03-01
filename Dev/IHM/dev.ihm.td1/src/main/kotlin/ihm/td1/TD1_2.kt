package ihm.td1

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlin.math.cos
import kotlin.math.log

class TD1_2 : Application(){
    val canvas= Canvas(600.0, 400.0)

    override fun start(stage: Stage) {
        val g: GraphicsContext = canvas.getGraphicsContext2D()
        val tableau = Tableau()
        tableau.children.add(canvas)
        g.stroke=Color.ORANGERED
        g.strokeLine(0.0,canvas.height/2,canvas.width,canvas.height/2)
        g.strokeLine(canvas.width/2,0.0,canvas.width/2,canvas.height)
        g.stroke=Color.BLACK
        g.strokeText("-\u03c0",10.0,canvas.height/2+15)
        g.strokeText("\u03c0",canvas.width-20.0,canvas.height/2+15)
        g.strokeText("0.0",canvas.width/2+5,canvas.height/2+15.0)
        g.strokeText("1",canvas.width/2+10,20.0)
        g.strokeText("-1",canvas.width/2+10.0,canvas.height-10)
        var index=-Math.PI
        while (index<Math.PI) {
            var res= log(index,10.0)
            var res1= log(index-0.1,10.0)
            g.stroke=Color.BLUE
            g.strokeLine(xToPixel(index),yToPixel(res),xToPixel(index-0.1),yToPixel(res1))
            index+=0.1
        }

        val scene = Scene(tableau, canvas.width, canvas.height)
        stage.setTitle("TD1_2 en javaFX")
        stage.setScene(scene)
        stage.show()


        // affichage de la zone d'affichage de la courbe au centre d'un BorderPane

        // affichage du repère orange avec les valeurs xmin et xmax de
    // l'axe horizontal et ymin et ymax du repère de l'axe vertical
        // calcul pas à pas des points de la courbe (fonction cos()):
    // vous pourrez prendre un pas de 0.1
        // Les coordonnées x et y des points doivent ensuite être placées dans la
    // zone d'affichage (mise à l'échelle en utilisant les méthodes xtoPixel() et
    // yToPixel() que vous aurez développé)
        //la courbe va s'afficher en prenant x dans [-Math.PI, Math.PI]

        // pour afficher le caractère PI sur la courbe => "\u03c0"

    }

    /*
    transforme un double passé en paramètre en une coordonnée x sur l'écran en
     respectant l'échelle du repère
    @param x le double à transformer
    @return la coordonnée en x du pixel sur l'écran
    */
    private  fun xToPixel( x: Double ): Double {
        return (x+Math.PI)*canvas.width/(2*Math.PI)
    }

    /*
    transforme un double passé en paramètre en une coordonnée y sur l'écran en
     respectant l'échelle du repère
    @param y le double à transformer
    @return la coordonnée en y du pixel sur l'écran
    */

    private fun yToPixel(y: Double): Double {
        return -(y-1.0)*canvas.height/2
    }

}



fun main() {
    Application.launch(TD1_2::class.java)

}