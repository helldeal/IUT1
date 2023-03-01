package ihm.td5b.vue

import ihm.td5b.librairie.Auteur
import ihm.td5b.librairie.Livre
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.scene.control.TitledPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text


/**
 * classe développée par jacquin-c en 2022
 * permet d'afficher le panneau droit de l'interface
 * c'est une sous classe de TitledPane. Cette dernière classe peut permettre d'obtenir
 * une zone de titre avec dessous un Pane
 */
open class TitledPaneLivre(str: String): TitledPane() {
    
    var numero: Int

    // la grille pour positionner tous les éléments
    // c'est ce conteneur que nous associerons au TitledPane
    var grille: GridPane
    
    val textFieldTitre: TextField
    val comboBoxCategorie: ComboBox <String>
    val comboBoxAuteur: ComboBox <Auteur>
    val bouton1: Button
    val bouton2: Button


    init{
        this.grille= GridPane()
        // on renseigne le titre du TitlePane
        this.text=str
        // on associe une GridPane comme conteneur inclus dans le TitledPane
        this.content=grille
        // initialisation des autres attributs
        this.numero=0
        this.textFieldTitre= TextField()
        this.comboBoxCategorie= ComboBox <String>()
        this.comboBoxAuteur= ComboBox <Auteur>()
        this.bouton1 = Button()
        this.bouton2 = Button()
       }

    /**
     * permet de mettre à jour le conteneur avec numero qui sera le numero du livre et
     * livre qui sera le livre courant
     * @param numero numero du livre
     * @param livre le livre courant
     */
    open fun update(numero: Int, livre: Livre?) {

        // pour le rendu graphique du conteneur
        this.font= Font.font("sans_serif", FontWeight.BOLD, FontPosture.REGULAR,12.0)
        this.isCollapsible = false
        this.padding=Insets(10.0)
        this.alignment= Pos.CENTER
        
        // remplissage du GridPane inclus
        this.grille.children.clear()
        this.grille.padding = Insets(10.0)
        this.grille.hgap = 10.0
        this.grille.vgap = 10.0

        // remplissage des cellules de la première colonne du GridPane
        val titresColonne = arrayOf("Numéro: ", "Titre: ", "Catégorie: ", "Auteur: ")
        var i = -1
        for (detail in titresColonne) {
            i++
            val text = Text(detail)
            text.font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12.0)
            this.grille.add(text, 0, i)
        }

        // remplissage des cellules de la deuxième colonne du GridPane
        // la valeur du numero
        val num=Text((numero+1).toString())
        this.grille.add(num,1,0)
        //la valeur du TextField
        this.textFieldTitre.text=livre?.titre
        this.textFieldTitre.isEditable=false
        this.grille.add(textFieldTitre, 1, 1)
        
        // mise en place de la ComboBox pour les catégories
        val tabCategorie=arrayOf(Livre.SF, Livre.FANTASY, Livre.HORROR)
        this.comboBoxCategorie.items.clear()
        this.comboBoxCategorie.items.addAll(tabCategorie)
        this.comboBoxCategorie.selectionModel.select(livre?.categorie)
        this.grille.add(comboBoxCategorie, 1, 2)
        
        // mise en place de la ComboBox pour les auteurs
        this.comboBoxAuteur.items.clear()
        this.comboBoxAuteur.items.add(livre?.auteur)
        this.comboBoxAuteur.selectionModel.select(0)
        this.grille.add(comboBoxAuteur, 1, 3)
        
        // mise en place des 2 boutons qui seront placés dans la grille
        this.setBoutons()
    }

    /**
     * méthode qui permet de placer bouton1 et bouton2 dans le GridPane
     */
    open fun setBoutons(){
        this.bouton1.text="<"
        this.bouton2.text=">"
        val borderPaneBoutons= BorderPane()
        borderPaneBoutons.right=bouton2
        borderPaneBoutons.left=bouton1
        borderPaneBoutons.padding=Insets(20.0)
        this.grille.add(borderPaneBoutons,0,4,2,1)
    }


}


