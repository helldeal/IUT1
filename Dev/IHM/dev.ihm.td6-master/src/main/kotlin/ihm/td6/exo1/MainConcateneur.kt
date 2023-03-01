package ihm.td6.exo1

import ihm.td6.exo1.controleur.Controleur
import ihm.td6.exo1.vue.Vue
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class MainConcateneur: Application() {
    override fun start(primaryStage: Stage) {

        val vue=Vue()
        val controleur = Controleur(vue)
        controleur.bindVue()
        val scene = Scene(vue, 600.0, 200.0)
        primaryStage.title="Concateneur de chaines en javaFX"
        primaryStage.scene=scene
        primaryStage.show()


    }

}

fun main(){
    Application.launch(MainConcateneur::class.java)
}

