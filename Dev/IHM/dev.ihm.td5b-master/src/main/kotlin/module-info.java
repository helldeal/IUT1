module ihm.essaimvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens ihm.td5b to javafx.fxml;
    exports ihm.td5b;
}