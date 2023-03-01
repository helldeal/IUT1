package ihm.td4.ecouteurs

import ihm.td4.AppliCalendrier
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import java.util.*

class EcouteurComboBoxCalendrier(appli: AppliCalendrier) : EventHandler<ActionEvent> {
    private val appli: AppliCalendrier

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: ActionEvent) {
        appli.c.set(Calendar.MONTH,appli.comb.selectionModel.selectedIndex)
        appli.update()
    }

}
