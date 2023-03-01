package ihm.td6.exo3.vue

import ihm.td6.exo3.librairie.Todo
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font


class VueTodos: VBox() {

    val myListView: ListView<Todo>
    val addButton : Button
    val updateButton : Button
    val deleteButton : Button
    val clearButton : Button
    val moveUpButton: Button
    val moveDownButton: Button
    val nameTextField : TextField

    init{
        val nameLabel = Label("Ma TODO Liste")
        nameLabel.setFont(Font("Arial", 20.0))

        this.nameTextField = TextField()
        this.nameTextField.setPromptText("Todo")

        this.myListView = ListView<Todo>()
        this.addButton = Button("Add")
        this.updateButton = Button("Update")
        this.deleteButton = Button("Delete")
        this.clearButton = Button("Clear")
        this.moveDownButton=Button("Down")
        this.moveUpButton=Button("Up")

        val myHBox = HBox()
        myHBox.children.addAll(nameTextField, addButton, updateButton, deleteButton, clearButton, moveDownButton, moveUpButton)
        myHBox.spacing = 3.0
        myHBox.padding=Insets(10.0)

        val myVBox = VBox()
        myVBox.spacing = 5.0
        myVBox.padding = Insets(10.0, 0.0, 0.0, 10.0)
        myVBox.children.addAll(nameLabel, myListView, myHBox)
        this.children.add(myVBox)
    }

    fun fixeListenerButton(button: Button, eventHandler: EventHandler<ActionEvent>){
        button.onAction=eventHandler
    }

    fun fixeListenerListView(eventHandler: EventHandler<MouseEvent>){
        this.myListView.onMouseClicked=eventHandler
    }
}