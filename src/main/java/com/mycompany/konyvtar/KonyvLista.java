package com.mycompany.konyvtar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class KonyvLista implements java.io.Serializable {
    private ArrayList<Konyv> konyvek;
    
//     @Override
//    public Iterator<Konyv> iterator() {
//        return lista.iterator();
//    }
//    




    public KonyvLista() {
        this.konyvek = new ArrayList<>();
    }


    public void modositKolcsonozheto(int konyv_id, boolean ujKolcsonozheto) {
        Konyv konyv = getKonyvById(konyv_id);
        if (konyv != null) {
            konyv.setKolcsonozheto(ujKolcsonozheto);
            System.out.println("A(z) " + konyv_id + " azonosítójú könyv kölcsönözhetősége módosítva: " + ujKolcsonozheto);
        } else {
            System.out.println("Nem található ilyen ID-jű könyv: " + konyv_id);
        }
    }
    public int getLastID() {
        if (this.konyvek.isEmpty()) {
            return -1; // vagy dobhatunk egy kivételt
        }
        return this.konyvek.get(this.konyvek.size() - 1).getKonyv_id();
    }

    public void addKonyv(Konyv konyv) {
        konyvek.add(konyv);
    }

    public void torolKonyv(int konyv_id) {
        boolean removed = konyvek.removeIf(konyv -> konyv.getKonyv_id() == konyv_id);
        if (!removed) {
            System.out.println("Nem letezik ilyen konyv: " + konyv_id);
        }
    }
    public void updateKonyv(int konyv_id, String ujNev, String ujSzerzo, int ujEv, String ujISBN, String ujKiado, boolean ujKolcsonozheto) {
        boolean found = false;
        for (Konyv konyv : konyvek) {
            
            if (konyv.getKonyv_id() == konyv_id) {
                konyv.setKonyv_nev(ujNev);
                konyv.setSzerzo(ujSzerzo);
                konyv.setKiadasi_ev(ujEv);
                konyv.setISBN(ujISBN);
                konyv.setKiado(ujKiado);
                konyv.setKolcsonozheto(ujKolcsonozheto);
                found = true;
                break;
            }
           
        }
         if (!found) {
                System.out.println("Nem letezik ilyen konyv: " + konyv_id);
            }
    }
//    public void keresKonyv(String keresett) {
//        boolean found = false;
//        for (Konyv konyv : konyvek) {
//            if (konyv.getKonyv_nev().equalsIgnoreCase(keresett) || konyv.getSzerzo().equalsIgnoreCase(keresett)) {
//                System.out.println("Kereset konyv adatai: "+konyv.getKonyv_id() + ": " + konyv.getKonyv_nev() + ", " + konyv.getSzerzo() + ", " + konyv.getKiadasi_ev() + ", " + konyv.getISBN() + ", " + konyv.getKiado() + ", " + konyv.getKolcsonozheto());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("Nem talalhato konyv a megadott keresessel: " + keresett);
//        }
//    }
    public List<Konyv> keresKonyv(String keresett) {
        List<Konyv> talalatok = new ArrayList<>();
        for (Konyv konyv : konyvek) {
            if (konyv.getKonyv_nev().equalsIgnoreCase(keresett) || konyv.getSzerzo().equalsIgnoreCase(keresett)) {
                talalatok.add(konyv);
          }
        }
        return talalatok;
    }


    public List<Konyv> getKonyvek() {
        return new ArrayList<>(konyvek); // Másolatot ad vissza az adatok védelme érdekében
    }


    public void listazKonyvek() {
        for (Konyv konyv : konyvek) {
            System.out.println(konyv.getKonyv_id() + ": " + konyv.getKonyv_nev() + ", " + konyv.getSzerzo() + ", " + konyv.getKiadasi_ev() + ", " + konyv.getISBN() + ", " + konyv.getKiado() + ", " + konyv.getKolcsonozheto());
        }
    }

    public void mentesKonyvTxt(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Könyvlista sikeresen mentve: " + fileName);
        } catch (IOException e) {
            System.out.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }

    public static KonyvLista beolvasKonyvTxt(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (KonyvLista) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba történt a betöltés során: " + e.getMessage());
            return new KonyvLista();
        }
    }

    public void mentesKonyvXML(String fajlNev) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("KonyLista");
            doc.appendChild(rootElement);

            for (Konyv konyv : konyvek) {
                Element konyvElem = doc.createElement("Konyv");
                konyvElem.setAttribute("ID", String.valueOf(konyv.getKonyv_id()));
                rootElement.appendChild(konyvElem);

//                Element idElem = doc.createElement("ID");
//                idElem.appendChild(doc.createTextNode(String.valueOf(konyv.getKonyv_id())));
//                konyvElem.appendChild(idElem);

                Element nevElem = doc.createElement("Nev");
                nevElem.appendChild(doc.createTextNode(konyv.getKonyv_nev()));
                konyvElem.appendChild(nevElem);

                Element szerzoElem = doc.createElement("Szerzo");
                szerzoElem.appendChild(doc.createTextNode(konyv.getSzerzo()));
                konyvElem.appendChild(szerzoElem);

                Element evElem = doc.createElement("KiadasiEv");
                evElem.appendChild(doc.createTextNode(String.valueOf(konyv.getKiadasi_ev())));
                konyvElem.appendChild(evElem);

                Element isbnElem = doc.createElement("ISBN");
                isbnElem.appendChild(doc.createTextNode(konyv.getISBN()));
                konyvElem.appendChild(isbnElem);

                Element kiadoElem = doc.createElement("Kiado");
                kiadoElem.appendChild(doc.createTextNode(konyv.getKiado()));
                konyvElem.appendChild(kiadoElem);

                Element kolcsonozhetoElem = doc.createElement("Kolcsonozheto");
                kolcsonozhetoElem.appendChild(doc.createTextNode(String.valueOf(konyv.getKolcsonozheto())));
                konyvElem.appendChild(kolcsonozhetoElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fajlNev));

            transformer.transform(source, result);
            System.out.println("XML fájl sikeresen létrehozva: " + fajlNev);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Hiba történt az XML mentése során: " + e.getMessage());
        }
    }
//    public void beolvasXML(String fajlNev) {
//        try {
//            File xmlFile = new File(fajlNev);
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(xmlFile);
//            doc.getDocumentElement().normalize();
//
//            NodeList nodeList = doc.getElementsByTagName("Konyv");
//            konyvek.clear();
//
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element elem = (Element) node;
//                    int id = Integer.parseInt(elem.getElementsByTagName("ID").item(0).getTextContent());
//                    String nev = elem.getElementsByTagName("Nev").item(0).getTextContent();
//                    String szerzo = elem.getElementsByTagName("Szerzo").item(0).getTextContent();
//                    int ev = Integer.parseInt(elem.getElementsByTagName("KiadasiEv").item(0).getTextContent());
//                    String isbn = elem.getElementsByTagName("ISBN").item(0).getTextContent();
//                    String kiado = elem.getElementsByTagName("Kiado").item(0).getTextContent();
//                    boolean kolcsonozheto = Boolean.parseBoolean(elem.getElementsByTagName("Kolcsonozheto").item(0).getTextContent());
//
//                    konyvek.add(new Konyv(id, nev, szerzo, ev, isbn, kiado, kolcsonozheto));
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Hiba történt az XML beolvasása során: " + e.getMessage());
//        }
//
//    }

    public static KonyvLista beolvasKonyvXML(String fileName) {
        KonyvLista konyvek = new KonyvLista();
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Konyv");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    String konyvIDStr = elem.getAttribute("ID");
                    String nev = getElementTextContent(elem, "Nev");
                    String szerzo = getElementTextContent(elem, "Szerzo");
                    String evStr = getElementTextContent(elem, "KiadasiEv");
                    String isbn = getElementTextContent(elem, "ISBN");
                    String kiado = getElementTextContent(elem, "Kiado");
                    String kolcsonozhetoBol = getElementTextContent(elem, "Kolcsonozheto");

                    if(konyvIDStr != null && nev != null && szerzo != null && evStr != null && isbn != null && kiado != null && kolcsonozhetoBol != null) {
                        int konyvID = Integer.parseInt(konyvIDStr);
                        int ev = Integer.parseInt(evStr);
                        boolean kolcsonozheto = Boolean.parseBoolean(kolcsonozhetoBol);
                        Konyv konyv = new Konyv(konyvID, nev, szerzo, ev, isbn, kiado, kolcsonozheto);
                        konyvek.addKonyv(konyv);
                    } else {
                        System.out.println("Hiányzó adat a következő könyvnél, nem kerül hozzáadásra.");
                    }
                }
            }
            System.out.println("Könyvlista sikeresen beolvasva XML-ből: " + fileName);
        } catch (Exception e) {
            System.out.println("Hiba történt az XML beolvasása során: " + e.getMessage());
        }
        return konyvek;
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

    public void modositKonyvXML(String fajlNev, int id, String ujNev, String ujSzerzo, int ujEv, String ujISBN, String ujKiado, boolean ujKolcsonozheto) {
        try {
            File xmlFile = new File(fajlNev);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Konyv");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    int currentId = Integer.parseInt(elem.getAttribute("ID"));
                    if (currentId == id) {
                        elem.getElementsByTagName("Nev").item(0).setTextContent(ujNev);
                        elem.getElementsByTagName("Szerzo").item(0).setTextContent(ujSzerzo);
                        elem.getElementsByTagName("KiadasiEv").item(0).setTextContent(String.valueOf(ujEv));
                        elem.getElementsByTagName("ISBN").item(0).setTextContent(ujISBN);
                        elem.getElementsByTagName("Kiado").item(0).setTextContent(ujKiado);
                        elem.getElementsByTagName("Kolcsonozheto").item(0).setTextContent(String.valueOf(ujKolcsonozheto));
                        break;
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fajlNev));
            transformer.transform(source, result);

            System.out.println("Könyv módosítva az XML fájlban.");
        } catch (Exception e) {
            System.out.println("Hiba történt az XML módosítása során: " + e.getMessage());
        }
    }
    public Konyv getKonyvById(int konyv_id) {
        for (Konyv konyv : konyvek) {
            if (konyv.getKonyv_id() == konyv_id) {
                return konyv;
            }
        }
        return null; // Ha nincs ilyen ID-jű könyv
    }

}


