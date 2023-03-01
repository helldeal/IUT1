module ihm.td2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td2 to javafx.fxml;
    exports ihm.td2;
}