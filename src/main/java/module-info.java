module com.example.proyecto_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.proyecto_1 to javafx.fxml;
    exports com.example.proyecto_1;
}