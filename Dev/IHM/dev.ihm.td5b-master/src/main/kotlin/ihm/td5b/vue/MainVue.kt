package ihm.td5b

import ihm.td5b.librairie.Livre
import ihm.td5b.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.input.MouseEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/**
 * classe développée par jacquin-c en 2022
 */

class MainVue: BorderPane() {

    var grilleLivres: GridPane
    var panneauDroit :TitledPaneLivre
    val boutonModification: Button
    val boutonAjout: Button
    val boutonSuppression: Button


    init {
        this.grilleLivres = GridPane()
        this.panneauDroit = TitledPaneLivre("information livre")
        this.boutonModification = Button("Modification livre")
        this.boutonAjout = Button("Ajout livre")
        this.boutonSuppression = Button("Suppression livre")

        // le titre en haut
        val flowPaneTop = FlowPane()
        val labelTop = Label("Ma super Bibliothèque")
        labelTop.font = Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20.0)
        labelTop.textFill = Color.BLACK
        flowPaneTop.alignment = Pos.CENTER
        labelTop.padding = Insets(10.0)
        flowPaneTop.children.add(labelTop)
        this.top = flowPaneTop

        // la grille qui contient la liste des livres qui est dans un TitledPane
        val scrollPane = ScrollPane(this.grilleLivres)
        val titledPaneLivres = TitledPane(" liste des livres", scrollPane)
        titledPaneLivres.alignment = Pos.CENTER
        titledPaneLivres.font = Font.font("sans_serif", FontWeight.BOLD, FontPosture.REGULAR, 12.0)
        titledPaneLivres.isCollapsible = false
        titledPaneLivres.padding = Insets(10.0)
        this.left = titledPaneLivres

       // le panneau droit qui contiendra un TitledPane dont le contenu se modifiera en fonction
        // des actions de l'utilisateur: visualiser un livre, le modifier, ajouter un livre
        setAlignment(panneauDroit, Pos.TOP_CENTER)
        this.center = panneauDroit
         // les trois boutons en bas pour lancer des actions de modification, ajout ou suppression d'un livre
        val flowPaneBoutons=FlowPane()
        flowPaneBoutons.hgap=10.0
        flowPaneBoutons.padding=Insets(10.0)
        flowPaneBoutons.children.addAll(boutonModification,boutonAjout,boutonSuppression)
        this.bottom=flowPaneBoutons

    }


    /**
     * permet de mettre à jour le panneau droit qui se trouve au centre de la vue
     * @param titledPaneLivre le panneau qui servira à la mise à jour
     */
    fun updatePanneauDroit(titledPaneLivre: TitledPaneLivre){
        this.panneauDroit=titledPaneLivre
        this.center=titledPaneLivre
        setAlignment(titledPaneLivre, Pos.TOP_CENTER)
    }

    /**
     * permet de mettre à jour la liste des livres dans le panneau gauche
     * @param livres la liste des livres
     * @param index l'indice de l'élément dans la liste qui sera colorié en lightblue (commence à 0)
     */
    fun updateLivres(livres: MutableList<Livre>, index: Int){
        this.grilleLivres.children.clear()

        var i = -1
        for (livre in livres) {
            i++
            val labelLivre = Label(livre.titre)
            this.grilleLivres.add(labelLivre, 0, i)
        }
        this.grilleLivres.children[index].style = "-fx-background-color:lightblue"

    }

    /**
     * permet de mettre à jour la liste de livre dans le panneau de gauche et associe
     * à chaque cellule de la grille un gestionnaire d'événement
     * @param livres la liste des livres
     * @param eventHandler le gestionnaire d'évènement
     *
     */
    fun updateLivres(livres: MutableList<Livre>, eventHandler: EventHandler<MouseEvent>, index: Int) {
        this.updateLivres(livres,index)
        for (livre in livres) {
            this.grilleLivres.children.forEach { it.onMouseClicked = eventHandler }
        }
    }


    /**
         * active / désactive le Bouton
         *
         * @param etat vrai si le bouton doit être activé
         */
        fun activerBouton2(etat: Boolean) {
            this.panneauDroit.bouton2.isDisable = !etat
        }

        /**
         * active / désactive le Bouton permettant de passer au livre précédent
         *
         * @param etat vrai si le bouton doit être activé
         */
        fun activerBouton1(etat: Boolean) {
            this.panneauDroit.bouton1.isDisable = !etat
        }


        /**
         * ajoute un action listener au bouton bouton
         * @param bouton le bouton cible
         * @param action le listener à ajouter
         */
        fun fixeListenerBouton(bouton: Button, action: EventHandler<ActionEvent>) {
            bouton.onAction = action
        }


        /**
         * pour effacer le sélection d'un livre dans la grille de livre
         */
        fun effacerSelectionPanneauGauche() {
            this.grilleLivres.children.forEach {
                it.style = "-fx-background-color:white"
            }
        }

    /**
     * permet de colorier une ligne du GridPane en lightblue
     * @param numeroLigne le numéro de ligne à colorier
     */
    fun selectionnerLignePanneauGauche(numeroLigne:Int){
        val cellule=this.grilleLivres.children
        cellule[numeroLigne].style="-fx-background-color:lightblue"
    }

    }


