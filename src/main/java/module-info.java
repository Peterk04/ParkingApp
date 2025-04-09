module com.example.parkingappsoftwaredv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkingappsoftwaredv to javafx.fxml;
    exports com.example.parkingappsoftwaredv;
}