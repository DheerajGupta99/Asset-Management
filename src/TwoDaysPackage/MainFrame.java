/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoDayspackage;

import static TwoDayspackage.Chain.usernames;
import static TwoDayspackage.Chain.passwords;
import static TwoDayspackage.Chain.wallets;
import static TwoDayspackage.Chain.blockchain;
import static TwoDayspackage.Chain.zkpids;
import java.util.*;
import java.io.*;
/**
 *
 *
 * @author me
 */
public class MainFrame extends javax.swing.JFrame implements AllFrames {

    /**
     * Creates new form MainFrame
     */
    public MainFrame(){
        initComponents();System.gc();
        System.out.println("Calling chain.main from main frame");
        Chain.Main();
        try{
            FileInputStream fis0 = new FileInputStream("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\BlockChain.txt");
            ObjectInputStream ois0 = new ObjectInputStream(fis0);
            if(new File("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\BlockChain.txt").length() != 0){
                blockchain = (ArrayList<Block>)ois0.readObject();
                System.out.println("After Deserialisation blockchain is: " + blockchain);
            }

            FileInputStream fis1 = new FileInputStream("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Usernames.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            if(new File("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Usernames.txt").length() != 0){
                usernames = (List<String>)ois1.readObject();
                System.out.println("After Deserialisation usernames is: " + usernames);
            }

            FileInputStream fis2 = new FileInputStream("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Passwords.txt");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            if(new File("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Passwords.txt").length() != 0){
                passwords = (List<String>)ois2.readObject();
                System.out.println("After Deserialisation passwords is: " + passwords);
            }

            FileInputStream fis3 = new FileInputStream("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Wallets.txt");
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            if(new File("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\Wallets.txt").length() != 0){
                wallets = (ArrayList<Wallet>)ois3.readObject();
                System.out.println("After Deserialisation wallets is: " + wallets);
            }

            FileInputStream fis4 = new FileInputStream("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\ZKPids.txt");
            ObjectInputStream ois4 = new ObjectInputStream(fis4);
            if(new File("D:\\4-2\\CRYPTO\\Assts\\2\\AssetManagement\\ZKPids.txt").length() != 0){
                zkpids = (List<Integer>)ois4.readObject();
                System.out.println("After Deserialisation zkpids is: " + zkpids);
            }

            fis0.close();
            fis1.close();
            fis2.close();
            fis3.close();
            fis4.close();

            ois0.close();
            ois1.close();
            ois2.close();
            ois3.close();
            ois4.close();


        }catch(Exception e){
            System.out.println("Here: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("REGISTER");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASSET MANAGEMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        lf.setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        rf.setVisible(true);
    }//GEN-LAST:event_registerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
