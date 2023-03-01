module td5prem.ihm {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td5a to javafx.fxml;
    exports ihm.td5a;
}