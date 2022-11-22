package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    @FXML
    private TextField usertxt;
    @FXML
    private PasswordField passtxt;
    @FXML
    private Label logginMsg;
    @FXML
    private Button cancelButton;





    public void LoginBut(ActionEvent e) {
        if(usertxt.getText().isBlank()==false && passtxt.getText().isBlank()==false) {

            DBConnection connectionNow=new DBConnection();
            Connection connectDB=connectionNow.getCon();
            String verifLogin="SELECT count(1) FROM employe WHERE login='"+ usertxt.getText() +"' AND password='"+ passtxt.getText() +"'";

            try{
                Statement statement=connectDB.createStatement();
                ResultSet queryResult=statement.executeQuery(verifLogin);

                while (queryResult.next()) {
                    if(queryResult.getInt(1)==1) {
                        new SceneController().changerscene4((Stage)((Node)(e.getSource())).getScene().getWindow(),"interface_employe","intr");



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

    public void CancelBut(ActionEvent event) {
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}

