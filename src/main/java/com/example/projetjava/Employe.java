package com.example.projetjava;


import java.util.Date;

public class Employe {
     Integer id;
     String nom;
     String Prenom;
     Date date_naiss;
     String lieu_naiss;
     String etat_civil;
     String num;
     String email;
     String profession;
    public Employe (Integer id, String nom , String Prenom, Date date_naiss, String lieu_naiss , String etat_civil, String num, String email, String profession){
    this.id=id;
    this.nom=nom;
    this.Prenom=Prenom;
    this.date_naiss=date_naiss;
    this.lieu_naiss=lieu_naiss;
    this.etat_civil=etat_civil;
    this.num= (num);
    this.email=email;
    this.profession=profession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getLieu_naiss() {
        return lieu_naiss;
    }

    public void setLieu_naiss(String lieu_naiss) {
        this.lieu_naiss = lieu_naiss;
    }

    public String getEtat_civil() {
        return etat_civil;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


}

