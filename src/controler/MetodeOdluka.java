/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Odluka;
import model.SOP;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Ahilis
 */
public class MetodeOdluka {
    
    /**
     * Učitava odluke iz datoteke
     * @param document 
     * @param sop 
     */
    public static void ucitajOdlukeIzDatoteke(Document document, SOP sop){
            
        //popunjavanje liste mogućnosti
        for (Element e : document.select("odluka")) {
            Odluka odluka = new Odluka(e.select("odlukaId").text(), e.select("tekstOdluke").text(), e.select("prethodneOdlukeId").text(), e.select("sljedeceOdlukeId").text(), e.select("datoteke").text());
            sop.getAlListaSvihOdluka().add(odluka);
        }
    }
}
