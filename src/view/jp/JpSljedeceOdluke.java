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
public class JpSljedeceOdluke extends JPanel{

    public JpSljedeceOdluke() {
    }
    
    /**
     * Generira jpanel koji sadrži moguće odluke
     * @param odluka
     * @param sop
     * @param jfOdabraniSOP
     * @return 
     */
    public JPanel generirajObrazac(SOP sop, Odluka odluka, JfOdabraniSOP jfOdabraniSOP){
        
        //inicijalizacija jpanela
        JpSljedeceOdluke jpSljedeceOdluke = new JpSljedeceOdluke();
        
        //postavljanje naslova jpanela
        jpSljedeceOdluke.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sljedeće odluke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //postavljanje poravnanja i layouta jFramea
        jpSljedeceOdluke.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;  
        
        //ako prvi element liste nije prazni
        if (!odluka.getAlSljedeceOdlukeId().get(0).equals("")) {
            
            //za svaki stringID iz liste sljedecih odluka
            for (Putanja putanja : sop.dajAlListaSljedecihPutanjaZaOdluku(odluka.getStrOdlukaId())) {
                
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
                
                jpSljedeceOdluke.add(jbOdaberiOdluku);
            }
        } 
        
        //todo mozda promijeniti poruku
        //ako je prvi element ""
        else {
            c.gridx = 0;
            c.gridy = 0;
            jpSljedeceOdluke.add(new JLabel("<html>"
//                                              + "<font color=green>Pustiti.</font><br> "
                                              + "<font color=red>Kraj postupanja.</font> "
                                          + "</html>"), c);
            
            //kreiranje gumba za povratak na početak SOP-a
            JButton jbPovratakNaPočetak = new JButton();
            jbPovratakNaPočetak.setText("Povratak na početak");
            jbPovratakNaPočetak.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //dodavanje akcije za ažuriranje prikaza
                    jfOdabraniSOP.dispose();
                    JfOdabraniSOP.generirajObrazac(sop);
                }
            });
            
            c.gridx = 0;
            c.gridy = 1;
            jpSljedeceOdluke.add(jbPovratakNaPočetak, c);
        } 
        
        return jpSljedeceOdluke;
    }
}
