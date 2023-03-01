package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.MainVue
import ihm.td5b.librairie.Auteur
import ihm.td5b.librairie.Livre
import ihm.td5b.vue.TitledPaneLivreAjout
import ihm.td5b.vue.TitledPaneLivreModification
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.text.Text

class ControleurAjout(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }
    override fun handle(event: ActionEvent) {

        vue.panneauDroit= TitledPaneLivreAjout("ajout livre")
        vue.updatePanneauDroit(vue.panneauDroit)
        vue.panneauDroit.update(modele.livres.size,modele.donneLivre())
        vue.boutonModification.isDisable=true
        vue.boutonAjout.isDisable=true
        vue.boutonSuppression.isDisable=true
        vue.fixeListenerBouton(vue.panneauDroit.bouton1, ControleurAjouter(vue, modele))
        vue.fixeListenerBouton(vue.panneauDroit.bouton2, ControleurAnnuler(vue, modele))
        vue.panneauDroit.comboBoxAuteur.items.clear()
        vue.panneauDroit.comboBoxAuteur.items.addAll(modele.donneTousLesAuteurs())
        vue.panneauDroit.numero= modele.livres.size



    }


}
