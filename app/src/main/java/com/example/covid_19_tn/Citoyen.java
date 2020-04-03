package com.example.covid_19_tn;

import java.util.ArrayList;
import java.util.List;

public class Citoyen {
    private String nom;
    private String prenom;
    private String genre;
    private Integer age;
    private Long tel;
    private Integer poids;
    private Integer taille;
    private Integer codeP;
    private Long cin;
    private List<String> etat = new ArrayList<>();
    private List<String> QRouge = new ArrayList<>();
    private List<String> Qorange = new ArrayList<>();
    public Citoyen(){

    }

    public String getPrenom() {
        return prenom;
    }

    public void setQRouge(List<String> QRouge) {
        this.QRouge = QRouge;
    }

    public void setQorange(List<String> qorange) {
        Qorange = qorange;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getQRouge() {
        return QRouge;
    }

    public List<String> getQorange() {
        return Qorange;
    }

    public Integer getAge() {
        return age;
    }

    public Long getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public void setEtat(List<String> etat) {
        this.etat = etat;
    }

    public List<String> getEtat() {
        return etat;
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getCodeP() {
        return codeP;
    }

    public Long getCin() {
        return cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public void setCodeP(Integer codeP) {
        this.codeP = codeP;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }
}
