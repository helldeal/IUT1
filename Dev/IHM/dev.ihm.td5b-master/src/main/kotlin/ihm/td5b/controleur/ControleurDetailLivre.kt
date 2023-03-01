package ihm.td5b.controleur

import ihm.td5b.Bibliotheque
import ihm.td5b.MainVue
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

class ControleurDetailLivre(vue: MainVue,modele: Bibliotheque ): EventHandler<MouseEvent> {
    private val vue: MainVue
    private val modele: Bibliotheque

    init {
        this.vue = vue
        this.modele = modele
    }


    override fun handle(event: MouseEvent) {


        vue.effacerSelectionPanneauGauche()
        for (i in modele.livres){
            if (i.titre==event.source.toString().substringAfter("'").substringBeforeLast("'")){
                modele.courant  = i.numero-1
            }

        }
        vue.selectionnerLignePanneauGauche(modele.courant)
        vue.panneauDroit.update(modele.courant,modele.donneLivre())
        vue.updatePanneauDroit(vue.panneauDroit)
    }
}
