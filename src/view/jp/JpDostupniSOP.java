/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import model.Postavke;
import model.SOP;
import view.jf.JfOdabraniSOP;
import view.jf.JfPocetnaForma;

/**
 *
 * @author ahilis001
 */
public class JpDostupniSOP extends JPanel{

    public JpDostupniSOP() {
    }
    
    static public JpDostupniSOP generirajObrazac(){
        
        //inicijalizacija jpanela
        JpDostupniSOP jpDostupniSOP = new JpDostupniSOP();
        
        //postavljanje poravnanja, layouta i naslova jPanela
        jpDostupniSOP.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        
        jpDostupniSOP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dostupni SOP-ovi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        c.gridx = 0;
        c.gridy = 0;
        
        //todo dodati za kreiranje stupaca i redova iz postavki
        if (!SOP.getAlListaSvihSOP().isEmpty()) {
            for (SOP sop : SOP.getAlListaSvihSOP()) {
                JLabel jlNazivDatoteke = new JLabel(sop.getStrNaziv());
                
                //postavljanje "rukice"
                jlNazivDatoteke.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                //dodavanje funkcionalnosti "na klik", "enter"i "exit"
                jlNazivDatoteke.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        JfOdabraniSOP.generirajObrazac(sop);
                    }
                    
                    public void mouseEntered(MouseEvent e) {
                        
                        //on enter, promjena boje u plavo i podcrtano
                        Font font = jlNazivDatoteke.getFont();
                        Map attributes = font.getAttributes();
                        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                        jlNazivDatoteke.setFont(font.deriveFont(attributes));
                        jlNazivDatoteke.setForeground(Color.blue);
                    }
                    
                    public void mouseExited(MouseEvent e) {
                        
                        //on exit, promjena boje u crno i makivanje podcrtavanja
                        Font font = jlNazivDatoteke.getFont();
                        Map attributes = font.getAttributes();
                        attributes.put(TextAttribute.UNDERLINE, -1);
                        jlNazivDatoteke.setFont(font.deriveFont(attributes));
                        jlNazivDatoteke.setForeground(Color.black);
                    }
                });
                
                jpDostupniSOP.add(jlNazivDatoteke,c);
                
                JLabel jlDatotekaPDF = new JLabel(sop.getStrNazivPDFDatotekeSOPa());
                
                //dodavanje funkcionalnosti "na klik", "enter" i "exit"
                jlDatotekaPDF.addMouseListener(new MouseAdapter() {
                    
                    //otvaranje pdf datoteke
                    public void mouseClicked(MouseEvent e){
                        try {
                            Desktop.getDesktop().open(new File(Postavke.dajPostavku("putanjeDatoteka") + sop.getStrNazivMape() + "/" + sop.getStrNazivPDFDatotekeSOPa()));
                        } catch (Exception ex) {
                            JpObavijestiIPostavke.getJtaObavijesti().setText("Greška kod otvaranja datoteke.");
                        }
                    }
                    
                    public void mouseEntered(MouseEvent e) {
                        
                        //on enter, promjena boje u plavo i podcrtano
                        Font font = jlDatotekaPDF.getFont();
                        Map attributes = font.getAttributes();
                        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                        jlDatotekaPDF.setFont(font.deriveFont(attributes));
                        jlDatotekaPDF.setForeground(Color.blue);
                    }
                    
                    public void mouseExited(MouseEvent e) {
                        
                        //on exit, promjena boje u crno i makivanje podcrtavanja
                        Font font = jlDatotekaPDF.getFont();
                        Map attributes = font.getAttributes();
                        attributes.put(TextAttribute.UNDERLINE, -1);
                        jlDatotekaPDF.setFont(font.deriveFont(attributes));
                        jlDatotekaPDF.setForeground(Color.black);
                    }
                });
                
                c.gridx++;
                
                //postavljanje ikone za vrstu datoteke
                jpDostupniSOP.add(new JLabel(FileSystemView.getFileSystemView().getSystemIcon(new File(Postavke.dajPostavku("putanjeDatoteka") + sop.getStrNazivMape() + "/" + sop.getStrNazivPDFDatotekeSOPa()))), c);
                
                c.gridx++;
                
                //postavljanje "rukice"
                jlDatotekaPDF.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                jpDostupniSOP.add(jlDatotekaPDF,c);
                
                c.gridx = 0;
                c.gridy++;
                
            }
        }
        
        else {
            JfPocetnaForma.getJtObavijesti().setText("Nije učitana niti jedna datoteka.");
        }
        
        return jpDostupniSOP;
    }
    
}
