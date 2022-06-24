module com.milesacq.onlinemonopoly {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.milesacq.onlinemonopoly to javafx.fxml;
    exports com.milesacq.onlinemonopoly;
}