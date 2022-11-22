package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class interfaceResponsable{


    public void conge(ActionEvent e ){
        new SceneController().changerscene9((Stage)((Node)(e.getSource())).getScene().getWindow(),"gererConge","Conge ");


    }
}
