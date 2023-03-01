package ihm.td4.ecouteurs

import ihm.td4.AppliCalendrier
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import java.security.Key
import java.util.*


class EcouteurToucheCalendrier(appli: AppliCalendrier) : EventHandler<KeyEvent> {
    private val appli: AppliCalendrier

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: KeyEvent) {
        if (event.eventType== KeyEvent.KEY_PRESSED && event.code==KeyCode.RIGHT){
            appli.c.add(Calendar.DAY_OF_MONTH,1)
            println("+1")
            appli.update()
        }
        if (event.eventType== KeyEvent.KEY_PRESSED && event.code==KeyCode.LEFT){
            appli.c.add(Calendar.DAY_OF_MONTH,-1)
            println("-1")
            appli.update()

        }
    }

}