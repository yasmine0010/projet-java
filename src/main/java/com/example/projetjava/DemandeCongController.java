package com.example.projetjava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DemandeCongController {


            @FXML
            private Button ajouterButton;

            @FXML
            private DatePicker tf_date_rep;

            @FXML
            private Button supprimerButton;

            @FXML
            private DatePicker tf_date_deb;

            @FXML
            private CheckBox maternité;

            @FXML
            private CheckBox anuelle;

            @FXML
            private CheckBox maladie;
            @FXML
            private TextField tf_id;
            @FXML
            private TextField tf_prenom;


    @FXML
            private DatePicker tf_date_fin;
            ResultSet rs = null;
            Connection con ;
            PreparedStatement st ;






    public void fermer(javafx.event.ActionEvent event) {
    }

    public void demande(javafx.event.ActionEvent event) {
                    int id=Integer.parseInt(tf_id.getText());
                    String prenom=tf_prenom.getText();
                    String date_deb = String.valueOf(tf_date_deb.getValue());
                    String date_fin = String.valueOf(tf_date_fin.getValue());
                    String date_reprise = String.valueOf(tf_date_rep.getValue());
                    Boolean maladieSelected = maladie.isSelected();
                    Boolean materniteSelected = maternité.isSelected();
                    Boolean annuelleSelected = anuelle.isSelected();
                    String type_conge = null;
                    if(maladieSelected) {
                        type_conge= "maladie";
                    }else if (materniteSelected) {
                        type_conge= "maternite";
                    }else{
                        type_conge= "annuelle";
                    }

                    // System.out.println(nom+prenom+id+date_deb+date_fin+date_reprise+" et maladie "+maladieSelected);
                    System.out.println(date_deb+date_fin+date_reprise+" et maladie "+maladieSelected);

                    con = DBConnection.getCon();


                    Statement st= null;
                    try {
                        st = con.createStatement();
                        System.out.println("hello");
                        int a=st.executeUpdate("insert into congé   values('"+id+"','"+prenom+"','"+date_deb+"','"+date_fin+"','"+date_reprise+"','"+type_conge+"') ");
                        if (a>0){
                            JOptionPane.showMessageDialog(null,"Envoyer avec succes");



                        }
                        else{
                            JOptionPane.showMessageDialog(null,"echec");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e.getMessage());



                    }

                }


}


