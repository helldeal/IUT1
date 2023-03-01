package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ChoixCouleurEcouteur(appli: Appli): EventHandler<ActionEvent>{
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override fun handle(event: ActionEvent) {
        if (appli.choixCouleurs.selectionModel.selectedItem=="Vert"){
            this.appli.panneauCouleurs.style= "-fx-background-color: green"
        }
        if (appli.choixCouleurs.selectionModel.selectedItem=="Rouge"){
            this.appli.panneauCouleurs.style= "-fx-background-color: red"
        }
        if (appli.choixCouleurs.selectionModel.selectedItem=="Bleu"){
            this.appli.panneauCouleurs.style= "-fx-background-color: blue"
        }
    }
}




