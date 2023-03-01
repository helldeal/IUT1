package ihm.td6.exo3.controleur

import ihm.td6.exo3.librairie.Todo
import ihm.td6.exo3.modele.Todos
import ihm.td6.exo3.vue.VueTodos
import javafx.event.EventHandler
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent

class ControleurTodoList(vue:VueTodos,modele:Todos):EventHandler<MouseEvent>{

    val vue:VueTodos
    val modele:Todos

    init {
        this.vue=vue
        this.modele=modele
    }

    override fun handle(p0: MouseEvent?) {
        var a = p0?.target.toString()
        var res = ""
        if ("\"" in a)res = a.substringAfter("\"").substringBeforeLast("\"")
        else res = a.substringAfter("'").substringBeforeLast("'")

        if (res!="null")vue.nameTextField.text=res

    }
}