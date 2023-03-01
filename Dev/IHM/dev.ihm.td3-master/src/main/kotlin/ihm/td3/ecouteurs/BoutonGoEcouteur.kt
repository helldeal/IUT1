package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.ActionEvent
import javafx.event.EventHandler



class BoutonGoEcouteur(appli: Appli) : EventHandler<ActionEvent> {
        private val appli: Appli

        //--- Constructeur ---------------------------------
        init {
            this.appli=appli
        }

        //--- Code exécuté lorsque l'événement survient ----
       override  fun handle(event: ActionEvent) {
            var res=appli.labelNbClicBouton.text.toInt()
            res+=1
            appli.labelNbClicBouton.text=res.toString()
        }
    }
