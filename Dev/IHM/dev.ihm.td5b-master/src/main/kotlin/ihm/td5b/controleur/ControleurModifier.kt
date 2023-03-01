package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.ControleurLivrePrecedent
import ihm.td5b.MainVue
import ihm.td5b.librairie.Livre
import ihm.td5b.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurModifier(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(event: ActionEvent) {
        var livre=Livre(vue.panneauDroit.textFieldTitre.text,vue.panneauDroit.comboBoxCategorie.selectionModel.selectedItem,vue.panneauDroit.comboBoxAuteur.selectionModel.selectedItem)
        modele.modifierLivre(livre)
        vue.updateLivres(modele.livres,modele.courant)


        vue.panneauDroit= TitledPaneLivre("information livre")
        vue.updatePanneauDroit(vue.panneauDroit)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())
        vue.boutonModification.isDisable=false
        vue.boutonAjout.isDisable=false
        vue.boutonSuppression.isDisable=false
        vue.fixeListenerBouton(vue.panneauDroit.bouton1, ControleurLivrePrecedent(vue, modele))
        vue.fixeListenerBouton(vue.panneauDroit.bouton2,ControleurLivreSuivant(vue, modele))
    }

}
