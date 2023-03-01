package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurLivreSuivant(vue: MainVue, modele: Bibliotheque): EventHandler<ActionEvent> {

    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(event: ActionEvent) {
        if (modele.livreSuivantPossible()){
            modele.livreSuivant()
        } else {
            modele.courant = 0
        }
        vue.updateLivres(modele.livres,ControleurDetailLivre(vue, modele),modele.courant)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())
        vue.updatePanneauDroit(vue.panneauDroit)
    }

}