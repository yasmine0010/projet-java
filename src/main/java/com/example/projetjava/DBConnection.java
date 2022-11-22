package com.example.projetjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection con = null;
    public static Connection getCon()

    {
        String databaseName = "teamwork";
        String databaseUser = "root";
        String databasePassword = "souna1994*";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.
                    getConnection(url, databaseUser, databasePassword);
            System.out.println("Ok");

        } catch (Exception e) {
            e.printStackTrace();



        }
        return con;
    }


}