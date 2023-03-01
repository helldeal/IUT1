package ihm.td5a


import ihm.td5a.controleur.ControleurComboBox
import ihm.td5a.controleur.ControleurTouche
import ihm.td5a.modele.Calendrier
import ihm.td5a.vue.Vue
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage
import org.controlsfx.control.action.Action

class Main: Application() {

   override fun start(primaryStage: Stage) {

       val vue=Vue()
       val modele = Calendrier()

       vue.populateMonth(modele.giveAllMonths())
       vue.update(modele.getYear(),modele.getMonth(),modele.getDayNumber(),modele.getDay())

       vue.subscribeControleurComboBox(ControleurComboBox(vue, modele))
       vue.onKeyPressed=ControleurTouche(vue, modele)

       primaryStage.title="Calendrier MVC en javaFX"
       val scene=Scene(vue,400.0,270.0)
       primaryStage.scene=scene
       primaryStage.show()

      
   }

}

fun main(){
    Application.launch(Main::class.java)
}
