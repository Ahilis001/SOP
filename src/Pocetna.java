/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controler.MetodePostavki;
import controler.MetodeSOP;
import view.jf.JfPocetnaForma;

/**
 *
 * @author Ahilis
 */
public class Pocetna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //todo maknuti postavke
        MetodePostavki.ucitajPostavke("resursi/appData/postavke.xml");
        MetodeSOP.ucitajSOP();
        
        
        
        
        
        
        
//        MetodeMisc.pripremiSOP(Postavke.getPostavke().getProperty("putanjeDatoteka"));
//        JfOdabraniSOP.generirajObrazac(SOP.getAlListaSvihSOP().get(0));
        JfPocetnaForma.generirajObrazac();
    }
    
}
