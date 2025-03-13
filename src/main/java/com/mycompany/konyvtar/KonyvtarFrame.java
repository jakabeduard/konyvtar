/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.konyvtar;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class KonyvtarFrame extends javax.swing.JFrame {
    
//    public static KonyvtarFrame instance;
    public KonyvtarFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        konyvek = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        felhasznalok = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        kolcsonok = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fajl = new javax.swing.JMenu();
        betoltesTxtbol = new javax.swing.JMenuItem();
        betoltesXMLbol = new javax.swing.JMenuItem();
        mentesTxtbe = new javax.swing.JMenuItem();
        mentesXMLbe = new javax.swing.JMenuItem();
        konyv = new javax.swing.JMenu();
        konyvHozzaadas = new javax.swing.JMenuItem();
        konyvTorles = new javax.swing.JMenuItem();
        konyvListaz = new javax.swing.JMenuItem();
        konyvModositas = new javax.swing.JMenuItem();
        konyvKereses = new javax.swing.JMenuItem();
        felhasznalo = new javax.swing.JMenu();
        felhasznaloHozzaadas = new javax.swing.JMenuItem();
        felhaszanloTorles = new javax.swing.JMenuItem();
        felhaszanloListaz = new javax.swing.JMenuItem();
        felhasznaloModositas = new javax.swing.JMenuItem();
        felhasznaloKereses = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cim", "Szerzo", "Kiadás", "ISBN", "Kiadó", "Kolcsonoyheto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        konyvek.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nev", "Email", "Telefonszam", "Jelszo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        felhasznalok.setViewportView(jTable2);

        fajl.setText("Fajl");

        betoltesTxtbol.setText("BetoltesTxtbol");
        betoltesTxtbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betoltesTxtbolActionPerformed(evt);
            }
        });
        fajl.add(betoltesTxtbol);

        betoltesXMLbol.setText("BetoltesXMLbol");
        betoltesXMLbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betoltesXMLbolActionPerformed(evt);
            }
        });
        fajl.add(betoltesXMLbol);

        mentesTxtbe.setText("MentesTxtbe");
        mentesTxtbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesTxtbeActionPerformed(evt);
            }
        });
        fajl.add(mentesTxtbe);

        mentesXMLbe.setText("MentesXMLbe");
        mentesXMLbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesXMLbeActionPerformed(evt);
            }
        });
        fajl.add(mentesXMLbe);

        jMenuBar1.add(fajl);

        konyv.setText("Konyv");
        konyv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvActionPerformed(evt);
            }
        });

        konyvHozzaadas.setText("Hozzaadas");
        konyvHozzaadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvHozzaadasActionPerformed(evt);
            }
        });
        konyv.add(konyvHozzaadas);

        konyvTorles.setText("Torles");
        konyvTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvTorlesActionPerformed(evt);
            }
        });
        konyv.add(konyvTorles);

        konyvListaz.setText("Listazas");
        konyvListaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvListazActionPerformed(evt);
            }
        });
        konyv.add(konyvListaz);

        konyvModositas.setText("Modositas");
        konyvModositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvModositasActionPerformed(evt);
            }
        });
        konyv.add(konyvModositas);

        konyvKereses.setText("Kereses");
        konyvKereses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konyvKeresesActionPerformed(evt);
            }
        });
        konyv.add(konyvKereses);

        jMenuBar1.add(konyv);

        felhasznalo.setText("Felhasznalo ");

        felhasznaloHozzaadas.setText("Hozzaadas");
        felhasznaloHozzaadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloHozzaadasActionPerformed(evt);
            }
        });
        felhasznalo.add(felhasznaloHozzaadas);

        felhaszanloTorles.setText("Torles");
        felhaszanloTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhaszanloTorlesActionPerformed(evt);
            }
        });
        felhasznalo.add(felhaszanloTorles);

        felhaszanloListaz.setText("Listazas");
        felhaszanloListaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhaszanloListazActionPerformed(evt);
            }
        });
        felhasznalo.add(felhaszanloListaz);

        felhasznaloModositas.setText("Modositas");
        felhasznaloModositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloModositasActionPerformed(evt);
            }
        });
        felhasznalo.add(felhasznaloModositas);

        felhasznaloKereses.setText("Kereses");
        felhasznaloKereses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloKeresesActionPerformed(evt);
            }
        });
        felhasznalo.add(felhasznaloKereses);

        jMenuBar1.add(felhasznalo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(konyvek, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(felhasznalok, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(kolcsonok)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(felhasznalok, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(konyvek, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addComponent(kolcsonok, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void betoltesTxtbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betoltesTxtbolActionPerformed
        // TODO add your handling code here:
        konyvLista2=KonyvLista.beolvasKonyvTxt("konyvLista.txt");
        konyvListaFrissitese();
        felhasznaloLista2=FelhasznaloLista.beolvasFelhasznaloTxt("felhasznaloLista.txt");
        felhasznaloListaFrissitese();
    }//GEN-LAST:event_betoltesTxtbolActionPerformed

    private void konyvHozzaadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvHozzaadasActionPerformed
         konyvHozzaadoDialogus dialog = new konyvHozzaadoDialogus(new javax.swing.JFrame(), true);
    dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    konyvListaFrissitese();
    }//GEN-LAST:event_konyvHozzaadasActionPerformed

    private void konyvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_konyvActionPerformed

    private void konyvModositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvModositasActionPerformed
        // TODO add your handling code here:
        konyvModositoDialogus dialog= new konyvModositoDialogus(new javax.swing.JFrame(), true);
    dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    konyvListaFrissitese();
    }//GEN-LAST:event_konyvModositasActionPerformed

    private void konyvTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvTorlesActionPerformed
        // TODO add your handling code here:
        konyvTorloDialogus dialog =new konyvTorloDialogus(new javax.swing.JFrame(), true);
           dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    }//GEN-LAST:event_konyvTorlesActionPerformed

    private void konyvKeresesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvKeresesActionPerformed
        // TODO add your handling code here:
        konyvKeresoDialogus dialog =new konyvKeresoDialogus(new javax.swing.JFrame(), true);
                  dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    }//GEN-LAST:event_konyvKeresesActionPerformed

    private void felhasznaloHozzaadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloHozzaadasActionPerformed
        // TODO add your handling code here
        felhasznaloHozzadoDialogus dialog =new felhasznaloHozzadoDialogus(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
        dialog.setVisible(true);
        felhasznaloListaFrissitese();
    }//GEN-LAST:event_felhasznaloHozzaadasActionPerformed

    private void felhaszanloTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhaszanloTorlesActionPerformed
        // TODO add your handling code here
       felhasznaloTorloDialogus dialog = new felhasznaloTorloDialogus(new javax.swing.JFrame(), true);
                  dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    }//GEN-LAST:event_felhaszanloTorlesActionPerformed

    private void felhasznaloModositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloModositasActionPerformed
        // TODO add your handling code here:
        felhasznaloModsoitoDialogus dialog = new felhasznaloModsoitoDialogus(new javax.swing.JFrame(), true);
                  dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    felhasznaloListaFrissitese();
    
    }//GEN-LAST:event_felhasznaloModositasActionPerformed

    private void felhasznaloKeresesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloKeresesActionPerformed
       felhasznaloKeresoDialogus dialog =new felhasznaloKeresoDialogus(new javax.swing.JFrame(), true);
                  dialog.setLocationRelativeTo(null); // Centers the dialog on the screen
    dialog.setVisible(true);
    }//GEN-LAST:event_felhasznaloKeresesActionPerformed

    private void betoltesXMLbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betoltesXMLbolActionPerformed
        konyvLista2=KonyvLista.beolvasKonyvXML("konyvekLista2.xml");
        konyvListaFrissitese();
        felhasznaloLista2=FelhasznaloLista.beolvasFelhasznaloXML("felhasznaloLista.xml");
        felhasznaloListaFrissitese();
    }//GEN-LAST:event_betoltesXMLbolActionPerformed

    private void mentesTxtbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesTxtbeActionPerformed
        konyvLista2.mentesKonyvTxt("konyvLista.txt");
        felhasznaloLista2.mentesFelhasznaloTxt("felhasznaloLista.txt");
        
    }//GEN-LAST:event_mentesTxtbeActionPerformed

    private void mentesXMLbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesXMLbeActionPerformed
        konyvLista2.mentesKonyvXML("konyvekLista2.xml");
        felhasznaloLista2.mentesFelhasznaloXML("felhasznaloLista.xml");
    }//GEN-LAST:event_mentesXMLbeActionPerformed

    private void konyvListazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konyvListazActionPerformed

        konyvListaFrissitese();
    }//GEN-LAST:event_konyvListazActionPerformed
    public void konyvListaFrissitese(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        for (int i = 0; i<konyvLista2.getKonyvek().size();i++){
            Konyv konyv = new Konyv();
            konyv = konyvLista2.getKonyvek().get(i);
            Object[] rowData = {
                    konyv.getKonyv_id(),
                    konyv.getKonyv_nev(),
                    konyv.getSzerzo(),
                    konyv.getKiadasi_ev(),
                    konyv.getISBN(),
                    konyv.getKiado(),
                    konyv.getKolcsonozheto()
            };
            model.addRow(rowData);
        } 
    }
    
    private void felhaszanloListazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhaszanloListazActionPerformed

        felhasznaloListaFrissitese();  
    }//GEN-LAST:event_felhaszanloListazActionPerformed
    public  void felhasznaloListaFrissitese(){
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.setRowCount(0); 
        for (int i = 0; i<felhasznaloLista2.getFelhasznalok().size();i++){
            Felhasznalo felhasznalo=new Felhasznalo();
            felhasznalo=felhasznaloLista2.getFelhasznalok().get(i);
            Object[] row2Data = {
                    felhasznalo.getFelhasznaloID(),
                    felhasznalo.getNev(),
                    felhasznalo.getEmail(),
                    felhasznalo.getTelefon(),
                    felhasznalo.getJelszo()
            };
            model2.addRow(row2Data);
        } 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KonyvtarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonyvtarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonyvtarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonyvtarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonyvtarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem betoltesTxtbol;
    private javax.swing.JMenuItem betoltesXMLbol;
    private javax.swing.JMenu fajl;
    private javax.swing.JMenuItem felhaszanloListaz;
    private javax.swing.JMenuItem felhaszanloTorles;
    private javax.swing.JMenu felhasznalo;
    private javax.swing.JMenuItem felhasznaloHozzaadas;
    private javax.swing.JMenuItem felhasznaloKereses;
    private javax.swing.JMenuItem felhasznaloModositas;
    private javax.swing.JScrollPane felhasznalok;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JScrollPane kolcsonok;
    private javax.swing.JMenu konyv;
    private javax.swing.JMenuItem konyvHozzaadas;
    private javax.swing.JMenuItem konyvKereses;
    private javax.swing.JMenuItem konyvListaz;
    private javax.swing.JMenuItem konyvModositas;
    private javax.swing.JMenuItem konyvTorles;
    private javax.swing.JScrollPane konyvek;
    private javax.swing.JMenuItem mentesTxtbe;
    private javax.swing.JMenuItem mentesXMLbe;
    // End of variables declaration//GEN-END:variables
public static DefaultTableModel model = new DefaultTableModel();
public static DefaultTableModel model2 = new DefaultTableModel();
public static KonyvLista konyvLista2 = new KonyvLista();
public static FelhasznaloLista  felhasznaloLista2 =new FelhasznaloLista();


}
