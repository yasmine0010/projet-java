package com.example.projetjava;
import java.net.URL;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginAdController {
    @FXML
    private TextField usertxt;
    @FXML
    private PasswordField passtxt;
    @FXML
    private Label logginMsg;
    @FXML
    private Button cancelButton;
    



    public void Loginbut(ActionEvent event){
        if(usertxt.getText().isBlank()==false && passtxt.getText().isBlank()==false) {

            DBConnection connectionNow=new DBConnection();
            Connection connectDB=connectionNow.getCon();
            String verifLogin="SELECT count(1) FROM admin WHERE login='"+ usertxt.getText() +"' AND password='"+ passtxt.getText() +"'";

            try{
                Statement statement=connectDB.createStatement();
                ResultSet queryResult=statement.executeQuery(verifLogin);

                while (queryResult.next()) {
                    if(queryResult.getInt(1)==1) {
                        new SceneController().changerscene3((Stage)((Node)(event.getSource())).getScene().getWindow(),"interface admin","login");

                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid login,Please try again");

                    }

                }


            }catch(Exception exception){
                exception.printStackTrace();

            }



        }else{

            JOptionPane.showMessageDialog(null,"Please enter user name and password");
        }

    }



    public void cancelBut(ActionEvent event) {
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



}
