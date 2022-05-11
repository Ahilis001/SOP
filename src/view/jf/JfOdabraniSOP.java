/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jf;

import controler.MetodeMisc;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.SOP;
import view.jp.JpSljedeceOdluke;
import view.jp.JpPredhodneOdluke;
import view.jp.JpTrenutnaOdluka;

/**
 *
 * @author Ahilis
 */
public class JfOdabraniSOP extends JFrame{
    
    /**
     * generiranje jf za prvu odluku
     * @param sop 
     */
    public static void generirajObrazac(SOP sop){
        
        //inicijalizacija novog JfOdabraniSOP
        JfOdabraniSOP jfOdabraniSOP = new JfOdabraniSOP();
        
        //postavljanje poravnanja i layouta jFramea
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        //glavni panel
        JPanel jpGlavniPanel = new JPanel(new GridBagLayout());
        jpGlavniPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, sop.getStrNaziv(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //dodavanje novog JpPredhodneOdluke u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 0;
        jpGlavniPanel.add(new JpPredhodneOdluke().generirajObrazac(sop, sop.getAlListaSvihOdluka().get(0), jfOdabraniSOP), c);
        
        //dodavanje novog JpTrenutnaOdluka u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 1;
        jpGlavniPanel.add(new JpTrenutnaOdluka().generirajObrazac(sop, sop.getAlListaSvihOdluka().get(0)), c);
        
        //dodavanje novog JpSljedeceOdluke u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 2;
        jpGlavniPanel.add(new JpSljedeceOdluke().generirajObrazac(sop, sop.getAlListaSvihOdluka().get(0), jfOdabraniSOP), c);
        
        //dodavanje jpGlavniPanel u jfOdabraniSOP
        c.gridx = 0;
        c.gridy = 0;
        jfOdabraniSOP.add(jpGlavniPanel);
        
        //postavljanje naziva i izgleda
        jfOdabraniSOP.setTitle(sop.getStrNaziv());
        MetodeMisc.postaviIzgledOstalihJf(jfOdabraniSOP);
    }
    
    /**
     * generiranje jf za sljedece odluke
     * @param sop
     * @param odlukaId 
     */
    public static void azurirajObrazac(SOP sop, String odlukaId){
        
        //inicijalizacija novog JfOdabraniSOP
        JfOdabraniSOP jfOdabraniSOP = new JfOdabraniSOP();
        
        //postavljanje poravnanja i layouta jFramea
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        //glavni panel
        JPanel jpGlavniPanel = new JPanel(new GridBagLayout());
        jpGlavniPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, sop.getStrNaziv(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        
        //dodavanje novog JpPredhodneOdluke u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 0;
        jpGlavniPanel.add(new JpPredhodneOdluke().generirajObrazac(sop, sop.dajOdlukuPoID(odlukaId), jfOdabraniSOP), c);
        
        //dodavanje novog JpTrenutnaOdluka u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 1;
        jpGlavniPanel.add(new JpTrenutnaOdluka().generirajObrazac(sop, sop.dajOdlukuPoID(odlukaId)), c);
        
        //dodavanje novog JpSljedeceOdluke u jpGlavniPanel
        c.gridx = 0;
        c.gridy = 2;
        jpGlavniPanel.add(new JpSljedeceOdluke().generirajObrazac(sop, sop.dajOdlukuPoID(odlukaId), jfOdabraniSOP), c);
        
        //dodavanje jpGlavniPanel u jfOdabraniSOP
        c.gridx = 0;
        c.gridy = 0;
        jfOdabraniSOP.add(jpGlavniPanel);
        
        //postavljanje naziva i izgleda
        jfOdabraniSOP.setTitle(sop.getStrNaziv());
        MetodeMisc.postaviIzgledOstalihJf(jfOdabraniSOP);
    }
}
