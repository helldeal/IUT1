package ihm.td6.exo2.controleur

import ihm.td6.exo2.vue.Vue
import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleDoubleProperty
import javafx.scene.Scene
import javafx.util.converter.NumberStringConverter


class ControleurBinding(vue: Vue) {
    val vue: Vue

    init {
        this.vue=vue
    }

    fun bindModeleVue(scene: Scene){
        val converter= NumberStringConverter()
        vue.textField.textProperty().bindBidirectional(vue.slider.valueProperty(),converter)
        vue.cercle.radiusProperty().bind(vue.slider.valueProperty())
        vue.slider.value=50.0

        vue.cercle.centerXProperty().bind(scene.widthProperty().divide(2.0))
        vue.cercle.centerYProperty().bind(scene.heightProperty().divide(2.0).add(-50.0))
        vue.cercle.fillProperty().bind(vue.colorPicker.valueProperty())



    }

}