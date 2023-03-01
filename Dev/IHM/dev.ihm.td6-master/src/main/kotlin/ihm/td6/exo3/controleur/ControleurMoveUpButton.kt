package ihm.td6.exo3.controleur

import ihm.td6.exo3.modele.Todos
import ihm.td6.exo3.vue.VueTodos
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurMoveUpButton(vue: VueTodos, modele: Todos): EventHandler<ActionEvent> {

    val vue: VueTodos
    val modele: Todos

    init {
        this.vue=vue
        this.modele=modele
    }

    override fun handle(p0: ActionEvent?) {
        if (vue.myListView.selectionModel.selectedIndex>0){
            var a=vue.myListView.items.get(vue.myListView.selectionModel.selectedIndex)
            var b=vue.myListView.items.get(vue.myListView.selectionModel.selectedIndex-1)
            vue.myListView.items.set(vue.myListView.selectionModel.selectedIndex,b)
            vue.myListView.items.set(vue.myListView.selectionModel.selectedIndex-1,a)
            vue.myListView.selectionModel.select(vue.myListView.selectionModel.selectedIndex-1)
            vue.nameTextField.text= vue.myListView.items.get(vue.myListView.selectionModel.selectedIndex).toString()
        }
    }
}