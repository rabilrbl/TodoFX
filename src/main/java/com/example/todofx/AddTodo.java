package com.example.todofx;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddTodo implements Initializable {
    @FXML
    private MFXTextField taskName;

    private DB db;
    @FXML
    void goBack(ActionEvent e) throws IOException {
        IndexController.switchScene(e, "index.fxml");
    }

    @FXML
    void addTask(ActionEvent e) throws SQLException, IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Added Task");
        alert.setContentText("Task "+taskName.getText()+" added successfully!");

        db.insert(taskName.getText());
        System.out.println("Added "+taskName.getText());

        alert.show();
        goBack(e);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db = new DB();
    }
}
