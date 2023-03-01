package ihm.td6.exo3.modele

import ihm.td6.exo3.librairie.Todo
import javafx.collections.FXCollections
import javafx.collections.ObservableList

class Todos {

    val personnes: ObservableList<Todo>
    var selectedIndex: Int
    var selectedItem: String

    init{

        this.personnes= FXCollections.observableArrayList(
            Todo("faire les courses"),
            Todo("regarder mon cours d'IHM"),
            Todo("réparer mon réveil"),
            Todo("acheter un stylo"),
            Todo("acheter un billet de train")
        )
        this.selectedIndex=0
        this.selectedItem=this.personnes[0].name
    }
}