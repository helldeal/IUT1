package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent


class ClicPanneauEcouteur(appli: Appli): EventHandler<MouseEvent> {
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override fun handle(event: MouseEvent) {
        var res=appli.labelNbClicPanneau.text.toInt()
        res+=1
        appli.labelNbClicPanneau.text=res.toString()
    }
}

