module com.example.dsgraphicalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsgraphicalproject to javafx.fxml;
    exports com.example.dsgraphicalproject;
}