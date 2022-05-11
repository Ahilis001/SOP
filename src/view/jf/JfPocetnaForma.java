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
import javax.swing.JTextField;
import view.jp.JpDostupniSOP;
import view.jp.JpObavijestiIPostavke;

/**
 *
 * @author ahilis001
 */
public class JfPocetnaForma extends JFrame{
    
    static JTextField jtObavijesti = new JTextField();

    public JfPocetnaForma() {
    }
    
    public static void generirajObrazac(){
        
        //inicijalizacija jframea
        JfPocetnaForma jfPocetnaForma = new JfPocetnaForma();
        
        //postavljanje poravnanja i layouta jFramea
        jfPocetnaForma.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        
        //dodavanje jp na jf
        c.gridx = 0;
        c.gridy = 0;
        
        jfPocetnaForma.add(JpObavijestiIPostavke.generirajObrazac(), c);
        
        //dodavanje jp na jf
        c.gridx = 0;
        c.gridy = 1;
        
        jfPocetnaForma.add(JpDostupniSOP.generirajObrazac(), c);
        
        //postavljanje naslova i izgleda
        jfPocetnaForma.setTitle("SOP");
        MetodeMisc.postaviIzgledPocetnogJf(jfPocetnaForma);
    }

    public static JTextField getJtObavijesti() {
        return jtObavijesti;
    }

    public static void setJtObavijesti(JTextField jtObavijesti) {
        JfPocetnaForma.jtObavijesti = jtObavijesti;
    }
}
