package org.example.entities;

import java.time.LocalDate;

public class Jeux {
    private int id;
    private String titre;
    private String genre;
    private boolean multijoueur;
    private double prix;
    private LocalDate date;

    public Jeux(){};

    public Jeux(String titre, String genre, boolean multijoueur, double prix, LocalDate date){
        this();
        this.titre = titre;
        this.genre = genre;
        this.multijoueur = multijoueur;
        this.prix = prix;
        this.date = date;
    }

    public Jeux(int id, String titre, String genre, boolean multijoueur, double prix, LocalDate date){
        this(titre, genre, multijoueur, prix, date);
        this.id = id;
    }


    //region GET/SET

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isMultijoueur() {
        return multijoueur;
    }

    public double getPrix() {
        return prix;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMultijoueur(boolean multijoueur) {
        this.multijoueur = multijoueur;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }
    //endregion

    @Override
    public String toString() {
        return "Jeux{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", genre='" + genre + '\'' +
                ", multijoueur='" + multijoueur + '\''+
                ", prix=" + prix +
                ", date de sortie=" + date +
                '}';
    }
}