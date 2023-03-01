package ihm.td5b.vue

import ihm.td5b.librairie.Livre
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text


class TitledPaneLivreAjout(titre: String):TitledPaneLivre(titre)  {

    override fun update(numero: Int, livre: Livre?) {
        this.textFill= Color.ORANGE
        // pour le rendu graphique du conteneur
        this.font= Font.font("sans_serif", FontWeight.BOLD, FontPosture.REGULAR,12.0)
        this.isCollapsible = false
        this.padding= Insets(10.0)
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
        val num= Text((numero+1).toString())
        this.grille.add(num,1,0)
        //la valeur du TextField
        this.textFieldTitre.isEditable=true
        this.grille.add(textFieldTitre, 1, 1)

        // mise en place de la ComboBox pour les catégories
        val tabCategorie=arrayOf(Livre.SF, Livre.FANTASY, Livre.HORROR)
        this.comboBoxCategorie.items.clear()
        this.comboBoxCategorie.items.addAll(tabCategorie)
        this.comboBoxCategorie.selectionModel.select(livre?.categorie)
        this.grille.add(comboBoxCategorie, 1, 2)

        // mise en place de la ComboBox pour les auteurs
        this.comboBoxAuteur.selectionModel.select(0)
        this.grille.add(comboBoxAuteur, 1, 3)

        // mise en place des 2 boutons qui seront placés dans la grille
        this.setBoutons()
    }

    override fun setBoutons() {
        this.bouton1.text="ajouter"
        this.bouton2.text="annuler"
        val borderPaneBoutons= BorderPane()
        borderPaneBoutons.center=bouton2
        borderPaneBoutons.left=bouton1
        borderPaneBoutons.padding= Insets(20.0)
        this.grille.add(borderPaneBoutons,0,4,2,1)
    }

}