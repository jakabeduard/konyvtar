/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konyvtar;

/**
 *
 * @author Eduard
 */
public class Konyvtaros  implements java.io.Serializable {
    private int konyvtaros_id;
    private String nev;
    private String email;
    private String telefon;
    private int alkalmazas_eve;
    private int fizetes;
    private String jelszo;

    public Konyvtaros() {
    }

    public Konyvtaros(int konyvtaros_id, String nev, String email, String telefon, int alkalmazas_eve, int fizetes, String jelszo) {
        this.konyvtaros_id = konyvtaros_id;
        this.nev = nev;
        this.email = email;
        this.telefon = telefon;
        this.alkalmazas_eve = alkalmazas_eve;
        this.fizetes = fizetes;
        this.jelszo = jelszo;
    }

    public int getKonyvtaros_id() {
        return konyvtaros_id;
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

    public int getAlkalmazas_eve() {
        return alkalmazas_eve;
    }

    public int getFizetes() {
        return fizetes;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setKonyvtaros_id(int konyvtaros_id) {
        this.konyvtaros_id = konyvtaros_id;
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

    public void setAlkalmazas_eve(int alkalmazas_eve) {
        this.alkalmazas_eve = alkalmazas_eve;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
}
