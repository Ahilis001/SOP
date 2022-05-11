/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Putanja;
import model.SOP;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Ahilis
 */
public class MetodePutanja {
    
    /**
     * učitavanje putanja iz dokumenta
     * @param document 
     * @param sop 
     */
    public static void ucitajPutanjeIzDatoteke(Document document, SOP sop){
            
        //popunjavanje liste mogućnosti
        for (Element e : document.select("putanja")) {
            Putanja putanja = new Putanja(sop, e.select("putanjaOd").text(), e.select("opis").text(), e.select("putanjaDo").text());
            sop.getAlListaSvihPutanja().add(putanja);
        }
    
    }
    
}
