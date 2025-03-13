package com.mycompany.konyvtar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FelhasznaloLista implements java.io.Serializable {

    private ArrayList<Felhasznalo> felhasznalok;

    public FelhasznaloLista() {
        this.felhasznalok = new ArrayList<>();
    }


    public void addFelhasznalo(Felhasznalo felhasznalo) {
        felhasznalok.add(felhasznalo);
    }

    public void torolFelhasznalo(int felhasznaloID) {
        boolean removed = felhasznalok.removeIf(felhasznalo -> felhasznalo.getFelhasznaloID() == felhasznaloID);
        if (!removed) {
            System.out.println("Nem létezik ilyen felhasználó: " + felhasznaloID);
        }
    }

    public void updateFelhasznalo(int felhasznaloID, String ujNev, String ujEmail, String ujTelefon, String ujJelszo) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            boolean found = false;
            if (felhasznalo.getFelhasznaloID() == felhasznaloID) {
                felhasznalo.setNev(ujNev);
                felhasznalo.setEmail(ujEmail);
                felhasznalo.setTelefon(ujTelefon);
                felhasznalo.setJelszo(ujJelszo);
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Nem létezik ilyen felhasználó: " + felhasznaloID);
            }
        }
    }
    public List<Felhasznalo> keresFelhasznalo(String keresett) {
        List<Felhasznalo> talalatok = new ArrayList<>();
        for (Felhasznalo felhasznalo : felhasznalok) {
         if (felhasznalo.getNev().equalsIgnoreCase(keresett) || felhasznalo.getEmail().equalsIgnoreCase(keresett)) {
             talalatok.add(felhasznalo);
          }
        }
        return talalatok;
    }

//    public void keresFelhasznalo(String keresett) {
//        boolean found = false;
//        for (Felhasznalo felhasznalo : felhasznalok) {
//            if (felhasznalo.getNev().equalsIgnoreCase(keresett) || felhasznalo.getEmail().equalsIgnoreCase(keresett)) {
//                System.out.println( felhasznalo.getFelhasznaloID() + ", " + felhasznalo.getNev() + ", " + felhasznalo.getEmail() + ", " + felhasznalo.getTelefon()+", " + felhasznalo.getJelszo());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Nem található felhasználó a megadott kereséssel: " + keresett);
//        }
//    }
    public int getLastID() {
        if (this.felhasznalok.isEmpty()) {
            return -1; // vagy dobhatunk egy kivételt
        }
        return this.felhasznalok.get(this.felhasznalok.size() - 1).getFelhasznaloID();
    }

    public List<Felhasznalo> getFelhasznalok(){
        return new ArrayList<>(felhasznalok);
    }

    public void listazFelhasznalok() {
        for (Felhasznalo felhasznalo : felhasznalok) {
            System.out.println(felhasznalo.getFelhasznaloID() + ": " + felhasznalo.getNev() + ", " + felhasznalo.getEmail() + ", " + felhasznalo.getTelefon()+" " + felhasznalo.getJelszo());
        }
    }
    public void mentesFelhasznaloTxt(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Felhasználói lista sikeresen mentve: " + fileName);
        } catch (IOException e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    public static FelhasznaloLista beolvasFelhasznaloTxt(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FelhasznaloLista) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba történt a betöltés során: " + e.getMessage());
            return new FelhasznaloLista();
        }
    }

    // XML mentése
    public void mentesFelhasznaloXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("Felhasznalok");
            doc.appendChild(root);

            for (Felhasznalo felhasznalo : felhasznalok) {
                Element felhasznaloElem = doc.createElement("Felhasznalo");
                felhasznaloElem.setAttribute("felhasznaloID",String.valueOf(felhasznalo.getFelhasznaloID()));
                root.appendChild(felhasznaloElem);

//                Element idElem = doc.createElement("FelhasznaloID");
//                idElem.appendChild(doc.createTextNode(String.valueOf(felhasznalo.getFelhasznaloID())));
//                felhasznaloElem.appendChild(idElem);

                Element nevElem = doc.createElement("Nev");
                nevElem.appendChild(doc.createTextNode(felhasznalo.getNev()));
                felhasznaloElem.appendChild(nevElem);

                Element emailElem = doc.createElement("Email");
                emailElem.appendChild(doc.createTextNode(felhasznalo.getEmail()));
                felhasznaloElem.appendChild(emailElem);

                Element telefonElem = doc.createElement("Telefon");
                telefonElem.appendChild(doc.createTextNode(felhasznalo.getTelefon()));
                felhasznaloElem.appendChild(telefonElem);

                Element jelszoElem = doc.createElement("Jelszo");
                jelszoElem.appendChild(doc.createTextNode(felhasznalo.getJelszo()));
                felhasznaloElem.appendChild(jelszoElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
            System.out.println("Felhasználói lista sikeresen mentve XML-be: " + fileName);
        } catch (Exception e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    // XML beolvasása
    public static FelhasznaloLista beolvasFelhasznaloXML(String fileName) {
        FelhasznaloLista lista = new FelhasznaloLista();
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Felhasznalo");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    String felhasznaloIDStr = elem.getAttribute("felhasznaloID"); // Kisbetűs attribútum név
                    String nev = getElementTextContent(elem, "Nev");
                    String email = getElementTextContent(elem, "Email");
                    String telefon = getElementTextContent(elem, "Telefon");
                    String jelszo = getElementTextContent(elem, "Jelszo");

                    if (felhasznaloIDStr != null && !felhasznaloIDStr.isEmpty() &&
                            nev != null && email != null && telefon != null && jelszo != null) {
                        int felhasznaloID = Integer.parseInt(felhasznaloIDStr);
                        Felhasznalo felhasznalo = new Felhasznalo(felhasznaloID, nev, email, telefon, jelszo);
                        lista.addFelhasznalo(felhasznalo);
                    } else {
                        System.out.println("Hiányzó adat a következő felhasználónál, nem kerül hozzáadásra: ");
                        System.out.println("Felhasználó " + i + " adatai: ID: " + felhasznaloIDStr + ", Név: " + nev);
                    }
                }
            }
            System.out.println("Felhasználói lista sikeresen beolvasva XML-ből: " + fileName);
        } catch (Exception e) {
            System.out.println("Hiba történt a betöltés során: " + e.getMessage());
        }
        return lista;
    }

    private static String getElementTextContent(Element elem, String tagName) {
        NodeList nodeList = elem.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null) {
                return node.getTextContent().trim();
            }
        }
        return null;
    }

    // Felhasználó módosítása XML fájlban
    public void modositFelhasznaloXML(int felhasznaloID, String ujNev, String ujEmail, String ujTelefon, String ujJelszo, String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Felhasznalo");
            boolean found = false;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    int id = Integer.parseInt(elem.getAttribute("felhasznaloID"));

                    if (id == felhasznaloID) {
                        elem.getElementsByTagName("Nev").item(0).setTextContent(ujNev);
                        elem.getElementsByTagName("Email").item(0).setTextContent(ujEmail);
                        elem.getElementsByTagName("Telefon").item(0).setTextContent(ujTelefon);
                        elem.getElementsByTagName("Jelszo").item(0).setTextContent(ujJelszo);
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(fileName));
                transformer.transform(source, result);
                System.out.println("Felhasználói adatok sikeresen módosítva XML fájlban.");
            } else {
                System.out.println("Nem található felhasználó a megadott ID-val.");
            }
        } catch (Exception e) {
            System.out.println("Hiba történt a módosítás során: " + e.getMessage());
        }
    }
    public void removeAllFelhasznalo() {
    felhasznalok.clear();
    System.out.println("Minden felhasználó törölve lett.");
}


}
