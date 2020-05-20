package com.example.ithilgore.homelibrary;

import java.io.Serializable;

public class Book implements Serializable {
    private String imie;
    private String nazwisko;
    private String tytul;
    private String seria;
    private String tom;
    private String rokWydania;
    private String wydawnictwo;

    public Book(){}

    public Book(String imie, String nazwisko, String tytul, String seria, String tom, String rokWydania, String wydawnictwo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.seria = seria;
        this.tom = tom;
        this.rokWydania = rokWydania;
        this.wydawnictwo = wydawnictwo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getTom() {
        return tom;
    }

    public void setTom(String tom) {
        this.tom = tom;
    }

    public String getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(String rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }
}
