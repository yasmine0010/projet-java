package com.example.projetjava;
import java.lang.Integer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class interfaceAdController implements Initializable {
    @FXML
    private DatePicker tf_date;


    @FXML
    private TextField tf_lieu;

    @FXML
    private TextField tf_prof;
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_etat;

    @FXML
    private TextField tf_num;
    @FXML
    private TextField tf_email;

    @FXML
    private TableView<Employe> table;

    @FXML
    private TableColumn<Employe, Integer> id;

    @FXML
    private TableColumn<Employe, String> nom;

    @FXML
    private TableColumn<Employe, String> prenom;
    @FXML
    private TableColumn<Employe, String> date_naiss;
    @FXML
    private TableColumn<Employe,String> lieu_naiss;
    @FXML
    private TableColumn<Employe, String> etat_civil;

    @FXML
    private TableColumn<Employe, Integer> num;
    @FXML
    private TableColumn<Employe,String> email;
    @FXML
    private TableColumn<Employe,String> profession;
    @FXML
    private Button ajouterButton;

    String query = null;
    @FXML
    private TextField rechercherEmp;
    private boolean update;
    PreparedStatement st ;
    ResultSet rs = null;
    Connection con ;
    Employe employe=null;
    int employeId;
    int myIndex;

    DatePicker date;





    public ObservableList<Employe> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DBConnection connectionNow = new DBConnection();
            Connection connectDB = connectionNow.getCon();
            String sql = "SELECT * FROM personnel ORDER BY nom";
            PreparedStatement stat = connectDB.prepareStatement(sql);
            ResultSet queryResult = stat.executeQuery();


            while (queryResult.next()) {

                data.add(new Employe(queryResult.getInt(1),
                        queryResult.getString(2),queryResult.getString(3),
                        queryResult.getDate(4),queryResult.getString(5),
                        queryResult.getString(6),queryResult.getString(7),queryResult.getString(8),
                        queryResult.getString(9)));




            }
            connectDB.close();
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            date_naiss.setCellValueFactory(new PropertyValueFactory<>("date_naiss") );

            lieu_naiss.setCellValueFactory(new PropertyValueFactory<>("lieu_naiss"));
            etat_civil.setCellValueFactory(new PropertyValueFactory<>("etat_civil"));
            num.setCellValueFactory(new PropertyValueFactory<>("num"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            profession.setCellValueFactory(new PropertyValueFactory<>("profession"));

            table.setItems(data);

            FilteredList<Employe>filterData =new FilteredList<>(data,b->true);
            rechercherEmp.textProperty().addListener((observable, oldValue,newValue)-> {
                filterData.setPredicate(Employe->{
                    if(newValue.isEmpty()|| newValue.isBlank()||newValue == null){

                        return true;

                    }

                    String serachKeybord=newValue.toLowerCase();
                    if (Employe.getNom().toLowerCase().indexOf(serachKeybord ) > -1){
                        return true;

                    } else if (Employe.getNom().toLowerCase().indexOf(serachKeybord) > -1) {
                        return true;

                    }else


                        return false;
                });

            });
            SortedList<Employe>sortedData=new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);


        } catch (Exception e) {
            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, e);

            e.printStackTrace();

        }
        table.setRowFactory( tv -> {
            TableRow<Employe> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();

                    employeId= Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    tf_nom.setText(table.getItems().get(myIndex).getNom());
                    tf_prenom.setText(table.getItems().get(myIndex).getPrenom());
                    tf_lieu.setText(table.getItems().get(myIndex).getLieu_naiss());
                    tf_etat.setText(table.getItems().get(myIndex).getEtat_civil());
                    tf_num.setText(table.getItems().get(myIndex).getNum());
                    tf_email.setText(table.getItems().get(myIndex).getEmail());
                    tf_prof.setText(table.getItems().get(myIndex).getProfession());






                }
            });
            return myRow;
        });

    }



    public void ModifierEmp(ActionEvent event) {
        String date_nais ,num,nom,prenom,lieu_naiss,etat_civil,email,profession;


        con = DBConnection.getCon();
        myIndex = table.getSelectionModel().getSelectedIndex();

        nom = tf_nom.getText();
        prenom = tf_prenom.getText();
        date_nais=String.valueOf(tf_date.getValue());
        lieu_naiss= tf_lieu.getText();
        etat_civil=tf_lieu.getText();
        num=tf_num.getText();
        email=tf_email.getText();
        profession=tf_prof.getText();
        try {
            String modifier="UPDATE personnel set nom=?, prenom=?, date_naiss=?, lieu_naiss=?, etat_civil=?, num=?,email=?, profession=? where id='"+employeId+"'";

            st = con.prepareStatement(modifier);

            st.setString(1, nom);
            st.setString(2, prenom);
            st.setString(3,date_nais);
            st.setString(4, lieu_naiss);
            st.setString(5, etat_civil);
            st.setString(6, num);
            st.setString(7, email);
            st.setString(8, profession);
            st.executeUpdate();

            JOptionPane.showMessageDialog(null,"vous voulez modifier??");
            clean();
            refreshTable();


        }catch(SQLException ex){
            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, ex);

        }



    }
    @FXML
    public void supprimerEmp(ActionEvent event) {

        con = DBConnection.getCon();
        myIndex = table.getSelectionModel().getSelectedIndex();
        employeId = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        String effacer="delete from personnel where id=?";
        try {


            st = con.prepareStatement(effacer);;
            st.setInt(1,employeId);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"supprimer avec succees");

            refreshTable();



        }catch (SQLException ex) {

            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void clean() {
        tf_id.setText(null);
        tf_nom.setText(null);
        tf_prenom.setText(null);
        tf_date.setValue(null);
        tf_lieu.setText(null);
        tf_etat.setText(null);
        tf_num.setText(null);
        tf_email.setText(null);
        tf_prof.setText(null);}
    private void getQuery() {



            query = "INSERT INTO `personnel` VALUES (?,?,?,?,?,?,?,?,?)";



    }

    void setUpdate(boolean b) {
        this.update = b;

    }

    @FXML
    public void aojuterEMp(ActionEvent event) {
        con = DBConnection.getCon();
        employeId=Integer.parseInt(tf_id.getText());
        String nom = tf_nom.getText();
        String prenom = tf_nom.getText();
        String date = String.valueOf(tf_date.getValue());
        String lieu = tf_lieu.getText();
        String etat = tf_etat.getText();
        String num=tf_num.getText();

        String email=tf_email.getText();
        String profession = tf_prof.getText();



        if (nom.isEmpty() || prenom.isEmpty() || date.isEmpty() || lieu.isEmpty() || etat.isEmpty()|| email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            getQuery();

            insert();

            clean();
            refreshTable();

        }



    }


    private void insert() {
        try {

            st = con.prepareStatement(query);

            st = con.prepareStatement(query);
            st.setInt(1, Integer.parseInt(tf_id.getText()));

            st.setString(2, tf_nom.getText());
            st.setString(3, tf_prenom.getText());

            st.setString(4, String.valueOf(tf_date.getValue()));
            st.setString(5, tf_lieu.getText());
            st.setString(6, tf_etat.getText());
            st.setString(7, tf_num.getText());
            st.setString(8, tf_email.getText());
            st.setString(9, tf_prof.getText());

            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void refreshTable() {

        data.clear();
        con = DBConnection.getCon();
        query = "SELECT * FROM `personnel`";
        try {


            st = con.prepareStatement(query);

            rs = st.executeQuery();

            while (rs.next()) {
                data.add(new Employe(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("date_naiss"),
                        rs.getString("lieu_naiss"),
                        rs.getString("etat_civil"),
                        rs.getString("num"),
                        rs.getString("email"),
                        rs.getString("profession")));
                table.setItems(data);


            }
        } catch (SQLException ex) {
            Logger.getLogger(interfaceAdController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}