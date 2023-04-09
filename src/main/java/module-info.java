module com.example.ad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ad to javafx.fxml;
    exports com.example.ad;
}