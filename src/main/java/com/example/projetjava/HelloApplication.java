package com.example.projetjava;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public HelloApplication() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root1 = fxmlLoader.load();
        Scene scene = new Scene(root1);
        stage.setTitle("Hello!");
        stage.setScene(scene);



        Stage splash = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("splashscreen.fxml"));
        Parent root2 = loader.load();
        Scene s = new Scene(root2);
        splash.setScene(s);
        splash.show();





        // public static void main(String[] args) {



        new Thread(new Runnable() {
            @Override
            public void run() {
                //ici traitement à faire
                try {
                    Thread.sleep(3000); //endormir 2 sec
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        splash.hide();
                        stage.show();

                    }
                });
            }
        }).start();

    }
}
