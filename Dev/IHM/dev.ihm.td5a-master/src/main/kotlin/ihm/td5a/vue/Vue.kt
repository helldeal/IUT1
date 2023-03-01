package ihm.td5a.vue

import ihm.td5a.controleur.ControleurTouche
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import javafx.scene.layout.FlowPane

class Vue: FlowPane() {

    private val comboBox: ComboBox<String>
    private val labelnumeroJour: Label
    private val labelJour: Label
    private val labelYear:Label

    init{
        this.comboBox= ComboBox<String>()
        this.labelnumeroJour= Label("")
        this.labelJour=Label("")
        this.labelYear=Label("")
        this.children.addAll(labelJour,labelnumeroJour, comboBox, labelYear)
        this.hgap=10.0
        this.padding= Insets(20.0)
    }

    // pour mettre à jour les composants graphiques de la vue quand une modification du calendrier a eu lieu
    fun update(year: Int, month: Int, dayNumber: Int, dayName:String ){
        this.comboBox.selectionModel.select(month)
        labelnumeroJour.text=dayNumber.toString()
        labelJour.text=dayName
        labelYear.text=year.toString()
    }
    
     /**
     * ajoute les éléments du tableau comme item de la ComboBox
     * @param tab le tableau de mois
     */
    fun populateMonth(tab: Array<String>){
        this.comboBox.items.addAll(tab)
    }

    /**
     * @return l'index de la valeur sélectionnée
     */
    fun getIndexSelected(): Int{
        return this.comboBox.selectionModel.selectedIndex
    }

    /**
     * associe un gestionnaire d'événement à la comboBox
     * @param eventHandler le gestionnaire d'événement associé
     */
    fun subscribeControleurComboBox(eventHandler: EventHandler<ActionEvent>){
        this.comboBox.onAction=eventHandler
    }




}



