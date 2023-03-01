package ihm.td3

import ihm.td3.ecouteurs.*
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.ActionEvent.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlin.coroutines.coroutineContext


class Appli: Application() {


	// les noeuds qui pourront être manipulés par les écouteurs
	val labelNbClicBouton:Label
	val labelNbClicPanneau: Label
	val panneauCouleurs: Pane
	val zoneTexte: TextField
	val textArea: TextArea
	val panneauHaut: FlowPane
	val panneauBas: FlowPane
	val choixCouleurs: ComboBox<String>

	init{
		this.labelNbClicBouton=Label()
		this.labelNbClicPanneau=Label()
		this.panneauCouleurs = Pane()
		this.zoneTexte=TextField("")
		this.textArea=TextArea()
		this.panneauHaut= FlowPane()
		this.panneauBas= FlowPane()
		this.choixCouleurs=ComboBox<String>()

	}

	override fun start(primaryStage: Stage) {

		// le panneau situé en haut et ses composants graphiques
		val go = Button("go")
		val couleurspossible = arrayOf("Bleu", "Vert", "Rouge")
		this.choixCouleurs.items.addAll(couleurspossible)

		choixCouleurs.selectionModel.select(0)
		zoneTexte.prefColumnCount = 15

		panneauHaut.alignment = Pos.TOP_CENTER
		panneauHaut.hgap = 20.0
		panneauHaut.padding= Insets(10.0)
		panneauHaut.children.addAll(go,choixCouleurs, zoneTexte)

		// le panneau situé à droite qui sera coloré
		panneauCouleurs.style = "-fx-background-color: blue;"

		// le textarea
		textArea.isWrapText = true
		textArea.isDisable = true
		textArea.prefRowCount = 10
		textArea.prefColumnCount = 10
		textArea.style="-fx-text-fill: black"

		// le panneau situé en bas et ses composants graphiques
		labelNbClicBouton.text = "0"
		labelNbClicPanneau.text = "0"
		val cliquer = Label("Clics sur \"ok\" / zone de texte + Panneaux colorés = ")
		panneauBas.hgap = 10.0
		panneauBas.alignment = Pos.TOP_CENTER
		panneauBas.padding= Insets(10.0)
		panneauBas.children.addAll(cliquer, labelNbClicBouton, labelNbClicPanneau)

		// le panneau principal
		val root = BorderPane()
		root.top = panneauHaut
		root.center = panneauCouleurs
		root.bottom = panneauBas
		root.left = textArea

		//EVENT
		go.addEventHandler(ActionEvent.ACTION,BoutonGoEcouteur(this))
		choixCouleurs.addEventHandler(ActionEvent.ACTION,ChoixCouleurEcouteur(this))
		panneauCouleurs.addEventHandler(MouseEvent.MOUSE_CLICKED,ClicPanneauEcouteur(this))
		zoneTexte.addEventHandler(KeyEvent.KEY_RELEASED,RecopieurTexteEcouteur(this))
		zoneTexte.addEventHandler(MouseEvent.MOUSE_CLICKED,EffaceurTexteEcouteur(this))
		panneauHaut.addEventHandler(MouseEvent.ANY,PanneauHautEcouteur(this))
		root.addEventHandler(KeyEvent.ANY,EcouteurToucheControl(this))


		val scene = Scene(root, 1000.0, 600.0)
		primaryStage.title="TD3 en javaFX exercice 1"
		primaryStage.scene=scene
		primaryStage.show()
	}

}

fun main() {
	Application.launch(Appli::class.java)
}
