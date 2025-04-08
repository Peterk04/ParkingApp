module com.example.parkingappswdv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkingappswdv to javafx.fxml;
    exports com.example.parkingappswdv;
    exports com.example.parkingappswdv.model;
    opens com.example.parkingappswdv.model to javafx.fxml;
}