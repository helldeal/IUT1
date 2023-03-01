package ihm.td6.exo3.controleur

import ihm.td6.exo3.librairie.Todo
import ihm.td6.exo3.modele.Todos
import ihm.td6.exo3.vue.VueTodos
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


class ControleurAddButton(vue: VueTodos, modele: Todos):EventHandler<ActionEvent> {

    val vue: VueTodos
    val modele: Todos

    init {
        this.vue=vue
        this.modele=modele
    }

    override fun handle(p0: ActionEvent?) {
        if (!vue.nameTextField.text.isBlank()) vue.myListView.items.add(Todo(vue.nameTextField.text))
    }


}