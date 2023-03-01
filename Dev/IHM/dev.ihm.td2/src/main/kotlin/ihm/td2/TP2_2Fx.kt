package ihm.td2


import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.stage.Stage

const val TEXTE= ("voici un texte relativement long à "
        + "lire et qui n'a aucune sorte d'intérêt à part"
        + " celui de prendre beaucoup de place et donc "
        + "d'occuper de l'espace dans la TextArea... ")
const val ADMINISTRATEUR = "Administrateur"
const val ETUDIANT = "Etudiant(e)"
const val ENSEIGNANT = "Enseignant(e)"
const val ETAT = "Etat de l'application > en cours d'identification"


class TP2_2Fx: Application() {

    override fun start(primaryStage: Stage) {
        // création du BorderPane principal

        val root = BorderPane()
        val scene = Scene(root, 600.0, 500.0)

        val droite = BorderPane()
        val bas = HBox()
        val gauche =TextArea("jhvosdqfojmvs jioqsfho sHFSH OUSUO Hgso hjFJ DSJH JHJhfd jfhjsdhfjh JHFSJH FGJHSJGH JHSJ HJKH DFJK HSDJKFHQDJK HFJKFH  FJHFJSQHFJKQHFJK QHF JKQHJKF QHJKFHQ DJKHFJ QHJHQ JKFHQJK HFQDKJFHQDKJ FQH JKQHQJK HFQGH SHGOSJDIOQD")
        gauche.isWrapText=true
        bas.style="-fx-border-color: lightgray"
        droite.style="-fx-border-color: lightgray"

        root.bottom=bas
        root.right=droite
        droite.prefWidth=300.0
        root.center=gauche

        val lab= Label("Etat de l'application > en cours d'identification")
        val bar= ProgressBar()
        bas.alignment=Pos.CENTER
        bas.spacing = 10.0
        bas.children.addAll(bar,lab)

        val grid=GridPane()
        val box = VBox()
        droite.bottom=box
        droite.top=grid

        val box1 = VBox()
        val box2 = VBox()
        val cf = Label("Choix Formation")
        val i1 = CheckBox("Info 1")
        val i2 = CheckBox("Info 2")
        val i3 = CheckBox("Info 3")
        val cp = Label("Choix Parcours")
        cp.style="-fx-font-weight: bold"
        cf.style="-fx-font-weight: bold"
        val p1 = CheckBox("Parcours 1")
        val p2 = CheckBox("Parcours 2")
        val p3 = CheckBox("Parocurs 3")
        box.children.addAll(box1,box2)
        box1.children.addAll(cf,i1,i2,i3)
        box2.children.addAll(cp,p1,p2,p3)
        box.padding= Insets(10.0)
        box1.padding= Insets(10.0)
        box2.padding= Insets(10.0)
        box.spacing=10.0
        box1.spacing=10.0
        box2.spacing=10.0

        val bienvenue = Label("Bienvenue")
        bienvenue.style="-fx-font-weight: bold"
        val log = Label("Login :")
        val pswd = Label("Password :")
        val logtxt =TextField()
        val pswdtxt =TextField()
        val prof = ComboBox<String>()
        prof.items.addAll(arrayOf("Enseigant(e)","Eleve"))
        prof.selectionModel.selectFirst()
        val connect = Button("Connexion")
        connect.prefWidth=250.0
        grid.add(bienvenue,0,0)
        grid.add(log,0,1)
        grid.add(pswd,0,2)
        grid.add(logtxt,1,1)
        grid.add(pswdtxt,1,2)
        grid.add(connect,1,3)
        grid.add(prof,0,3)
        grid.style="-fx-border-color: lightgray"
        grid.padding= Insets(0.0,10.0,0.0,10.0)
        box1.style="-fx-border-color: lightgray"
        box2.style="-fx-border-color: lightgray"


        val column1 = ColumnConstraints()
        column1.percentWidth = 45.0
        val column2 = ColumnConstraints()
        column2.percentWidth = 55.0
        grid.columnConstraints.addAll(column1, column2)
        val row1 = RowConstraints()
        row1.prefHeight=30.0
        val row2 = RowConstraints()
        row2.prefHeight=40.0
        val row3 = RowConstraints()
        row3.prefHeight=40.0
        val row4 = RowConstraints()
        row4.prefHeight=80.0
        grid.rowConstraints.addAll(row1,row2,row3,row4)




        primaryStage.title="TP2_2 en javaFX"
        primaryStage.scene=scene
        primaryStage.show()
    }
}


fun main() {
    Application.launch(TP2_2Fx::class.java)
}





