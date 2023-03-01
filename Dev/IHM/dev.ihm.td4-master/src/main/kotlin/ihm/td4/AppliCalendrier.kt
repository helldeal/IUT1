package ihm.td4

import ihm.td4.ecouteurs.EcouteurComboBoxCalendrier
import ihm.td4.ecouteurs.EcouteurToucheCalendrier
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import javafx.scene.layout.HBox
import javafx.stage.Stage
import java.util.*

class AppliCalendrier : Application() {
    
    val c = Calendar.getInstance()
    var root = HBox()
    val tabDay= arrayOf("dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi")
    var lab1 = Label()
    var lab2 = Label("${c.get(Calendar.DAY_OF_MONTH)}")
    var lab3 = Label("${c.get(Calendar.YEAR)}")
    val comb = ComboBox<String>()



    override fun start(primaryStage: Stage) {
       
        val tabMonth= arrayOf(
            "janvier",
            "février",
            "mars",
            "avril",
            "mai",
            "juin",
            "juillet",
            "août",
            "septembre",
            "octobre",
            "novembre",
            "décembre"
        )
        update()

        root.padding= Insets(20.0,20.0,20.0,20.0)
        root.spacing = 10.0
        root.alignment=Pos.CENTER
        comb.items.addAll(tabMonth)
        comb.selectionModel.select(c.get(Calendar.MONTH))
        root.children.addAll(lab1,lab2,comb,lab3)


        root.addEventHandler(KeyEvent.KEY_PRESSED,EcouteurToucheCalendrier(this))
        comb.addEventHandler(ActionEvent.ACTION,EcouteurComboBoxCalendrier(this))

        val scene = Scene(root, 300.0, 100.0)
        primaryStage.title="TD4 Calendrier"
        primaryStage.scene=scene
        primaryStage.show()
    }


    
// pour mettre à jour les composants graphiques de la vue quand une modification du calendrier a eu lieu
    fun update(){
        lab1.text=tabDay[c.get(Calendar.DAY_OF_WEEK)-1]
        lab2.text = "${c.get(Calendar.DAY_OF_MONTH)}"
        lab3.text = "${c.get(Calendar.YEAR)}"
        comb.selectionModel.select(c.get(Calendar.MONTH))
    }
}

fun main() {
    Application.launch(AppliCalendrier::class.java)
}
