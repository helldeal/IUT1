module ihm.td3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td3 to javafx.fxml;
    exports ihm.td3;
}