/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import model.Postavke;

/**
 *
 * @author Ahilis
 */
public class MetodeMisc {
    
    /**
     * postavlja izgled jFramea s gumbovima (_, |=|, X)
     * @param jFrame 
     */
    public static void postaviIzgledPocetnogJf(JFrame jFrame){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                postaviLokaciju(jFrame);
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.revalidate();
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }
    
    /**
     * postavlja izgled jFramea s gumbovima (_, |=|, X)
     * @param jFrame 
     */
    public static void postaviIzgledOstalihJf(JFrame jFrame){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                postaviLokaciju(jFrame);
//                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.revalidate();
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }
    
    /**
     * postavlja izgled jFramea bez bumbova (_, |=|, X)
     * @param jFrame 
     */
    public static void postaviIzgledUndecorated(JFrame jFrame){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                postaviLokaciju(jFrame);
                jFrame.setUndecorated(true);
                jFrame.setVisible(true);
            }
        });
    }
    
    public static void postaviLokaciju(JFrame jFrame){
        jFrame.setLocation(Integer.parseInt(Postavke.dajPostavku("koordinateAplikacijeX")), Integer.parseInt(Postavke.dajPostavku("koordinateAplikacijeY")));
    }
    
    /**
     * Čita sadržaj datoteke s putanje.
     * @param putanja
     * @return 
     */
    static public StringBuilder citanjeIzDatoteke(String putanja){
        
        try {
            //čitanje iz datoteke
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(putanja),"UTF-8"));
            StringBuilder builder = new StringBuilder();
            String line = null;

            while ( (line = br.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
            }
            
            return builder;
        } 
        
        catch (Exception e) {
            System.out.println("greska kod citanja datoteke: " + putanja);
        }
        return null;
    }
    
}
