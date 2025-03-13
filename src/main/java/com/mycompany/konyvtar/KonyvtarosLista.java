package com.mycompany.konyvtar;
import java.io.*;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class KonyvtarosLista implements java.io.Serializable {
    private ArrayList<Konyvtaros> konyvtarosok;

    public KonyvtarosLista() {
        this.konyvtarosok = new ArrayList<>();
    }

    public void addKonyvtaros(Konyvtaros konyvtaros) {
        konyvtarosok.add(konyvtaros);
    }

    public void torolKonyvtaros(int konyvtaros_id) {
        boolean removed = konyvtarosok.removeIf(konyvtaros -> konyvtaros.getKonyvtaros_id() == konyvtaros_id);
        if (!removed) {
            System.out.println("Nem létezik ilyen könyvtáros: " + konyvtaros_id);
        }
    }

    public void updateKonyvtaros(int konyvtaros_id, String ujNev, String ujEmail, String ujTelefon, int ujEv, int ujFizetes, String ujJelszo) {
        boolean found = false;
        for (Konyvtaros konyvtaros : konyvtarosok) {

            if (konyvtaros.getKonyvtaros_id() == konyvtaros_id) {
                konyvtaros.setNev(ujNev);
                konyvtaros.setEmail(ujEmail);
                konyvtaros.setTelefon(ujTelefon);
                konyvtaros.setAlkalmazas_eve(ujEv);
                konyvtaros.setFizetes(ujFizetes);
                konyvtaros.setJelszo(ujJelszo);
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("Nem létezik ilyen könyvtáros: " + konyvtaros_id);
        }
    }

    public void keresKonyvtaros(String keresett) {
        boolean found = false;
        for (Konyvtaros konyvtaros : konyvtarosok) {
            if (konyvtaros.getNev().equalsIgnoreCase(keresett) || konyvtaros.getEmail().equalsIgnoreCase(keresett)) {
                System.out.println("Keresett könyvtáros adatai: " + konyvtaros.getKonyvtaros_id() + ", " + konyvtaros.getNev() + ", " + konyvtaros.getEmail() + ", " + konyvtaros.getTelefon() + ", " + konyvtaros.getAlkalmazas_eve() + ", " + konyvtaros.getFizetes());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nem található könyvtáros a megadott kereséssel: " + keresett);
        }
    }

    public void listazKonyvtarosok() {
        for (Konyvtaros konyvtaros : konyvtarosok) {
            System.out.println(konyvtaros.getKonyvtaros_id() + ": " + konyvtaros.getNev() + ", " + konyvtaros.getEmail() + ", " + konyvtaros.getTelefon() + ", " + konyvtaros.getAlkalmazas_eve() + ", " + konyvtaros.getFizetes());
        }
    }
    public void mentesKonyvtarosTxt(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Könyvtaroslista sikeresen mentve: " + fileName);
        } catch (IOException e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    public static KonyvtarosLista beolvasKonyvtarosTxt(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (KonyvtarosLista) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba történt a betöltés során: " + e.getMessage());
            return new KonyvtarosLista();
        }
    }



    public void mentesKonyvtarosXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("Konyvtarosok");
            doc.appendChild(root);

            for (Konyvtaros konyvtaros : konyvtarosok) {
                Element konyvtarosElem = doc.createElement("Konyvtaros");
                konyvtarosElem.setAttribute("KonyvtarosID",String.valueOf(konyvtaros.getKonyvtaros_id()));
                root.appendChild(konyvtarosElem);

//                Element idElem = doc.createElement("KonyvtarosID");
//                idElem.appendChild(doc.createTextNode(String.valueOf(konyvtaros.getKonyvtaros_id())));
//                konyvtarosElem.appendChild(idElem);

                Element nevElem = doc.createElement("Nev");
                nevElem.appendChild(doc.createTextNode(konyvtaros.getNev()));
                konyvtarosElem.appendChild(nevElem);

                Element emailElem = doc.createElement("Email");
                emailElem.appendChild(doc.createTextNode(konyvtaros.getEmail()));
                konyvtarosElem.appendChild(emailElem);

                Element telefonElem = doc.createElement("Telefon");
                telefonElem.appendChild(doc.createTextNode(konyvtaros.getTelefon()));
                konyvtarosElem.appendChild(telefonElem);

                Element evElem = doc.createElement("AlkalmazasEve");
                evElem.appendChild(doc.createTextNode(String.valueOf(konyvtaros.getAlkalmazas_eve())));
                konyvtarosElem.appendChild(evElem);

                Element fizetesElem = doc.createElement("Fizetes");
                fizetesElem.appendChild(doc.createTextNode(String.valueOf(konyvtaros.getFizetes())));
                konyvtarosElem.appendChild(fizetesElem);

                Element jelszoElem = doc.createElement("Jelszo");
                jelszoElem.appendChild(doc.createTextNode(String.valueOf(konyvtaros.getJelszo())));
                konyvtarosElem.appendChild(jelszoElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
            System.out.println("Könyvtároslista sikeresen mentve XML-be: " + fileName);
        } catch (Exception e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    public static KonyvtarosLista beolvasKonyvtarosXML(String fileName) {
        KonyvtarosLista lista = new KonyvtarosLista();
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Konyvtaros");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    String konyvtarosIDStr = elem.getAttribute( "KonyvtarosID");
                    String nev = getElementTextContent(elem, "Nev");
                    String email = getElementTextContent(elem, "Email");
                    String telefon = getElementTextContent(elem, "Telefon");
                    String evStr = getElementTextContent(elem, "AlkalmazasEve");
                    String fizetesStr = getElementTextContent(elem, "Fizetes");
                    String jelszo = getElementTextContent(elem, "Jelszo");

                    if (konyvtarosIDStr != null && nev != null && email != null && telefon != null && evStr != null && fizetesStr != null) {
                        int konyvtarosID = Integer.parseInt(konyvtarosIDStr);
                        int ev = Integer.parseInt(evStr);
                        int fizetes = Integer.parseInt(fizetesStr);
                        Konyvtaros konyvtaros = new Konyvtaros(konyvtarosID, nev, email, telefon, ev, fizetes,jelszo);
                        lista.addKonyvtaros(konyvtaros);
                    } else {
                        System.out.println("Hiányzó adat a következő könyvtárosnál, nem kerül hozzáadásra.");
                        System.out.println("Könyvtáros " + i + " adatai: ID: " + konyvtarosIDStr + ", Név: " + nev);
                    }
                }
            }
            System.out.println("Könyvtároslista sikeresen beolvasva XML-ből: " + fileName);
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
                return node.getTextContent();
            }
        }
        return null;
    }
//    public void modositKonyvtarosXML(int konyvtaros_id, String ujNev, String ujEmail, String ujTelefon, int ujEv, int ujFizetes, String ujJelszo, String fileName) {
//        try {
//            // Load the XML file
//            File inputFile = new File(fileName);
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//
//            // Get all "Konyvtaros" elements
//            NodeList nodeList = doc.getElementsByTagName("Konyvtaros");
//            boolean found = false;
//
//            // Iterate over each Konyvtaros element and find the one with the given konyvtaros_id
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element elem = (Element) node;
//
//                    // Get the current Konyvtaros ID from the XML
//                    int id = Integer.parseInt(elem.getElementsByTagName("KonyvtarosID").item(0).getTextContent());
//
//                    // If this is the correct Konyvtaros, modify its details
//                    if (id == konyvtaros_id) {
//                        elem.getElementsByTagName("Nev").item(0).setTextContent(ujNev);
//                        elem.getElementsByTagName("Email").item(0).setTextContent(ujEmail);
//                        elem.getElementsByTagName("Telefon").item(0).setTextContent(ujTelefon);
//                        elem.getElementsByTagName("AlkalmazasEve").item(0).setTextContent(String.valueOf(ujEv));
//                        elem.getElementsByTagName("Fizetes").item(0).setTextContent(String.valueOf(ujFizetes));
//                        elem.getElementsByTagName("Jelszo").item(0).setTextContent(ujJelszo);
//                        found = true;
//                        break;
//                    }
//                }
//            }
//
//            // If the Konyvtaros is found, save the updated XML to the file
//            if (found) {
//                TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                Transformer transformer = transformerFactory.newTransformer();
//                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//                DOMSource source = new DOMSource(doc);
//                StreamResult result = new StreamResult(new File(fileName));
//                transformer.transform(source, result);
//                System.out.println("Felhasználói adatok sikeresen módosítva XML fájlban.");
//            } else {
//                System.out.println("Nem található könyvtáros a megadott ID-val.");
//            }
//        } catch (Exception e) {
//            System.out.println("Hiba történt a módosítás során: " + e.getMessage());
//        }
//    }
public void modositKonyvtarosXML(int konyvtaros_id, String ujNev, String ujEmail, String ujTelefon, int ujEv, int ujFizetes, String ujJelszo, String fileName) {
    try {
        // Load the XML file
        File inputFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();

        // Get all "Konyvtaros" elements
        NodeList nodeList = doc.getElementsByTagName("Konyvtaros");
        boolean found = false;

        // Iterate over each Konyvtaros element and find the one with the given KonyvtarosID attribute
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the current Konyvtaros ID from the XML (from the attribute)
                int id = Integer.parseInt(elem.getAttribute("KonyvtarosID"));

                // If this is the correct Konyvtaros, modify its details
                if (id == konyvtaros_id) {
                    elem.getElementsByTagName("Nev").item(0).setTextContent(ujNev);
                    elem.getElementsByTagName("Email").item(0).setTextContent(ujEmail);
                    elem.getElementsByTagName("Telefon").item(0).setTextContent(ujTelefon);
                    elem.getElementsByTagName("AlkalmazasEve").item(0).setTextContent(String.valueOf(ujEv));
                    elem.getElementsByTagName("Fizetes").item(0).setTextContent(String.valueOf(ujFizetes));
                    elem.getElementsByTagName("Jelszo").item(0).setTextContent(ujJelszo);
                    found = true;
                    break;
                }
            }
        }

        // If the Konyvtaros is found, save the updated XML to the file
        if (found) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
            System.out.println("Felhasználói adatok sikeresen módosítva XML fájlban.");
        } else {
            System.out.println("Nem található könyvtáros a megadott ID-val.");
        }
    } catch (Exception e) {
        System.out.println("Hiba történt a módosítás során: " + e.getMessage());
    }
}



}
