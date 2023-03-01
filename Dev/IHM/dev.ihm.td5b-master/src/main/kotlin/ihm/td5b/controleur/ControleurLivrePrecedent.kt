package ihm.td5b

import ihm.td5b.controleur.ControleurDetailLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurLivrePrecedent(vue: MainVue, modele: Bibliotheque): EventHandler <ActionEvent> {

    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(event: ActionEvent) {
       if (modele.livrePrecedentPossible()){
           modele.livrePrecedent()
       } else {
           modele.courant = modele.dernier
       }
        vue.updateLivres(modele.livres, ControleurDetailLivre(vue, modele),modele.courant)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())
        vue.updatePanneauDroit(vue.panneauDroit)
    }

}
