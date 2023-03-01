package ihm.td5a.controleur

import javafx.event.ActionEvent
import javafx.event.EventHandler
import ihm.td5a.modele.CalendarInterface
import ihm.td5a.vue.Vue

class ControleurComboBox(vue: Vue, modele: CalendarInterface): EventHandler<ActionEvent> {

    private val vue: Vue
    private val modele : CalendarInterface

    //--- Constructeur ---------------------------------
    init {
        this.vue=vue
        this.modele=modele
    }

    override fun handle(Event: ActionEvent) {
        modele.moveMonth(vue.getIndexSelected())
        vue.update(modele.getYear(),modele.getMonth(),modele.getDayNumber(),modele.getDay())
    }


}
