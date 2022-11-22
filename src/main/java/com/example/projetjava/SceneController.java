package com.example.projetjava;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    public void changerscene(Stage stage,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();
            stage.show();

        }
    }
    public void changerscene1(Stage stage,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login-admin.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();
            stage.show();

        }
    }
    public void changerscene2(Stage stage,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-responsable.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public void changerscene3(Stage stage,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interface admin.fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public void changerscene4(Stage s,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interface_employe.fxml")));
            s.setScene(new Scene(root));
            s.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public void changerscene5(Stage s,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("interfaceResponsable.fxml")));
            s.setScene(new Scene(root));
            s.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public void changerscene8(Stage s,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deamndeConge.fxml")));
            s.setScene(new Scene(root));
            s.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public void changerscene9(Stage s,String viewName, String title){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gererConge.fxml")));
            s.setScene(new Scene(root));
            s.setTitle(title);
        }catch(IOException e){
            e.printStackTrace();

        }
    }



}
