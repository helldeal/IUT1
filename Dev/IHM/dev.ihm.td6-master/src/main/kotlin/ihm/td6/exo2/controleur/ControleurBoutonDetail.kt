package ihm.td6.exo2.controleur

import ihm.td6.exo2.modele.Cercle
import ihm.td6.exo2.vue.Vue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert

class ControleurBoutonDetail(vue: Vue,modele:Cercle):EventHandler<ActionEvent>{

    var vue:Vue
    var modele:Cercle
    init {
        this.modele=modele
        this.vue=vue
    }

    override fun handle(p0: ActionEvent?) {
        val dialog = Alert(Alert.AlertType.INFORMATION)
        dialog.title="Information sur le Cercle"
        dialog.headerText="Rayon:${vue.cercle.radius}\nCouleur:${vue.cercle.fill}\nPerimetre:${modele.périmètre(vue.cercle)}\nSurface:${modele.surface(vue.cercle)}"
        dialog.showAndWait()
    }
}