package com.example.todofx;

import io.github.palexdev.materialfx.controls.MFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    @FXML
    public MFXListView<String> todoList;

    static Scene scene;
    static Stage stage;

    private DB db;


    static void switchScene(ActionEvent e, String name) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(IndexController.class.getResource(name)));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToHome(ActionEvent e) throws IOException {
        switchScene(e, "index.fxml");
    }

    @FXML
    void switchToAddTodo(ActionEvent e) throws IOException {
        switchScene(e, "addTodo.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db = new DB();
        try {
            List all = db.selectAll();
            todoList.getItems().addAll(all);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}