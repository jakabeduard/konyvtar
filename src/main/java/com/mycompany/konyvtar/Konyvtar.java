/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.konyvtar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Eduard
 */
public class Konyvtar {

    public static void main(String[] args) {


        System.out.println("1.Konyvek ");
        Konyv konyv1= new Konyv();
        Konyv konyv2= new Konyv(2, "Az arany ember", "Jokai Mor", 1836, "1223-324-3424", "Kiado", true);
        Konyv konyv7= new Konyv(7, "Az aradfsny ember", "Jokai Mor", 1836, "1223-324-3424", "Kiado", true);
        Konyv konyv3 = new Konyv(3, "Egri csillagok", "Gárdonyi Géza", 1899, "3456-789-1234", "Mora", true);
        konyv1.setKonyv_id(1);
        konyv1.setKiadasi_ev(1836);
        konyv1.setKonyv_nev("Egy magyar nabob");
        konyv1.setSzerzo("Jokai Mor");
        konyv1.setKiado("Kiadocska");
        konyv1.setKolcsonozheto(true);
        konyv1.setISBN("23423-434-3-534-4");
//        System.out.println(konyv1.getKonyv_id()+": "+konyv1.getKonyv_nev()+", "+konyv1.getSzerzo()+", "+konyv1.getKiadasi_ev()+", "+konyv1.getISBN()+", "+konyv1.getKiado()+", "+konyv1.getKolcsonozheto());
//        System.out.println(konyv2.getKonyv_id()+": "+konyv2.getKonyv_nev()+", "+konyv2.getSzerzo()+", "+konyv2.getKiadasi_ev()+", "+konyv2.getISBN()+", "+konyv2.getKiado()+", "+konyv2.getKolcsonozheto());


        KonyvLista konyvLista = new KonyvLista();
        konyvLista.addKonyv(konyv1);
        konyvLista.addKonyv(konyv2);
        konyvLista.addKonyv(konyv3);
//
//        for (Konyv k : konyvLista.getKonyvek()) {
//            konyvLista.addKonyv(k);
//        }
//        konyvLista.listazKonyvek();
//        konyvLista.addKonyv(konyv7);
//        konyvLista.listazKonyvek();
//        konyvLista.keresKonyv("Jokai Mor");
//
//
//        konyvLista.listazKonyvek();
//        konyvLista.torolKonyv(2);
        konyvLista.listazKonyvek();
//
        konyvLista.updateKonyv(1, "Janos","Petofi Sandor", 1990,"22342-43--3423","KonyvKiad",true );
//        konyvLista.torolKonyv(45);
        konyvLista.listazKonyvek();
//        konyvLista.keresKonyv("Janos");
//        konyvLista.keresKonyv("Az arany ember");
//        konyvLista.mentesTxt("konyvekLista.txt");
//        konyvLista=KonyvLista.beolvasKonyvTxt("konyvekLista.txt");
//        System.out.println("ezek a beolvasott konyvek ");
//        konyvLista.listazKonyvek();
//        konyvLista.mentesXML("konyvLista.xml");
//        konyvLista.listazKonyvek();
//
//        konyvLista.listazKonyvek();
//        konyvLista.modositXML("konyvLista.xml",1, "Julia","Laszlo Laszlo", 1989, "312434-42342-434","Locitrom", true);
//        konyvLista=KonyvLista.beolvasXML("konyvLista.xml");
//        konyvLista.listazKonyvek();


        System.out.println("2.Felhasznalok ");


//        Felhasznalo felhasznalo1 = new Felhasznalo();
//        Felhasznalo felhasznalo2 = new Felhasznalo(2, "Kovacs Janos", "kovacs@gmail.com", "+40720786678", "dk57576fja");
//        felhasznalo1.setFelhasznaloID(1);
//        felhasznalo1.setNev("Denes Alpar");
//        felhasznalo1.setEmail("denes@hotmail.com");
//        felhasznalo1.setTelefon("+40730567845");
//        felhasznalo1.setJelszo("hdfksdjhf");
//        System.out.println(felhasznalo1.getFelhasznaloID()+" "+felhasznalo1.getNev()+" "+felhasznalo1.getEmail()+" "+felhasznalo1.getTelefon()+" "+felhasznalo1.getJelszo());
//        System.out.println(felhasznalo2.getFelhasznaloID()+" "+felhasznalo2.getNev()+" "+felhasznalo2.getEmail()+" "+felhasznalo2.getTelefon()+" "+felhasznalo2.getJelszo());

//        FelhasznaloLista felhasznaloLista = new FelhasznaloLista();
//        felhasznaloLista.addFelhasznalo(felhasznalo1);
//        felhasznaloLista.addFelhasznalo(felhasznalo2);
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.updateFelhasznalo(1, "kovacs Andras ", "jakab@gmad.com", "079324923","887839e");
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.keresFelhasznalo("kovacs@gmail.com");
//        felhasznaloLista.torolFelhasznalo(1);
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.mentesTxt("felhasznaloLista.txt");
//
//        felhasznaloLista = FelhasznaloLista.beolvasTxt("felhasznaloLista.txt");
//        System.out.println("felhasznalok  beolvasas utan ");
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.mentsXML("felhasznaloLista.xml");
//        felhasznaloLista=FelhasznaloLista.beolvasXML("felhasznaloLista.xml");
//        felhasznaloLista.listazFelhasznalok();
//        felhasznaloLista.modositXML(1,"Denes Albert","albert@jflsd.com","0734675467","hdkfjah","felhasznaloLista.xml");
//        felhasznaloLista=FelhasznaloLista.beolvasXML("felhasznaloLista.xml");
//        felhasznaloLista.listazFelhasznalok();
        System.out.println("3.Konyvtarosok ");

//        Konyvtaros konyvtaros1 = new Konyvtaros();
//        Konyvtaros konyvtaros2 = new Konyvtaros(2, "Janos Albert", "kov@gmail.com", "+40720786678", 2022 ,4000, "dk57576fja");
//        konyvtaros1.setKonyvtaros_id(1);
//        konyvtaros1.setNev("Alpar Almos");
//        konyvtaros1.setEmail("almos@gmail.com");
//        konyvtaros1.setTelefon("+40730567845");
//        konyvtaros1.setAlkalmazas_eve(2023);
//        konyvtaros1.setFizetes(5000);
//        konyvtaros1.setJelszo("hdfdf87d066a");
//        System.out.println(konyvtaros1.getKonyvtaros_id()+" "+konyvtaros1.getNev()+" "+konyvtaros1.getEmail()+" "+konyvtaros1.getTelefon()+" "+konyvtaros1.getAlkalmazas_eve()+" "+konyvtaros1.getFizetes()+" "+konyvtaros1.getJelszo());
//        System.out.println(konyvtaros2.getKonyvtaros_id()+" "+konyvtaros2.getNev()+" "+konyvtaros2.getEmail()+" "+konyvtaros2.getTelefon()+" "+konyvtaros2.getAlkalmazas_eve()+" "+konyvtaros2.getFizetes()+" "+konyvtaros2.getJelszo());
        KonyvtarosLista konyvtarosLista = new KonyvtarosLista();
//        konyvtarosLista.addKonyvtaros(konyvtaros1);
//        konyvtarosLista.addKonyvtaros(konyvtaros2);
//        konyvtarosLista.listazKonyvtarosok();
//        konyvtarosLista.updateKonyvtaros(1, "Bohoc Albert", "bohoc@gmail.com", "+40720786678", 2022 ,4000, "dk57576fja");
//        konyvtarosLista.listazKonyvtarosok();
//        konyvtarosLista.keresKonyvtaros("Janos Albert");
//        konyvtarosLista.listazKonyvtarosok();
//        konyvtarosLista.mentTxt("konyvtarosLista.txt");
//        konyvtarosLista=KonyvtarosLista.beolvasTxt("konyvtarosLista.txt");
//        System.out.println("beolvasas utan ");
//        konyvtarosLista.listazKonyvtarosok();
//        konyvtarosLista.mentsXML("konyvtarosLista.xml");
//        konyvtarosLista=KonyvtarosLista.beolvasXML("konyvtarosLista.xml");
//        konyvtarosLista.listazKonyvtarosok();
//        konyvtarosLista.modositKonyvtarosXML(2,"Alma Ferencz","alma@fjlas.com","0745893476",2023,3000,"fjaskdfj","konyvtarosLista.xml");
//
//        konyvtarosLista=KonyvtarosLista.beolvasXML("konyvtarosLista.xml");
//        konyvtarosLista.listazKonyvtarosok();

    }
}
