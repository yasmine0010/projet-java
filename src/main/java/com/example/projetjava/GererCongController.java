package com.example.projetjava;
import java.lang.Integer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GererCongController implements Initializable {
    @FXML
    private TableView<Conge> tableCong;

    @FXML
    private TableColumn<Conge, String> datedebCol;

    @FXML
    private TableColumn<Conge, Integer> id_col;
    @FXML
    private TableColumn<Conge, String> prenom_col;

    @FXML
    private TableColumn<Conge, String> daterepCol;
    @FXML
    private TableColumn<?, ?> type_col;

    @FXML
    private TableColumn<Conge, String> datefinCol;
    PreparedStatement st ;
    ResultSet rs = null;
    Connection con ;
    int myIndex;
    int employeId ;
    
    public ObservableList<Conge> cong = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DBConnection connectionNow = new DBConnection();
            Connection connectDB = connectionNow.getCon();
            String sql = "SELECT * FROM congé ";
            PreparedStatement stat = connectDB.prepareStatement(sql);
            ResultSet queryResult = stat.executeQuery();


            while (queryResult.next()) {

                cong.add(new Conge(queryResult.getInt(1),
                        queryResult.getString(2), queryResult.getDate(3),
                        queryResult.getDate(4), queryResult.getDate(5),queryResult.getString(6)));



            }
            connectDB.close();
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));

            datedebCol.setCellValueFactory(new PropertyValueFactory<>("dat_deb"));
            datefinCol.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
            daterepCol.setCellValueFactory(new PropertyValueFactory<>("date_rep"));

            type_col.setCellValueFactory(new PropertyValueFactory<>("type_conge"));

            tableCong.setItems(cong);


        } catch (Exception e) {
            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, e);

            e.printStackTrace();

        }
        tableCong.setRowFactory( tv -> {
            TableRow<Conge> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  tableCong.getSelectionModel().getSelectedIndex();

                    employeId= Integer.parseInt(String.valueOf(tableCong.getItems().get(myIndex).getId()));

                    prenom_col.setText(tableCong.getItems().get(myIndex).getPrenom());




                }
            });
            return myRow;
        });

    }


    public void accepter(ActionEvent event) {
    }

    public void reffuser(ActionEvent event) {
    }
}
