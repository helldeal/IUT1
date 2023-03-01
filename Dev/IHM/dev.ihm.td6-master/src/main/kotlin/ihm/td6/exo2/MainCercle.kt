package ihm.td6.exo2


import ihm.td6.exo2.controleur.ControleurBinding
import ihm.td6.exo2.controleur.ControleurBoutonDetail
import ihm.td6.exo2.modele.Cercle
import ihm.td6.exo2.vue.Vue
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class MainCercle: Application() {
    override fun start(primaryStage: Stage) {
       val vue=Vue()
        val modele=Cercle()
        val cb = ControleurBinding(vue)
       val scene = Scene(vue, 500.0, 550.0)
        cb.bindModeleVue(scene)
        vue.fixeListenerBoutonDetail(ControleurBoutonDetail(vue, modele))
        primaryStage.title="Binding Cercle en javaFX"
        primaryStage.scene=scene
        primaryStage.show()


    }

}

fun main(){
    Application.launch(MainCercle::class.java)
}

