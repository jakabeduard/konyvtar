package com.mycompany.konyvtar;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Kolcson implements Serializable {
    private int id;
    private Konyv konyv;
    private Felhasznalo felhasznalo;
    private LocalDate kolcsondatum;
    private LocalDate hatarido;

    public Kolcson() {
        
    }

    public Kolcson(int id, Konyv konyv, Felhasznalo felhasznalo, LocalDate kolcsondatum, LocalDate hatarido) {
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

    public LocalDate getKolcsondatum() {
        return kolcsondatum;
    }

    public void setKolcsondatum(LocalDate kolcsondatum) {
        this.kolcsondatum = kolcsondatum;
    }

    public LocalDate getHatarido() {
        return hatarido;
    }

    public void setHatarido(LocalDate hatarido) {
        this.hatarido = hatarido;
    }
}