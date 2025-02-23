/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konyvtar;

/**
 *
 * @author Eduard
 */
public class Konyv implements java.io.Serializable {
    private int konyv_id;
    private String  konyv_nev;
    private String  szerzo;
    private int  kiadasi_ev;     
    private String  ISBN;  
    private String  kiado;        
    private Boolean  kolcsonozheto;    
           
            
  
    public void setKonyv_id(int konyv_id) {
        this.konyv_id = konyv_id;
    }

    public void setKonyv_nev(String konyv_nev) {
        this.konyv_nev = konyv_nev;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

 

    public void setKiadasi_ev(int kiadasi_ev) {
        this.kiadasi_ev = kiadasi_ev;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public void setKolcsonozheto(Boolean kolcsonozheto) {
        this.kolcsonozheto = kolcsonozheto;
    }

    public int getKonyv_id() {
        return konyv_id;
    }

    public String getKonyv_nev() {
        return konyv_nev;
    }

    public String getSzerzo() {
        return szerzo;
    }

  

    public int getKiadasi_ev() {
        return kiadasi_ev;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getKiado() {
        return kiado;
    }

    public Boolean getKolcsonozheto() {
        return kolcsonozheto;
    }

    public Konyv() {
    }

    public Konyv(int konyv_id, String konyv_nev , String szerzo,  int kiadasi_ev, String ISBN, String kiado, Boolean kolcsonozheto) {
        this.konyv_id = konyv_id;
        this.konyv_nev = konyv_nev;
        this.szerzo = szerzo;
       
        this.kiadasi_ev = kiadasi_ev;
        this.ISBN = ISBN;
        this.kiado = kiado;
        this.kolcsonozheto = kolcsonozheto;
    }
   
    
}
