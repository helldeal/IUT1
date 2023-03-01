package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


class PanneauHautEcouteur(appli: Appli) : EventHandler<MouseEvent> {
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: MouseEvent) {
        if (event.eventType==MouseEvent.MOUSE_ENTERED)appli.panneauHaut.style="-fx-background-color: pink;"
        if (event.eventType==MouseEvent.MOUSE_EXITED)appli.panneauHaut.style="-fx-background-color: white;"
    }

}