package ihm.td2

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.*
import javafx.stage.Stage


class TD2_1Fx: Application() {

    override fun start(primaryStage: Stage) {

        val root=GridPane()


        val un=FlowPane(Orientation.VERTICAL)
        val deux=BorderPane()
        root.add(un,0,0)
        root.add(deux,1,0)
        val column1 = ColumnConstraints()
        column1.percentWidth = 40.0
        val column2 = ColumnConstraints()
        column2.percentWidth = 60.0
        root.columnConstraints.addAll(column1, column2)
        val row1 = RowConstraints()
        row1.percentHeight = 100.0
        root.rowConstraints.addAll(row1)

        val btn1 = Button("1")
        val btn2 = Button("2")
        val btn3 = Button("3")
        btn3.prefHeight=100.0
        btn3.prefWidth=100.0
        val btn4 = Button("4")
        val btn5 = Button("5")
        val btn6 = Button("6")

        un.alignment=Pos.CENTER
        un.padding = Insets(20.0)
        un.vgap = 10.0
        un.style="-fx-background-color: pink"
        un.children.addAll(btn1,btn2,btn3,btn4,btn5,btn6)

        val btntop=Button("^")
        btntop.maxWidth= Double.MAX_VALUE
        deux.top = btntop
        val btncentre=Button("Activation")
        btncentre.maxHeight= Double.MAX_VALUE
        btncentre.maxWidth= Double.MAX_VALUE
        deux.center = btncentre
        val btng=Button("<")
        btng.maxHeight= Double.MAX_VALUE
        deux.left = btng
        val btnd=Button(">")
        btnd.maxHeight= Double.MAX_VALUE
        deux.right =btnd

        val scene = Scene(root, 300.0, 300.0)
        primaryStage.title="TP2_1 en javaFX"
        primaryStage.scene=scene
        primaryStage.show()
    }
}


fun main() {
    Application.launch(TD2_1Fx::class.java)
}

