package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import java.security.Key


class EcouteurToucheControl(appli: Appli) : EventHandler<KeyEvent> {
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: KeyEvent) {
        if (event.eventType== KeyEvent.KEY_PRESSED && event.code==KeyCode.CONTROL){
            appli.panneauBas.style="-fx-background-color: pink;"
        }
        if (event.eventType== KeyEvent.KEY_RELEASED && event.code==KeyCode.CONTROL){
            appli.panneauBas.style="-fx-background-color: white;"
        }
    }

}