package ihm.td6.exo1.controleur

import ihm.td6.exo1.vue.Vue
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.event.ActionEvent
import javafx.event.EventHandler


class Controleur(vue: Vue) {
    private val vue: Vue
    val premierNombre= SimpleStringProperty()
    val secondNombre= SimpleStringProperty()
    val somme=SimpleStringProperty()
     init {
         this.vue = vue
     }
    fun bindVue() {
        premierNombre.value=""
        secondNombre.value=""
        vue.b1.textProperty().bindBidirectional(premierNombre)
        vue.b2.textProperty().bindBidirectional(secondNombre)
        somme.bind(premierNombre.concat(secondNombre))
        vue.b3.textProperty().bind(somme)
    }




}