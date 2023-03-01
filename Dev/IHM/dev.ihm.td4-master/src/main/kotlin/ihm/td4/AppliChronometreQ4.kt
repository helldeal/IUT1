package ihm.td4


import javafx.application.Application
import javafx.stage.Stage


class AppliChronometreQ4: Application() {

// TODO

	override fun start(primaryStage: Stage) {

       // TODO
    }

    fun afficher(tempsSeconde: Long){
        val minutes = tempsSeconde / 60
        val seconde= tempsSeconde-minutes*60
        // modifier le code avec le nom de votre attribut de type TextField
        //this.textField.text=String.format("%02d:%02d",minutes, seconde)

    }

}

fun main() {
    Application.launch(AppliChronometreQ4::class.java)
}




