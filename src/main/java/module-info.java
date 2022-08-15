module com.example.todofx {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
                        
    opens com.example.todofx to javafx.fxml;
    exports com.example.todofx;
}