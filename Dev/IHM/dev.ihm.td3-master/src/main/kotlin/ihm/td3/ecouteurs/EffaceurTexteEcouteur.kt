package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


class EffaceurTexteEcouteur(appli: Appli) : EventHandler<MouseEvent> {
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: MouseEvent) {
        if (event.clickCount==2){
        appli.textArea.text=""
        appli.zoneTexte.text=""
        }
    }

}
