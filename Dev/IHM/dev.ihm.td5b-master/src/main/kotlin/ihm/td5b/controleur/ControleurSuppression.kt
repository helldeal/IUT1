package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType


class ControleurSuppression(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }
    override fun handle(event: ActionEvent) {
        val dialog = Alert(Alert.AlertType.CONFIRMATION)
        dialog.title="Delete File"
        dialog.headerText="Voulez vous vraiment supprimer le livre ?"
        dialog.contentText=modele.donneLivre().titre
        val result= dialog.showAndWait()
        if (result.get()== ButtonType.OK) {
            modele.livres.removeAt(modele.courant)
            vue.updatePanneauDroit(vue.panneauDroit)
            vue.updateLivres(modele.livres,ControleurDetailLivre(vue, modele),modele.courant)
        }
    }
}
