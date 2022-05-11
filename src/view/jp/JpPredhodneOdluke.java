/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Odluka;
import model.Putanja;
import model.SOP;
import view.jf.JfOdabraniSOP;

/**
 *
 * @author Ahilis
 */
public class JpPredhodneOdluke extends JPanel{

    public JpPredhodneOdluke() {
    }
    
    //todo sloziti da se prosljeduje index (string) pa da se odluka povuce (???)
    /**
     * Generira jpanel koji sadrži prve prethodne moguće odluke 
     * @param sop
     * @param odluka
     * @param jfOdabraniSOP
     * @return 
     */
    public JPanel generirajObrazac(SOP sop, Odluka odluka, JfOdabraniSOP jfOdabraniSOP){
        
        //inicijalizacija jPanela
        JpPredhodneOdluke jpPredhodnaOdluka = new JpPredhodneOdluke();
        
        //postavljanje naziva jPanela
        jpPredhodnaOdluka.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Moguće prethodne odluke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //postavljanje poravnanja i layouta jPanela
        jpPredhodnaOdluka.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
//        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;
        
        //ako prvi element liste nije prazan
        if (!odluka.getAlPrethodneOdlukeId().get(0).equals("")) {
            
            //za svaki stringID iz liste prethodnih odluka
            for (String strIdPrethodneOdluke : odluka.getAlPrethodneOdlukeId()) {
                
                //inicijalizacija jpanela i postavljanje rasporeda
                JPanel jpPomocniPanel = new JPanel(new GridBagLayout());
                
                //dodavanje jLabela s tekstom prijašnje odluke
                jpPredhodnaOdluka.add(new JLabel(("<html>" + sop.dajOdlukuPoID(strIdPrethodneOdluke).getStrTekstOdluke() + "</html>").replace("\\n", "<br>")), c);
                c.gridx++;
                
                //za svaku putanju iz liste putanje prethodne odluke
                for (Putanja putanja : sop.dajAlListaPrethodnihPutanjaZaOdluku(strIdPrethodneOdluke)) {
                    
                    //kreiranje gumba
                    JButton jbOdaberiOdluku = new JButton();
                    jbOdaberiOdluku.setText(putanja.getStrPutanjaOpis());
                    jbOdaberiOdluku.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            //dodavanje akcije za ažuriranje prikaza
                            jfOdabraniSOP.dispose();
                            JfOdabraniSOP.azurirajObrazac(sop, putanja.getStrPutanjaDo());
                        }
                    });
                    
                    //dodavanje gumba na jpPomocniPanel
                    jpPomocniPanel.add(jbOdaberiOdluku);
                }
                
                //kreiranje gumba za povratak na predhodnu odluku
                JButton jbOdaberiPrethodnuOdluku = new JButton();
                jbOdaberiPrethodnuOdluku.setText("Povratak");
                jbOdaberiPrethodnuOdluku.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //dodavanje akcije za ažuriranje prikaza
                        jfOdabraniSOP.dispose();
                        JfOdabraniSOP.azurirajObrazac(sop, strIdPrethodneOdluke);
                    }
                });
                
                //dodavanje gumba na jpPomocniPanel
                jpPomocniPanel.add(jbOdaberiPrethodnuOdluku);
                
                //dodavanje pomocnog panela na jpanel predhodnih odluka
                jpPredhodnaOdluka.add(jpPomocniPanel, c);
                
                c.gridx = 0;
                c.gridy++;
            }
            
        }
        
        //ako je prvi element liste ""
        else {            
            jpPredhodnaOdluka.add(new JLabel("<html>"
                                              +     "<font color=green>Početak postupanja.</font>"
                                              + "</html>"), c);
        } 
        
        return jpPredhodnaOdluka;
    }
    
}
