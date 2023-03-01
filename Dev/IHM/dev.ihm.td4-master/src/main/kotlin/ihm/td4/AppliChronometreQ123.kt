package ihm.td4

import ihm.td4.ecouteurs.EcouteurComboBoxCalendrier
import ihm.td4.ecouteurs.EcouteurToucheCalendrier
import ihm.td4.ecouteurs.EcouteurChronoQ123
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.util.*


class AppliChronometreQ123: Application() {

    val c = Calendar.getInstance()
    var root = BorderPane()
    var droite = VBox()
    var centre = TextArea()
    var haut = Label("Mon Chronomètre")
    var stop = Button("Stop")
    var start = Button("Start")
    var reset = Button("Reset")
    var timer = Timer(1.0,EcouteurChronoQ123(this))
    var a=System.currentTimeMillis()
    var pause:Boolean=false

    override fun start(primaryStage: Stage) {

        droite.children.addAll(stop,start,reset)
        haut.alignment=Pos.CENTER
        haut.textFill=Color.RED
        haut.padding=Insets(10.0)
        root.top=haut
        root.right=droite
        root.center=centre
        droite.alignment=Pos.CENTER
        droite.spacing=10.0
        droite.padding=Insets(10.0)
        root.padding=Insets(10.0)
        start.setOnAction {
            timer.start()
            if(!pause)a=System.currentTimeMillis()/1000
            if (pause){
                pause=false
                var p=System.currentTimeMillis()/1000-a
                a+=p
            }
            afficher(System.currentTimeMillis()/1000-a)
        }
        stop.setOnAction {
            pause=true
        }

        reset.setOnAction {
            timer.stop()
            a=System.currentTimeMillis()/1000
            afficher(System.currentTimeMillis()/1000-a)
        }


        val scene = Scene(root, 300.0, 300.0)
        primaryStage.title="TD4 Chrono"
        primaryStage.scene=scene
        primaryStage.show()
    }

    fun afficher(tempsSeconde: Long){
        val minutes = tempsSeconde / 60
        val seconde= tempsSeconde-minutes*60
        centre.text=String.format("%02d:%02d",minutes, seconde)

    }




}

fun main() {
    Application.launch(AppliChronometreQ123::class.java)
}







