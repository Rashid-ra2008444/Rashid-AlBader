module org.example.thursday {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.thursday to javafx.fxml;
    exports org.example.thursday;
}