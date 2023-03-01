package ihm.td5a.controleur

import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import ihm.td5a.modele.CalendarInterface
import ihm.td5a.vue.Vue
import javafx.scene.input.KeyCode

class ControleurTouche(vue: Vue, modele: CalendarInterface): EventHandler<KeyEvent> {

    private val vue: Vue
    private val modele : CalendarInterface

    //--- Constructeur ---------------------------------
    init {
        this.vue=vue
        this.modele=modele
    }

    override fun handle(event: KeyEvent) {
        if (event.eventType== KeyEvent.KEY_PRESSED && event.code==KeyCode.RIGHT){
            modele.moveDayOfMonth(modele.getDayNumber()+1)
            println("+1")
            vue.update(modele.getYear(),modele.getMonth(),modele.getDayNumber(),modele.getDay())

        }
        if (event.eventType== KeyEvent.KEY_PRESSED && event.code==KeyCode.LEFT){
            modele.moveDayOfMonth(modele.getDayNumber()-1)
            println("-1")
            vue.update(modele.getYear(),modele.getMonth(),modele.getDayNumber(),modele.getDay())


        }
    }
}
