module ihm.td1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td1 to javafx.fxml;
    exports ihm.td1;
}