module ihm.td6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td6.exo2 to javafx.fxml;
    exports ihm.td6.exo1;
    exports ihm.td6.exo2;
    exports ihm.td6.exo3;

}