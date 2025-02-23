/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konyvtar;

/**
 *
 * @author Eduard
 */
public class Felhasznalo implements java.io.Serializable {
    private int felhasznaloID;
    private String nev;
    private String email;
    private String telefon;
    private String jelszo;

    public Felhasznalo() {
    }

    public Felhasznalo(int felhasznaloID, String nev, String email, String telefon, String jelszo) {
        this.felhasznaloID = felhasznaloID;
        this.nev = nev;
        this.email = email;
        this.telefon = telefon;
        this.jelszo = jelszo;
    }

    public int getFelhasznaloID() {
        return felhasznaloID;
    }

    public String getNev() {
        return nev;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setFelhasznaloID(int felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
}
