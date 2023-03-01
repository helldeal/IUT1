module ihm.td4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td4 to javafx.fxml;
    exports ihm.td4;
}