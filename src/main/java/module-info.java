module com.example.todofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires MaterialFX;
    requires java.sql;
    requires ormlite.core;
    requires sqlite.jdbc;

    opens com.example.todofx to javafx.fxml;
    exports com.example.todofx;
}