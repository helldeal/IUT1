package ihm.td4.ecouteurs

import ihm.td4.AppliChronometreQ123
import javafx.event.ActionEvent
import javafx.event.EventHandler
import java.util.*


class EcouteurChronoQ123(appli: AppliChronometreQ123) : EventHandler<ActionEvent> {
    private val appli: AppliChronometreQ123

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: ActionEvent) {
        appli.afficher(System.currentTimeMillis()/1000-appli.a)
    }

}

