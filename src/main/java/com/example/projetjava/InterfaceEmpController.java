package com.example.projetjava;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class InterfaceEmpController {




    public void demandeConge(ActionEvent event) {
        new SceneController().changerscene8((Stage)((Node)(event.getSource())).getScene().getWindow(),"deamndeconge","demande ");




    }
}


