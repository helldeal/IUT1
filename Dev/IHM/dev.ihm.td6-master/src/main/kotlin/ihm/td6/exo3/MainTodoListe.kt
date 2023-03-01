package ihm.td6.exo3

import ihm.td6.exo3.controleur.*
import ihm.td6.exo3.modele.Todos
import ihm.td6.exo3.vue.VueTodos
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage


class MainTodoListe: Application() {
    override fun start(stage: Stage) {

        val modele=Todos()
        val vue=VueTodos()
        vue.myListView.items=modele.personnes
        vue.fixeListenerListView(ControleurTodoList(vue,modele))
        vue.fixeListenerButton(vue.addButton,ControleurAddButton(vue, modele))
        vue.fixeListenerButton(vue.updateButton,ControleurUpdateButton(vue, modele))
        vue.fixeListenerButton(vue.deleteButton,ControleurDeleteButton(vue, modele))
        vue.fixeListenerButton(vue.clearButton,ControleurClearButton(vue, modele))
        vue.fixeListenerButton(vue.moveUpButton,ControleurMoveUpButton(vue, modele))
        vue.fixeListenerButton(vue.moveDownButton,ControleurMoveDownButton(vue, modele))

        val scene = Scene(vue,550.0,300.0)
        stage.title = "JavaFX TODO liste"
        stage.scene=scene
        stage.show()


    }
}

fun main(){
    Application.launch(MainTodoListe::class.java)
}