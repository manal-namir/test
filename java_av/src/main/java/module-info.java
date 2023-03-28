module com.example.java_av {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_av to javafx.fxml;
    exports com.example.java_av;
}