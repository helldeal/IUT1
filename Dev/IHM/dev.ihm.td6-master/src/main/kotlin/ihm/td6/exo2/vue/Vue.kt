package ihm.td6.exo2.vue

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.util.converter.DoubleStringConverter
import javafx.util.converter.IntegerStringConverter
import java.util.function.UnaryOperator


class Vue: BorderPane() {
    val cercle: Circle
    val textField:TextField
    val slider: Slider
    val panelCentre: Pane
    val colorPicker: ColorPicker
    val buttonDetail: Button


    /**
     * classe interne qui permet de filtrer l'entrée du textField => un nombre entier etre 0 et le max du slider
     * on aurait pu réaliser la même chose avec un écouteur
     * */
    private class SliderFilter(sliderMax: Double) : UnaryOperator<TextFormatter.Change?> {

        private val sliderMax=sliderMax
        /**
         * redéfinition de la méthode apply qui sera exécuté à la saisie d'un caractère
         * filtre les caractères saisis qui ne sont pas des nombres et
         */
        override fun apply(change: TextFormatter.Change?): TextFormatter.Change? {
            try {
                if ((change?.controlNewText!="") && (change?.controlNewText!!.toDouble() <= this.sliderMax)) {
                    return change
                } else {
                    change.text = ""
                    return change
                }
            } catch (exception: NumberFormatException) {
                return null
            }
        }
    }


    init {
        this.panelCentre = Pane()
        val panelBas = FlowPane()
        val labelTextField = Label("rayon:")
        this.textField= TextField()
        slider = Slider(0.0, 220.0, 1.0)
        slider.isShowTickLabels=true
        slider.isShowTickMarks=true
        slider.padding= Insets(10.0)
        // on associe le textfield à un textformater qui va filtrer les caractères saisis avec le filtre que nous avons écrit précédemment
        // le seconde valeur passée en paramètre est la valeur par défaut dans le TextField
        val textFormatter= TextFormatter(IntegerStringConverter(),0, SliderFilter(slider.max))
        textField.textFormatter = textFormatter
        this.textField.prefColumnCount=4
        val labelColorPicker = Label("couleur:")
        this.colorPicker=ColorPicker(Color.BLACK)
        this.buttonDetail=Button("Détail")
        this.cercle=Circle()
        panelCentre.children.add(this.cercle)

        panelBas.children.addAll(labelTextField,this.textField,labelColorPicker, this.colorPicker, this.buttonDetail)
        panelBas.hgap=10.0
        panelBas.padding=Insets(10.0)

        this.bottom = panelBas
        this.center=panelCentre
        this.top=slider

    }
    fun fixeListenerBoutonDetail(ecouteur: EventHandler<ActionEvent>){
        this.buttonDetail.onAction=ecouteur
    }
}