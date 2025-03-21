/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.konyvtar;

import com.mycompany.konyvtar.*;

public class felhasznaloHozzadoDialogus extends javax.swing.JDialog {

    public felhasznaloHozzadoDialogus(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        felhasznaloMentes = new javax.swing.JButton();
        felhasznaloNev = new javax.swing.JTextField();
        felhasznaloEmail = new javax.swing.JTextField();
        felhasznaloTel = new javax.swing.JTextField();
        felhasznaloJelszo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nev:");

        jLabel2.setText("Email:");

        jLabel3.setText("Telefon:");

        jLabel4.setText("Jelszo:");

        felhasznaloMentes.setText("Hozzaadas");
        felhasznaloMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloMentesActionPerformed(evt);
            }
        });

        felhasznaloNev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloNevActionPerformed(evt);
            }
        });

        felhasznaloEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloEmailActionPerformed(evt);
            }
        });

        felhasznaloTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloTelActionPerformed(evt);
            }
        });

        felhasznaloJelszo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                felhasznaloJelszoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(felhasznaloNev, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(felhasznaloEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(felhasznaloTel, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(felhasznaloJelszo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(felhasznaloMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(felhasznaloNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(felhasznaloEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(felhasznaloTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(felhasznaloJelszo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(felhasznaloMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void felhasznaloNevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloNevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_felhasznaloNevActionPerformed

    private void felhasznaloEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_felhasznaloEmailActionPerformed

    private void felhasznaloTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_felhasznaloTelActionPerformed

    private void felhasznaloJelszoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloJelszoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_felhasznaloJelszoActionPerformed

    private void felhasznaloMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_felhasznaloMentesActionPerformed

        Felhasznalo felhasznalo = new Felhasznalo();
        
        //int id=KonyvtarFrame.getLastID();
        int id=KonyvtarFrame.felhasznaloLista2.getLastID();
        id++;
        felhasznalo.setFelhasznaloID(id);
       
        
        String nev=felhasznaloNev.getText();
        felhasznalo.setNev(nev);
        
        String email=felhasznaloEmail.getText();
        felhasznalo.setEmail(email);

        String tel=felhasznaloTel.getText();
        felhasznalo.setTelefon(tel);
        

        String jelszo=felhasznaloJelszo.getText();
        felhasznalo.setJelszo(jelszo);
        
        KonyvtarFrame.felhasznaloLista2.addFelhasznalo(felhasznalo);
        dispose();

       
    }//GEN-LAST:event_felhasznaloMentesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                felhasznaloHozzadoDialogus dialog = new felhasznaloHozzadoDialogus(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField felhasznaloEmail;
    private javax.swing.JTextField felhasznaloJelszo;
    private javax.swing.JButton felhasznaloMentes;
    private javax.swing.JTextField felhasznaloNev;
    private javax.swing.JTextField felhasznaloTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
