/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.Arrays;
import model.Postavke;
import model.SOP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/**
 *
 * @author ahilis001
 */
public class MetodeSOP {
    
    /**
     * 
     */
    public static void ucitajSOP(){
        
        SOP.getAlListaSvihSOP().clear();
        ArrayList<String> alListaStringovaPutanjaDatoteka = new ArrayList<>();
        alListaStringovaPutanjaDatoteka.addAll(Arrays.asList(Postavke.dajPostavku("datotekeSOP").split(",")));
    
        //pripremanje SOP-ova iz liste putanja
        for (String strPutanjaDatoteke : alListaStringovaPutanjaDatoteka) {
            pripremiSOP(Postavke.dajPostavku("putanjaSOP") + strPutanjaDatoteke);
        }
    }
    
    /**
     * priprema SOP iz datoteke
     * @param putanja
     */
    static public void pripremiSOP(String putanja){
        
        try {
            //inicijalizacija novog SOP-a
            SOP sop = new SOP();

            //otvaranje dokumenta na putanji i popunjavanje SOP-a
            Document document = (Document) Jsoup.parse(MetodeMisc.citanjeIzDatoteke(putanja).toString(),"", Parser.xmlParser());
            sop.setStrNaziv(document.select("naziv").text());
            sop.setStrNazivPDFDatotekeSOPa(document.select("PDFDatotekeSOPa").text());
            sop.setStrNazivMape(document.select("mapaSOPa").text());
            MetodePutanja.ucitajPutanjeIzDatoteke(document, sop);
            MetodeOdluka.ucitajOdlukeIzDatoteke(document, sop);

            //dodavanje SOP-a u lisu SOPova
            SOP.getAlListaSvihSOP().add(sop);
        } catch (Exception e) {
            System.out.println("ne postoji datoteka: " + Postavke.dajPostavku("putanjaSOP") + putanja);
        }
        
    }
}
