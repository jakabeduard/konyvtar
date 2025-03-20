package com.mycompany.konyvtar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.List;

public class KolcsonLista  implements java.io.Serializable{
    private ArrayList<Kolcson> kolcsonok;

    public KolcsonLista() {}

    public KolcsonLista(ArrayList<Kolcson> kolcsonLista) {
        this.kolcsonok = kolcsonLista;
    }
    public List<Kolcson> getKolcsonLista() {
        return new ArrayList<>(kolcsonok);
    }

    public void setKolcsonLista(ArrayList<Kolcson> kolcsonLista) {
        this.kolcsonok = kolcsonLista;
    }
    public void addKolcson(Kolcson kolcson) {
        if (kolcsonok == null) {
            kolcsonok = new ArrayList<>();
        }
        kolcsonok.add(kolcson);
    }
    public void listazKolcson() {
        for (Kolcson kolcson : kolcsonok) {
            System.out.println( kolcson.getKonyv().getKonyv_id()+ " " + kolcson.getKonyv().getKonyv_nev() + " -> "+ kolcson.getFelhasznalo().getFelhasznaloID() +" "+ kolcson.getFelhasznalo().getNev()+" "+ kolcson.getKolcsondatum()+" "+ kolcson.getHatarido());
        }
    }

    public void mentesKolcsonTxt(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Kölcsönlista sikeresen mentve: " + fileName);
        } catch (IOException e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    public static KolcsonLista beolvasKolcsonTxt(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (KolcsonLista) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba történt a betöltés során: " + e.getMessage());
            return new KolcsonLista();
        }
    }

    public void mentesKolcsonXML(String fajlNev) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("KolcsonLista");
            doc.appendChild(rootElement);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (Kolcson kolcson : kolcsonok) {
                Element kolcsonElem = doc.createElement("Kolcson");
                kolcsonElem.setAttribute("kolcsonID", String.valueOf(kolcson.getId()));
                rootElement.appendChild(kolcsonElem);

                Element konyvIdElem = doc.createElement("KonyvID");
                konyvIdElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getKonyv().getKonyv_id())));
                kolcsonElem.appendChild(konyvIdElem);

                Element konyvNevElem = doc.createElement("KonyvCim");
                konyvNevElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getKonyv().getKonyv_nev())));
                kolcsonElem.appendChild(konyvNevElem);

                Element konyvSzerzoElem = doc.createElement("Szerzo");
                konyvSzerzoElem.appendChild(doc.createTextNode(kolcson.getKonyv().getSzerzo()));
                kolcsonElem.appendChild(konyvSzerzoElem);

                Element evElem = doc.createElement("KiadasiEv");
                evElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getKonyv().getKiadasi_ev())));
                kolcsonElem.appendChild(evElem);

                Element isbnElem = doc.createElement("ISBN");
                isbnElem.appendChild(doc.createTextNode(kolcson.getKonyv().getISBN()));
                kolcsonElem.appendChild(isbnElem);

                Element kiadoElem = doc.createElement("Kiado");
                kiadoElem.appendChild(doc.createTextNode(kolcson.getKonyv().getKiado()));
                kolcsonElem.appendChild(kiadoElem);

                Element kolcsonozhetoElem = doc.createElement("Kolcsonozheto");
                kolcsonozhetoElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getKonyv().getKolcsonozheto())));
                kolcsonElem.appendChild(kolcsonozhetoElem);




                Element felhasznaloIdElem = doc.createElement("FelhasznaloID");
                felhasznaloIdElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getFelhasznalo().getFelhasznaloID())));
                kolcsonElem.appendChild(felhasznaloIdElem);

                Element felhasznaloNevElem = doc.createElement("FelhasznaloNev");
                felhasznaloNevElem.appendChild(doc.createTextNode(String.valueOf(kolcson.getFelhasznalo().getNev())));
                kolcsonElem.appendChild(felhasznaloNevElem);

                Element emailElem = doc.createElement("Email");
                emailElem.appendChild(doc.createTextNode(kolcson.getFelhasznalo().getEmail()));
                kolcsonElem.appendChild(emailElem);

                Element telefonElem = doc.createElement("Telefon");
                telefonElem.appendChild(doc.createTextNode(kolcson.getFelhasznalo().getTelefon()));
                kolcsonElem.appendChild(telefonElem);

                Element jelszoElem = doc.createElement("Jelszo");
                jelszoElem.appendChild(doc.createTextNode(kolcson.getFelhasznalo().getJelszo()));
                kolcsonElem.appendChild(jelszoElem);



                Element datumElem = doc.createElement("KolcsonDatum");
                datumElem.appendChild(doc.createTextNode(dateFormat.format(kolcson.getKolcsondatum())));
                kolcsonElem.appendChild(datumElem);

                Element hataridoElem = doc.createElement("Hatarido");
                hataridoElem.appendChild(doc.createTextNode(dateFormat.format(kolcson.getHatarido())));
                kolcsonElem.appendChild(hataridoElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fajlNev));
            transformer.transform(source, result);

            System.out.println("XML fájl sikeresen létrehozva: " + fajlNev);
        } catch (Exception e) {
            System.out.println("Hiba történt az XML mentése során: " + e.getMessage());
        }
    }


    public static KolcsonLista beolvasKolcsonXML(String fileName) {
        KolcsonLista kolcsonok = new KolcsonLista();
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Kolcson");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    int kolcsonID = Integer.parseInt(elem.getAttribute("kolcsonID"));
                    int konyvID = Integer.parseInt(getElementTextContent(elem, "KonyvID"));
                    String konyvCim = getElementTextContent(elem, "KonyvCim");
                    String szerzo = getElementTextContent(elem, "Szerzo");
                    int kiadasiEv = Integer.parseInt(getElementTextContent(elem, "KiadasiEv"));
                    String isbn = getElementTextContent(elem, "ISBN");
                    String kiado = getElementTextContent(elem, "Kiado");
                    boolean kolcsonozheto = Boolean.parseBoolean(getElementTextContent(elem, "Kolcsonozheto"));

                    // Felhasználó adatok
                    int felhasznaloID = Integer.parseInt(getElementTextContent(elem, "FelhasznaloID"));
                    String felhasznaloNev = getElementTextContent(elem, "FelhasznaloNev");
                    String email = getElementTextContent(elem, "Email");
                    String telefon = getElementTextContent(elem, "Telefon");
                    String jelszo = getElementTextContent(elem, "Jelszo");

                    // Dátumok átalakítása
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date kolcsonDatum = sdf.parse(getElementTextContent(elem, "KolcsonDatum"));
                    Date hatarido = sdf.parse(getElementTextContent(elem, "Hatarido"));

                    // Példányok létrehozása
                    Konyv konyv = new Konyv(konyvID, konyvCim, szerzo, kiadasiEv, isbn, kiado, kolcsonozheto);
                    Felhasznalo felhasznalo = new Felhasznalo(felhasznaloID, felhasznaloNev, email, telefon,jelszo);
                    Kolcson kolcson = new Kolcson(kolcsonID, konyv, felhasznalo, kolcsonDatum, hatarido);

                    kolcsonok.addKolcson(kolcson);
                }
            }
            System.out.println("Kölcsönlista sikeresen beolvasva XML-ből: " + fileName);
        } catch (Exception e) {
            System.out.println("Hiba történt az XML beolvasása során: " + e.getMessage());
        }
        return kolcsonok;
    }

    // Segédfüggvény az XML elemek szöveges tartalmának lekérdezésére
    private static String getElementTextContent(Element elem, String tagName) {
        NodeList nodeList = elem.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent().trim();
        }
        return ""; // Üres értékkel tér vissza, ha az elem hiányzik
    }
}
