package ihm.td3.ecouteurs

import ihm.td3.Appli
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent

class   RecopieurTexteEcouteur(appli: Appli) : EventHandler<KeyEvent> {
    private val appli: Appli

    //--- Constructeur ---------------------------------
    init {
        this.appli=appli
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: KeyEvent) {
        if ("$" in appli.zoneTexte.text){
            showWarningAlert()
            appli.zoneTexte.text=appli.zoneTexte.text.replace("$","")
        }
        appli.textArea.text=appli.zoneTexte.text
    }
    private fun showWarningAlert(){
        val dialog = Alert(Alert.AlertType.WARNING)
        dialog.title="Erreur"
        dialog.headerText="Erreur de caractère"
        dialog.contentText="Invalid"
        dialog.showAndWait()
    }
}