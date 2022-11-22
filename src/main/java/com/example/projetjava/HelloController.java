package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Button empButton;




    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }



    public void empButt(ActionEvent event) {
        new SceneController().changerscene((Stage)((Node)(event.getSource())).getScene().getWindow(),"Login.fxml","login-admin ");





    }

    public void adminButton(ActionEvent event) {
        new SceneController().changerscene1((Stage)((Node)(event.getSource())).getScene().getWindow(),"Login-admin.fxml","login-admin ");

    }

    public void respButton(ActionEvent event) {
        new SceneController().changerscene2((Stage)((Node)(event.getSource())).getScene().getWindow(),"login-responsable.fxml","login2");
    }


}