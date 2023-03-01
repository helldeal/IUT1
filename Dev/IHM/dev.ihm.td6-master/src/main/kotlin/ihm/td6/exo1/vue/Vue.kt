package ihm.td6.exo1.vue


import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class Vue: VBox() {
    val haut:HBox
    val bas:HBox
    val c1:Label
    val c2:Label
    val res:Label
    val b1:TextField
    val b2:TextField
    val b3:TextField

    init {
        this.haut = HBox()
        this.bas = HBox()
        this.c1=Label("Chaine 1:")
        this.c2=Label("Chaine 2:")
        this.res=Label("Resultat:")
        this.b1=TextField("")
        this.b2=TextField("")
        this.b3=TextField()
        this.children.addAll(haut,bas)
        haut.children.addAll(c1,b1,c2,b2)
        haut.spacing=10.0
        haut.padding= Insets(30.0)
        haut.alignment=Pos.CENTER
        bas.spacing=10.0
        bas.padding= Insets(30.0)
        bas.alignment=Pos.CENTER
        bas.children.addAll(res,b3)
    }





    
}
