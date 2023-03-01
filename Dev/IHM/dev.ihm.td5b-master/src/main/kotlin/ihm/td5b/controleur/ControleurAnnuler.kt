package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.ControleurLivrePrecedent
import ihm.td5b.MainVue
import ihm.td5b.vue.TitledPaneLivre
import ihm.td5b.vue.TitledPaneLivreModification
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurAnnuler(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(event: ActionEvent) {
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