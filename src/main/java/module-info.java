module com.example.projetjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;



    opens com.example.projetjava to javafx.fxml;
    exports com.example.projetjava;
}