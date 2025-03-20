package com.mycompany.konyvtar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Kolcson implements Serializable {
    private int id;
    private Konyv konyv;
    private Felhasznalo felhasznalo;
    private Date kolcsondatum;
    private Date hatarido;

    public Kolcson() {
        this.id = 0;
        this.konyv = null;
        this.felhasznalo = null;
        this.kolcsondatum = new Date();
        this.hatarido = new Date();
    }

    public Kolcson(int id, Konyv konyv, Felhasznalo felhasznalo, Date kolcsondatum, Date hatarido) {
        this.id = id;
        this.konyv = konyv;
        this.felhasznalo = felhasznalo;
        this.kolcsondatum = kolcsondatum;
        this.hatarido = hatarido;
    }


    public Konyv getKonyv() {
        return konyv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKonyv(Konyv konyv) {
        this.konyv = konyv;
    }

    public Felhasznalo getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(Felhasznalo felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    public Date getKolcsondatum() {
        return kolcsondatum;
    }

    public void setKolcsondatum(Date kolcsondatum) {
        this.kolcsondatum = kolcsondatum;
    }

    public Date getHatarido() {
        return hatarido;
    }

    public void setHatarido(Date hatarido) {
        this.hatarido = hatarido;
    }
}