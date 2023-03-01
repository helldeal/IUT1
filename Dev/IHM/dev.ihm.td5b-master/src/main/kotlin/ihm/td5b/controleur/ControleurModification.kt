package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.MainVue
import ihm.td5b.vue.TitledPaneLivreModification
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurModification(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(event: ActionEvent) {
       vue.panneauDroit=TitledPaneLivreModification("modification livre")
        vue.updatePanneauDroit(vue.panneauDroit)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())
        vue.boutonModification.isDisable=true
        vue.boutonAjout.isDisable=true
        vue.boutonSuppression.isDisable=true
        vue.fixeListenerBouton(vue.panneauDroit.bouton1, ControleurModifier(vue, modele))
        vue.fixeListenerBouton(vue.panneauDroit.bouton2, ControleurAnnuler(vue, modele))

    }
}