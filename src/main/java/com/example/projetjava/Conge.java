package com.example.projetjava;

import java.sql.Date;

public class Conge {
    private int id;
    private String prenom;
    private java.sql.Date dat_deb;
    private java.sql.Date date_fin;
    private java.sql.Date date_rep;
    private String type_conge;

    public Conge(int id, String prenom, Date dat_deb, Date date_fin, Date date_rep, String type_conge) {
        super();
        this.id = id;
        this.prenom = prenom;
        this.dat_deb = dat_deb;
        this.date_fin = date_fin;
        this.date_rep = date_rep;
        this.type_conge = type_conge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDat_deb() {
        return dat_deb;
    }

    public void setDat_deb(Date dat_deb) {
        this.dat_deb = dat_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getDate_rep() {
        return date_rep;
    }

    public void setDate_rep(Date date_rep) {
        this.date_rep = date_rep;
    }

    public String getType_conge() {
        return type_conge;
    }

    public void setType_conge(String type_conge) {
        this.type_conge = type_conge;
    }
}

