module com.example.sign_in_up {
    requires javafx.controls;
    requires javafx.fxml;
requires java.sql;

    opens com.example.sign_in_up to javafx.fxml;
    exports com.example.sign_in_up;
}