module Lab13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens com.example.lab13 to javafx.fxml;
    exports com.example.lab13;
}