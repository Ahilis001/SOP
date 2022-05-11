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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import model.Odluka;
import model.Postavke;
import model.SOP;

/**
 *
 * @author Ahilis
 */
public class JpTrenutnaOdluka extends JPanel{

    public JpTrenutnaOdluka() {
    }
    
    public JPanel generirajObrazac(SOP sop, Odluka odluka){
    
        //inicijalizacija jpanela
        JpTrenutnaOdluka jpTrenutnaOdluka = new JpTrenutnaOdluka();
        
        //postavljanje naziva jpanela
        jpTrenutnaOdluka.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trenutna odluka", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //postavljanje poravnanja i layouta jFramea
        jpTrenutnaOdluka.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;  
        
        //dodavanje opisa preko jlabela na jpanel
        jpTrenutnaOdluka.add(new JLabel(("<html>" + odluka.getStrTekstOdluke() + "</html>").replace("\\n", "<br>")), c);
        
        //ako postoji datoteka za prikazati
        if (!odluka.getAlDatoteke().get(0).equals("")) {
            
            c.gridy = 1;  
            jpTrenutnaOdluka.add(new JLabel(" "), c);
            
            //postavljanje poravnanja i layouta jpanela
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.EAST;
            gbc.fill = GridBagConstraints.BOTH;
            
            //jpanel za datoteke
            JPanel jpDatoteke = new JPanel(new GridBagLayout());
            jpDatoteke.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dostupne datoteke - primjeri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
            //za svaku datoteku se kreira jpanel za peikaz
            for (String strPutanjaDatoteke : odluka.getAlDatoteke()) {
                
                //jpanel za prikaz jedne datoteke
                JPanel jpPrikazDatoteke = new JPanel();
                
                //jpanel za prikaz ikone i imena
                JPanel jpPrikazIkoneIImena = new JPanel();
                jpPrikazDatoteke.setLayout(new GridBagLayout());
                
                // dodavanje ikone datoteke
                jpPrikazIkoneIImena.add(new JLabel(FileSystemView.getFileSystemView().getSystemIcon(new File(Postavke.dajPostavku("putanjeDatoteka") + sop.getStrNazivMape() + "/" + strPutanjaDatoteke))));
                
                //dodavanje naziva datoteke
                JLabel jlNazivDatoteke = new JLabel(strPutanjaDatoteke);
                        
                //postavljanje "rukice"
                jpPrikazDatoteke.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                //dodavanje funkcionalnosti "na klik", "enter"i "exit"
                jpPrikazDatoteke.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        try {
                            Desktop.getDesktop().open(new File(Postavke.dajPostavku("putanjeDatoteka") + sop.getStrNazivMape() + "/" + strPutanjaDatoteke));
                        } catch (Exception ex) {
                            JpObavijestiIPostavke.getJtaObavijesti().setText("Greška kod otvaranja datoteke.");
                        }
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
                
                //dodavanje jlabela s nazivom datoteke
                jpPrikazIkoneIImena.add(jlNazivDatoteke);
                
                //kreirane skalirane slike previewa
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(Postavke.dajPostavku("putanjeDatoteka") + sop.getStrNazivMape() + "/" + strPutanjaDatoteke).getImage().getScaledInstance(150, -1, Image.SCALE_DEFAULT));
                JLabel jlPreview = new JLabel(imageIcon);
                
                //dodavanje ikone, naziva i prewieva
                gbc.gridx = 0;
                gbc.gridy = 0; 
                jpPrikazDatoteke.add(jpPrikazIkoneIImena, gbc);
                
                gbc.gridy = 1;
                jpPrikazDatoteke.add(jlPreview, gbc);
                
                //dodavanja prikaza jedne datoteke 
                //na jpanel za prikaz svih datoteka
                jpDatoteke.add(jpPrikazDatoteke, c);
                
                c.gridx++;
                c.ipadx = 10;
            }
            
        //dodavanje jpanela s datotekama na jpanel s odlukom
        c.gridx = 0;
        c.gridy = 2;
        
        jpTrenutnaOdluka.add(jpDatoteke, c);
        
        }
        
        return jpTrenutnaOdluka;
    }
}
