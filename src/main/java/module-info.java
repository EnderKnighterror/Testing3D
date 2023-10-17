module com.example.testing3d {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.testing3d to javafx.fxml;
    exports com.example.testing3d;
}